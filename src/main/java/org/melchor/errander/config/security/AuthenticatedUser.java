package org.melchor.errander.config.security;

import lombok.Getter;
import org.melchor.errander.domain.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.stream.Collectors;

@Getter
public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public AuthenticatedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList()));

        this.user = user;
    }


}
