package org.example.lab4.exceptions;

public class FileReadException extends Exception{
    private final static String ERROR_DISC = "File read exception";

    public FileReadException() {
        super(ERROR_DISC);
    }
}

