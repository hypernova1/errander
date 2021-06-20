package org.melchor.errander.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "유저 정보를 찾을 수 없습니다.")
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("유저 정보를 찾을 수 없습니다. userId: " + id);
    }

    public UserNotFoundException(String email) {
        super("유저 정보를 찾을 수 없습니다. email: " + email);
    }

}
