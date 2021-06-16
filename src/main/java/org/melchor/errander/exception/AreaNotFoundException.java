package org.melchor.errander.exception;

public class AreaNotFoundException extends RuntimeException {

    public AreaNotFoundException(Long areaId) {
        super("area is not found. areaId: " + areaId);
    }



}
