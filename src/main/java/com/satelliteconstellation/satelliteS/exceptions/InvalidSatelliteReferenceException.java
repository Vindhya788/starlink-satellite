package com.satelliteconstellation.satelliteS.exceptions;

public class InvalidSatelliteReferenceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidSatelliteReferenceException(String errorMessage) {
        super(errorMessage);
    }
}
