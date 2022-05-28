package ru.niatomi.exceptions.excep;

/**
 * @author niatomi
 */
public class OpenerNotFoundException extends RuntimeException {
    public OpenerNotFoundException() {
        super("Opener not found");
    }
}
