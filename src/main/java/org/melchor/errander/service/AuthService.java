package org.melchor.errander.service;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.repository.UserRepository;
import org.melchor.errander.web.payload.LoginForm;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public boolean login(LoginForm loginForm) {
        return true;
    }

}
