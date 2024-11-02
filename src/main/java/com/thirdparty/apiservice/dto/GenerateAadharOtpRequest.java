package com.thirdparty.apiservice.dto;

import lombok.Data;

@Data
public class GenerateAadharOtpRequest {


  private  GenerateAadharOtpReq  generateAadharOtpReq;
  @Data
  public static class GenerateAadharOtpReq{

      private String aadharNo;


    }

}
