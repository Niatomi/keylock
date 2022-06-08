package ru.niatomi.exceptions.excep;

import ru.niatomi.model.domain.OpenerEntity;

/**
 * @author niatomi
 */

public class OpenerAlreadyExistsException extends RuntimeException {
    public OpenerAlreadyExistsException() {
        super("User with name this id already exists...");
    }
}
