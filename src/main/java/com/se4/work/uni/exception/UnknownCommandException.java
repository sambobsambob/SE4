package com.se4.work.uni.exception;

/**
 * An exception for if there is an unknown commad
 *
 * @author samuel.canham
 */
public class UnknownCommandException extends Exception {

    public UnknownCommandException(String msg) {
        super(msg);
    }
}
