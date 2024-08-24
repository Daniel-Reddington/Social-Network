package org.acme.infrastructure.exceptions;

public class ConfirmPasswordNotCorrespond extends RuntimeException {

    public ConfirmPasswordNotCorrespond(String message) {
        super(message);
    }

}
