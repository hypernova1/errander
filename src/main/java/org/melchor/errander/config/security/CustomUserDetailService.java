package org.melchor.errander.config.security;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.domain.User;
import org.melchor.errander.exception.UserNotFoundException;
import org.melchor.errander.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));

        return new AuthenticatedUser(user);
    }
}
