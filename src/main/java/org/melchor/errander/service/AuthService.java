package org.melchor.errander.service;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.config.security.JwtTokenProvider;
import org.melchor.errander.domain.User;
import org.melchor.errander.exception.AppException;
import org.melchor.errander.web.payload.LoginForm;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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

    private final RedisTemplate<String, String> redisTemplate;

    public String login(LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getEmail(),
                        loginForm.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generationToken(authentication);

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        valueOperations.set(loginForm.getEmail(), token);
        return token;
    }

    public void logout(User user) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        if (valueOperations.get(user.getEmail()) == null) {
            throw new AppException("로그아웃 할 수 없습니다.");
        }
        redisTemplate.delete(user.getEmail());
    }
}
