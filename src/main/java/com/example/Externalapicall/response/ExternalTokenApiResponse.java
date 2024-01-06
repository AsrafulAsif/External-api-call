package com.example.Externalapicall.response;

import lombok.Data;

@Data
public class ExternalTokenApiResponse {
    private String token_type;
    private Integer expires_in;
    private String access_token;
    private String refresh_token;
}
