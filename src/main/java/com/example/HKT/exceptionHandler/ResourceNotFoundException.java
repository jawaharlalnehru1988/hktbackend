package com.example.HKT.exceptionHandler;

public class ResourceNotFoundException extends RuntimeException{
public ResourceNotFoundException(String message){
    super(message);
}
}
