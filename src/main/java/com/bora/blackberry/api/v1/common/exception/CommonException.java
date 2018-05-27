package com.bora.blackberry.api.v1.common.exception;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

    private String message;
    private Object data;

    public CommonException(String message) {
        this.message = message;
    }

    public CommonException(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
