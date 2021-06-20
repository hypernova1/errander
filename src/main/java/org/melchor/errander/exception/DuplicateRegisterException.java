package org.melchor.errander.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "심부름을 시킨 사람과 심부름할 유저가 같습니다.")
public class DuplicateRegisterException extends RuntimeException {

    public DuplicateRegisterException() {
        super("심부름을 시킨 사람과 심부름할 유저 같습니다.");
    }
}
