package com.example.Externalapicall.response;

import lombok.Data;

@Data
public class ExternalApiResponse{
    private Integer id;
    private String title;
    private String body;
    private Integer userId;
}
