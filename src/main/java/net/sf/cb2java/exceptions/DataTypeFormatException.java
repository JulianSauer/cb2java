package net.sf.cb2java.exceptions;

/**
 * Checked exception if input data doesn't match copybook definition
 */
public class DataTypeFormatException extends Throwable {
  public DataTypeFormatException(String message) {
    super(message);
  }
}
