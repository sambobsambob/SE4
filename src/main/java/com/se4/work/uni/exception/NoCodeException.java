package com.se4.work.uni.exception;

/**
 * An exception for if there is no code provided
 *
 * @author samuel.canham
 */
public class NoCodeException extends Exception {

    public NoCodeException(String msg) {
        super(msg);
    }
}
