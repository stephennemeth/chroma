package com.chroma.backend.entities.response;

public class Response {
    public String message;

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
