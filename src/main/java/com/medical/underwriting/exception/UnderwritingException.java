package com.medical.underwriting.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@AllArgsConstructor
@Getter
public class UnderwritingException extends RuntimeException {

    /**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	
	private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

}
