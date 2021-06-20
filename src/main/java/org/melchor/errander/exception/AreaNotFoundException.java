package org.melchor.errander.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "지역 정보를 찾을 수 없습니다.")
public class AreaNotFoundException extends RuntimeException {

    public AreaNotFoundException(Long areaId) {
        super("지역 정보를 찾을 수 없습니다. areaId: " + areaId);
    }



}
