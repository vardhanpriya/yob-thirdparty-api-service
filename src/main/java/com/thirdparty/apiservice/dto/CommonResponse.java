package com.thirdparty.apiservice.dto;

import lombok.Data;

@Data
public class CommonResponse {
    private String status;
    private String message;
    private String statusCode;

 public static CommonResponse buildCommonResponse(String status,String message,String statusCode){
     CommonResponse commonResponse=new CommonResponse();
     commonResponse.setMessage(message);
     commonResponse.setStatus(status);
     commonResponse.setStatusCode(statusCode);
     return commonResponse;

 }

}
