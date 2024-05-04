package com.thirdparty.apiservice.dto;

import lombok.Data;

@Data
public class GenerateMobileOtpResponse {


  private GenerateMobileOtpRes generateMobileOtpRes;

  @Data
    public static class GenerateMobileOtpRes{

        private GenerateMobileOtpMetaData metaData;
        private GenerateMobileOtpResourceData resourceData;


    }

    @Data
    public static class GenerateMobileOtpMetaData{

        private String status;

        private String message;

        private String version;

        private String code;

        private String time;


    }

    @Data
    public static class GenerateMobileOtpResourceData{

        private String mobileOtp;

        private String transactionId;

        private String message;

        private String statusCode;



    }
}
