package com.lutomiah.lendingengine.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId) {
        super("User with user ID " + userId + "not found");
    }
}
