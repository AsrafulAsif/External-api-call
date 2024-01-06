package com.example.Externalapicall.service;

import com.example.Externalapicall.response.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;


@Service
public class ExternalCallApiService {

    public ExternalApiResponseListRest getAllDataFromExternalApi() {
        ExternalApiResponseListRest response = new ExternalApiResponseListRest();
        response.setStatusCode(200);
        response.setMessage("Successfully fetch data!");
        String url = "https://jsonplaceholder.typicode.com/posts";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<ExternalApiResponse[]> responseREST = restTemplate.exchange(url, HttpMethod.GET, entity, ExternalApiResponse[].class);
        response.setExternalApiResponseList(Arrays.asList(Objects.requireNonNull(responseREST.getBody())));
        return response;
    }

//    public ExternalApiResponse getOneDataFromExternalApi(String id) {
//        ExternalApiResponse response = new ExternalApiResponse();
//        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Object> entity = new HttpEntity<>(headers);
//        ResponseEntity<? extends SimpleResponse> responseREST = restTemplate.exchange(url, HttpMethod.GET, entity, ExternalApiResponse.class);
//        response =  (ExternalApiResponse) responseREST.getBody();
//        assert response != null;
//        response.statusCode = 200;
//        response.message = "Successfully fetch data!";
//        return response;
//    }

    public <U,T> T doRest(String url, HttpMethod httpMethod, U request, Class<T> responseType ) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(request,headers);
        ResponseEntity<T> responseREST = restTemplate.exchange(url, httpMethod, entity, responseType);
        return responseREST.getBody();
    }

//    public Object getData(String url, HttpMethod httpMethod, Object request , Class<?> responseType){
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Object> entity = new HttpEntity<>(request,headers);
//        ResponseEntity<?> responseRest = restTemplate.exchange(url,httpMethod,entity,responseType);
//        return responseRest.getBody();
//    }
}
