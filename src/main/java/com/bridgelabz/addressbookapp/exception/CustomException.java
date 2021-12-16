package com.bridgelabz.addressbookapp.exception;

/**
 * Purpose : To demonstrate the message shown through CustomException if it is occurred
 *
 * @author : Sampriti Roy Chowdhury
 * @version : 0.0.1
 * @since : 15-12-2021
 */

public class CustomException extends RuntimeException{

    /**
     * Purpose : This method is used to define the message used to throw during exception
     *
     * @param message defines the exception message
     */
    public CustomException(String message) {
        super(message);
    }
}
