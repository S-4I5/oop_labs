package org.example.lab4.exceptions;

public class InvalidFileFormatException extends Exception {
    private final static String ERROR_DISC = "Invalid file format";

    public InvalidFileFormatException() {
        super(ERROR_DISC);
    }
}
