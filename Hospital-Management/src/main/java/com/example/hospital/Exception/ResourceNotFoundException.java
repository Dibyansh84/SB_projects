package com.example.hospital.Exception;

public class ResourceNotFoundException extends RuntimeException
{
    //You can create custom exceptions for handling scenarios such as a resource not found or bad request.

    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
