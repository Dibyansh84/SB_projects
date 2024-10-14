package com.example.hospital.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse
{
    //ErrorResponse class will act as a template for error messages.
    private int statusCode;
    private String message;
}
