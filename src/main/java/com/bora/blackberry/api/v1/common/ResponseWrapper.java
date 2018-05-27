package com.bora.blackberry.api.v1.common;

import lombok.Getter;

@Getter
public class ResponseWrapper {

    private String message;
    private Object data;

    public ResponseWrapper(String message) {
        this.message = message;
    }

    public ResponseWrapper(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public static ResponseWrapper ok() {
        return new ResponseWrapper("SUCCESS");
    }

    public static ResponseWrapper ok(Object data) {
        return new ResponseWrapper("SUCCESS", data);
    }

    public static ResponseWrapper fail(String message) {
        return new ResponseWrapper(message);
    }

    public static ResponseWrapper fail(String message, Object data) {
        return new ResponseWrapper(message, data);
    }
}
