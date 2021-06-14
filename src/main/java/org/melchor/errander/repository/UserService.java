package org.melchor.errander.repository;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.domain.User;
import org.melchor.errander.exception.UserNotFoundException;
import org.melchor.errander.web.payload.UserDetail;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDetail findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return modelMapper.map(user, UserDetail.class);
    }
}
