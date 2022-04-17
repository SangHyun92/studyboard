package com.study.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	/*
     * 400 BAD_REQUEST
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "404 : bad request"),

    /*
     * 404 NOT_FOUND
     */
    POSTS_NOT_FOUND(HttpStatus.NOT_FOUND, "404 : posts not found"),
    
    /*
     * 404 NOT_FOUND
     */
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "404 : comments not found"),

    /*
     * 405 METHOD_NOT_ALLOWED=
     */
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "405 : method not allowed"),

    /*
     * 500 INTERNAL_SERVER_ERROR=
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500 : internal server error"),

    ;

    private final HttpStatus status;
    private final String message;
}
