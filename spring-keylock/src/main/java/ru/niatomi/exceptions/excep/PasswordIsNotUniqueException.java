package ru.niatomi.exceptions.excep;

/**
 * @author niatomi
 */
public class PasswordIsNotUniqueException extends RuntimeException{
    public PasswordIsNotUniqueException() {
        super("Password with this type is not unique");
    }
}
