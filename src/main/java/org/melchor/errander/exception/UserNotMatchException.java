package org.melchor.errander.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "등록한 유저와 인증된 유저가 같지 않습니다.")
public class UserNotMatchException extends RuntimeException {

    public UserNotMatchException() {
        super("등록한 유저와 인증된 유저가 같지 않습니다.");
    }
}
