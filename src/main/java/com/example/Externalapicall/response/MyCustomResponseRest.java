package com.example.Externalapicall.response;

import lombok.Data;

@Data
public class MyCustomResponseRest extends SimpleResponse{
    private ExternalApiResponse data;
}
