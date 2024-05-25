package com.thirdparty.apiservice.dto;

import lombok.Data;
@Data
public class ValidateMobileOtpRequest {

    private ValidateMobileOtpReq validateMobileOtpReq;

    @Data
    public  static class ValidateMobileOtpReq{

        private String mobileOtp;

        private String transactionId;

        private String mobileNo;


    }
}
