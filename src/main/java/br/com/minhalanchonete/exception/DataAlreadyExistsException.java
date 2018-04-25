package br.com.minhalanchonete.exception;

public class DataAlreadyExistsException extends Exception {

    public DataAlreadyExistsException() {
    }

    public DataAlreadyExistsException(String message) {
        super(message);
    }

}
