package org.melchor.errander.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long categoryId) {
        super("category is not found. categoryId: " + categoryId);
    }
}
