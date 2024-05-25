package com.thirdparty.apiservice.dto;

import lombok.Data;

@Data
public class ValidateMobileOtpResponse {

    private ValidateMobileOtpRes validateMobileOtpRes;

    @Data

    public static class ValidateMobileOtpRes{

        private ValidateMobileOtpMetaData metadata;
        private ValidateMobileOtpResourceData resourceData;

    }
    @Data
    public static class ValidateMobileOtpMetaData{

        private String status;

        private String message;

        private String version;

        private String code;

        private String time;

    }

    @Data
    public static class ValidateMobileOtpResourceData{


        private String message;

        private String statusCode;


    }



}
