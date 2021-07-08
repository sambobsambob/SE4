package com.se4.work.uni.exception;

/**
 * An exception for if there is an invalid exception
 *
 * @author samuel.canham
 */
public class InvalidSyntaxException extends Exception {

    public InvalidSyntaxException(String msg) {
        super(msg);
    }
}
