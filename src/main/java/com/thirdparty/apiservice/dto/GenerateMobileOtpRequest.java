package com.thirdparty.apiservice.dto;

import lombok.Data;

@Data
  public class GenerateMobileOtpRequest {


    private GenerateMobileOtpReq generateMobileOtpReq;

    @Data
    public  static class GenerateMobileOtpReq{

        private String mobileNo;
    }

}
