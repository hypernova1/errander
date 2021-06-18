package org.melchor.errander.service;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.domain.Area;
import org.melchor.errander.domain.Category;
import org.melchor.errander.domain.Errand;
import org.melchor.errander.domain.User;
import org.melchor.errander.exception.AreaNotFoundException;
import org.melchor.errander.exception.CategoryNotFoundException;
import org.melchor.errander.exception.ErrandNotFoundException;
import org.melchor.errander.exception.UserNotMatchException;
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


    public Long createErrand(ErrandForm errandForm, User user) {
        Area area = areaRepository.findById(errandForm.getAreaId())
                .orElseThrow(() -> new AreaNotFoundException(errandForm.getAreaId()));

        Category category = categoryRepository.findById(errandForm.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(errandForm.getCategoryId()));

        Errand errand = Errand.builder()
                .title(errandForm.getTitle())
                .description(errandForm.getDescription())
                .category(category)
                .area(area)
                .ordered(user)
                .build();

        return errandRepository.save(errand).getId();
    }

    public ErrandResponse getById(Long id) {
        Errand errand = errandRepository.findById(id)
                .orElseThrow(() -> new ErrandNotFoundException(id));

        return modelMapper.map(errand, ErrandResponse.class);
    }

    public void update(Long id, ErrandForm errandForm, User user) {
        Errand errand = errandRepository.findById(id)
                .orElseThrow(() -> new ErrandNotFoundException(id));

        if (errand.getOrdered() != user) {
            throw new UserNotMatchException();
        }

        Category category = categoryRepository.findById(errandForm.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(errandForm.getCategoryId()));

        errand.update(errandForm, category);
    }

    public void delete(Long id, User user) {
        Errand errand = errandRepository.findById(id)
                .orElseThrow(() -> new ErrandNotFoundException(id));

        if (errand.getOrdered() != user) {
            throw new UserNotMatchException();
        }

        errandRepository.deleteById(id);
    }
}
