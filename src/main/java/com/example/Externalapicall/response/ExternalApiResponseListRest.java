package com.example.Externalapicall.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExternalApiResponseListRest extends SimpleResponse {
 private List<ExternalApiResponse> externalApiResponseList;
}

