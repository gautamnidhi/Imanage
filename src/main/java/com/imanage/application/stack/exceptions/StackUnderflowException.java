package com.imanage.application.stack.exceptions;

/**
 * @author Nidhi Gautam 4/21/21
 */
public class StackUnderflowException extends Exception {
    public StackUnderflowException(String errMessage) {
        super(errMessage);
    }
}
