package org.melchor.errander.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "카테고리를 찾을 수 없습니다.")
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long categoryId) {
        super("카테고리를 찾을 수 없습니다. categoryId: " + categoryId);
    }
}
