package com.example.Horarios.utils.ErrorResponse;

import java.util.List;

public class ErrorResponseModel {
    private int status;

    private String message;

    List<String> errors;

    ErrorResponseModel(String message) {
        this.message = message;
    }

    public ErrorResponseModel() {
    }

    public ErrorResponseModel(int status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
