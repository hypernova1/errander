package org.melchor.errander.exception;

public class ErrandNotFoundException extends RuntimeException {

    public ErrandNotFoundException(Long id) {
        super("errand is not found. id: " + id);
    }
}
