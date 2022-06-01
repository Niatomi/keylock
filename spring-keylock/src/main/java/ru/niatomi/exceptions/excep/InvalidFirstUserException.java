package ru.niatomi.exceptions.excep;

/**
 * @author niatomi
 */
public class InvalidFirstUserException extends RuntimeException{
    public InvalidFirstUserException() {
        super("First user is not using for changing");
    }
}
