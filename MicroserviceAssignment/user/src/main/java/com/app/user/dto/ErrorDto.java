package com.app.user.dto;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDto {
    private HttpStatus status;
    private String message;
    private Date currentDate;

    public ErrorDto() {
    }

    public ErrorDto(HttpStatus status, String message, Date currentDate) {
        this.status = status;
        this.message = message;
        this.currentDate = currentDate;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
