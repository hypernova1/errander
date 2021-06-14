package org.melchor.errander.service;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.repository.UserRepository;
import org.melchor.errander.web.payload.JoinForm;
import org.melchor.errander.web.payload.LeaveForm;
import org.melchor.errander.web.payload.LoginForm;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;


    public boolean login(LoginForm loginForm) {
        return true;
    }

    public long join(JoinForm joinForm) {
        return 0;
    }

    public void leave(Long id, LeaveForm leaveForm) {

    }
}
