package com.example.Externalapicall.response;

import lombok.Data;

@Data
public class MyCustomTokenResponse extends SimpleResponse{
   private ExternalTokenApiResponse data;
}
