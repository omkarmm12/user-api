package com.omkar.user_api.Exceptions;

public class UserNotFoundException  extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }
}
