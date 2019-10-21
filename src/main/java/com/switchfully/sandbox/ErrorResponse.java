package com.switchfully.sandbox;

public class ErrorResponse {

    private String statusCode;
    private String message;
    private String uniqueErrorCode;

    public String getStatusCode() {
        return statusCode;
    }

    public ErrorResponse setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUniqueErrorCode() {
        return uniqueErrorCode;
    }

    public ErrorResponse setUniqueErrorCode(String uniqueErrorCode) {
        this.uniqueErrorCode = uniqueErrorCode;
        return this;
    }
}
