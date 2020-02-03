package com.pe.polindustria.asistencia.models;

public class LoginResponse {
    String message;
    Personal data;

    public LoginResponse(String message, Personal data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Personal getData() {
        return data;
    }

    public void setData(Personal data) {
        this.data = data;
    }
}
