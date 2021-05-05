package com.technical.test.app.dto;

public class Response {



    private String message;
    private Integer status;
    private Object data;
    private String error;


    public String getMessage() {
        return message;
    }

    public Response setMessage(final String message) {
        this.message = message;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Response setStatus(final Integer status) {
        this.status = status;
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
