package org.melchor.errander.repository;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.domain.LeaveLog;
import org.melchor.errander.domain.User;
import org.melchor.errander.exception.UserNotFoundException;
import org.melchor.errander.web.payload.JoinForm;
import org.melchor.errander.web.payload.LeaveForm;
import org.melchor.errander.web.payload.UpdateForm;
import org.melchor.errander.web.payload.UserDetail;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LeaveLogRepository leaveLogRepository;
    private final ModelMapper modelMapper;

    public UserDetail findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return modelMapper.map(user, UserDetail.class);
    }

    public long register(JoinForm joinForm) {
        User user = modelMapper.map(joinForm, User.class);

        return userRepository.save(user).getId();
    }


    public void deleteById(Long id, LeaveForm leaveForm) {
        LeaveLog log = modelMapper.map(leaveForm, LeaveLog.class);

        leaveLogRepository.save(log);

        userRepository.deleteById(id);
    }

    public void update(Long id, UpdateForm updateForm) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.update(updateForm);
    }
}
