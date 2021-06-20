package org.melchor.errander.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "심부름 정보를 찾을 수 없습니다.")
public class ErrandNotFoundException extends RuntimeException {

    public ErrandNotFoundException(Long id) {
        super("심부름 정보를 찾을 수 없습니다. errandId: " + id);
    }
}
