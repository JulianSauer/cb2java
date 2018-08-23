package net.sf.cb2java.exceptions;

/**
 * Checked exception if length of input doesn't match copybook definition
 */
public class InputLengthException extends Throwable {
    public InputLengthException(String message) {
        super(message);
    }
}
