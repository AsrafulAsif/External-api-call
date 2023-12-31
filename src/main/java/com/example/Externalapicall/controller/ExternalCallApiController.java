package com.example.Externalapicall.controller;

import com.example.Externalapicall.response.ExternalApiResponse;
import com.example.Externalapicall.response.MyCustomResponseRest;
import com.example.Externalapicall.response.SimpleResponse;
import com.example.Externalapicall.service.ExternalCallApiService;
import com.example.Externalapicall.util.MakingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        ExternalApiResponse externalApiResponse = externalCallApiService.getData(
                "https://jsonplaceholder.typicode.com/posts/"+id,HttpMethod.GET,null,ExternalApiResponse.class);
        MyCustomResponseRest response = new MyCustomResponseRest();
        response.setData(externalApiResponse);
        return MakingResponse.makingResponse(response);
    }
}
