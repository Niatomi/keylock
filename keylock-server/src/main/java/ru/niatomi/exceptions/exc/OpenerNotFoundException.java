package ru.niatomi.exceptions.exc;

/**
 * @author niatomi
 */
public class OpenerNotFoundException extends RuntimeException {

    public OpenerNotFoundException() {
        super("Opener not found");
    }
}
