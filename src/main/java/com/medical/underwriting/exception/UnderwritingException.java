package com.medical.underwriting.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class UnderwritingException extends RuntimeException {

    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

}
