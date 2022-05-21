package ru.niatomi.exceptions;

import ru.niatomi.model.domain.OpenerEntity;

/**
 * @author niatomi
 */
public class OpenerAlreadyExistsException extends Exception {
    public OpenerAlreadyExistsException(OpenerEntity openerEntity) {
        super("User with name this name already exists...");
    }
}
