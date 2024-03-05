package org.cqrs.cinema;

class CinemaDomainException extends RuntimeException {

    CinemaDomainException(String message) {
        super(message);
    }
}
