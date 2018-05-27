package com.bora.blackberry.api.v1.common.handler;

import com.bora.blackberry.api.v1.common.ResponseWrapper;
import com.bora.blackberry.api.v1.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)  // 503
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public ResponseWrapper handleCommonException(HttpServletRequest request, CommonException ex) {

        log.error("===== handleCommonException ====");
        log.error("message: {}", ex.getMessage());

        return ResponseWrapper.fail(ex.getMessage(), ex.getData());
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseWrapper handleInternalException(HttpServletRequest request, Exception ex) {

        log.error("===== handleInternalException ====");
        log.error("ex: {}", ex);

        return ResponseWrapper.fail(ex.getMessage());
    }
}
