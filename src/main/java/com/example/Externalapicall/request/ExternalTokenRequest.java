package com.example.Externalapicall.request;

import lombok.Data;

@Data
public class ExternalTokenRequest {
    private String client_id = "267";
    private String client_secret = "wRcaibZkUdSNz2EI9ZyuXLlNrnAv0TdPUPXMnD39";
    private String username = "test@pathao.com";
    private String password = "lovePathao";
    private String grant_type = "password";
}
