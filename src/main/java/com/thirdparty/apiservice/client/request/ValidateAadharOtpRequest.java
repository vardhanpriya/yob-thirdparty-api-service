package com.thirdparty.apiservice.client.request;


import lombok.Data;

@Data
public class ValidateAadharOtpRequest {


    private ValidateAadharOtpReq validateAadharOtpReq;
    @Data
    public static class ValidateAadharOtpReq{

        private String aadharOtp;

        private String transactionId;

        private String aadharNo;
    }
}
