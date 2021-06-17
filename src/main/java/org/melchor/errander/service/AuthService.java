package org.melchor.errander.service;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.config.security.JwtTokenProvider;
import org.melchor.errander.web.payload.LoginForm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public String login(LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getEmail(),
                        loginForm.getPassword();
                )
        )
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generationToken(authentication);
    }

}
