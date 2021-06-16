package org.melchor.errander.service;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.domain.Area;
import org.melchor.errander.domain.Category;
import org.melchor.errander.domain.Errand;
import org.melchor.errander.exception.AreaNotFoundException;
import org.melchor.errander.exception.CategoryNotFoundException;
import org.melchor.errander.exception.ErrandNotFoundException;
import org.melchor.errander.repository.AreaRepository;
import org.melchor.errander.repository.CategoryRepository;
import org.melchor.errander.repository.ErrandRepository;
import org.melchor.errander.web.payload.ErrandForm;
import org.melchor.errander.web.payload.ErrandResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ErrandService {

    private final ErrandRepository errandRepository;
    private final CategoryRepository categoryRepository;
    private final AreaRepository areaRepository;
    private final ModelMapper modelMapper;


    public Long createErrand(ErrandForm errandForm) {
        Area area = areaRepository.findById(errandForm.getAreaId())
                .orElseThrow(() -> new AreaNotFoundException(errandForm.getAreaId()));

        Category category = categoryRepository.findById(errandForm.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(errandForm.getCategoryId()));

        Errand errand = Errand.builder()
                .title(errandForm.getTitle())
                .description(errandForm.getDescription())
                .category(category)
                .orderer(null)
                .build();

        return errandRepository.save(errand).getId();
    }

    public ErrandResponse getById(Long id) {
        Errand errand = errandRepository.findById(id)
                .orElseThrow(() -> new ErrandNotFoundException(id));

        return modelMapper.map(errand, ErrandResponse.class);
    }

    public void update(Long id, ErrandForm errandForm) {
        Errand errand = errandRepository.findById(id)
                .orElseThrow(() -> new ErrandNotFoundException(id));

        errand.update(errandForm);
    }

    public void delete(Long id) {
        errandRepository.deleteById(id);
    }
}
