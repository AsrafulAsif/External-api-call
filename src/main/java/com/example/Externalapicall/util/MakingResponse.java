package com.example.Externalapicall.util;


import com.example.Externalapicall.response.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MakingResponse {
    public static void makingSuccessMessage(String message, SimpleResponse response){
        response.message = message;
        response.statusCode = 200;
    }
    public static ResponseEntity<SimpleResponse> makingResponse(SimpleResponse response){
        makingSuccessMessage("Successful",response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
