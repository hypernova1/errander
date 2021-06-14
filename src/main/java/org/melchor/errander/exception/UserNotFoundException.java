package org.melchor.errander.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("user is not found. id: " + id);
    }

}
