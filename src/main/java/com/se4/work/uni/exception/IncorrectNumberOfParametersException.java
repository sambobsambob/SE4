package com.se4.work.uni.exception;

/**
 * An exception for if there are not enough parameters provided
 *
 * @author samuel.canham
 */
public class IncorrectNumberOfParametersException extends Exception {

    public IncorrectNumberOfParametersException(String msg) {
        super(msg);
    }
}
