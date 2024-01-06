package com.example.Externalapicall.controller;

import com.example.Externalapicall.request.ExternalTokenRequest;
import com.example.Externalapicall.response.*;
import com.example.Externalapicall.service.ExternalCallApiService;
import com.example.Externalapicall.util.MakingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/external-api-call")
public class ExternalCallApiController {
    private final ExternalCallApiService externalCallApiService;

    @GetMapping
    public ResponseEntity<SimpleResponse> getAllDataFromExternalApi(){
        return ResponseEntity.ok(externalCallApiService.getAllDataFromExternalApi());
    }
    @GetMapping("{id}")
    public ResponseEntity<SimpleResponse> getOneDataFromExternalApi(@PathVariable String id){
        ExternalApiResponse externalApiResponse =  externalCallApiService.doRest(
                "https://jsonplaceholder.typicode.com/posts/"+id,HttpMethod.GET,null,ExternalApiResponse.class);
        MyCustomResponseRest response = new MyCustomResponseRest();
        response.setData(externalApiResponse);
        return MakingResponse.makingResponse(response);
    }

    @PostMapping()
    public ResponseEntity<SimpleResponse> getToken(){
        MyCustomTokenResponse response = new MyCustomTokenResponse();
        ExternalTokenApiResponse externalApiResponse = externalCallApiService.doRest(
                "https://courier-api-sandbox.pathao.com/aladdin/api/v1/issue-token",HttpMethod.POST, new ExternalTokenRequest(),ExternalTokenApiResponse.class);
        response.setData(externalApiResponse);
        return MakingResponse.makingResponse(response);
    }
}
