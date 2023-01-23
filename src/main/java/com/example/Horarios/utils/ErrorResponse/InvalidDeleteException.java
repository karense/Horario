package com.example.Horarios.utils.ErrorResponse;


public class InvalidDeleteException extends RuntimeException{
    public InvalidDeleteException() {
        super();
    }

    public InvalidDeleteException(String message) {
        super(message);
    }
}
