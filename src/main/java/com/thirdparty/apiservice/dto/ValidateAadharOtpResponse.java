package com.thirdparty.apiservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class ValidateAadharOtpResponse {

    private ValidateAadharOtpRes verifyAadhaarResp;

    @Data
    public static class ValidateAadharOtpRes {

        private ValidataAadharOtpMetaData metadata;

        private List<ValidataAadharOtpResourceData> resource_data;
    }

    @Data
    public static class ValidataAadharOtpMetaData {

        private String status;

        private String message;

        private String version;

        private String code;

        private String time;


    }

    @Data
    public static class ValidataAadharOtpResourceData {

        private String status;

        private String code;

        private String transaction;


        private String aadharNumber;

        private String aadharName;

        private String aadharData;

    }
}
