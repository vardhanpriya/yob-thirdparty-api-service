package com.thirdparty.apiservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateAadharOtpResponse {

    private GenerateAadharOtpRes  generateAadharOtpRes;

    @Data

    public static class GenerateAadharOtpRes{

        private GenAadharOtpMetaData metaData;

       private GenAadharOtpResourceData resourceData;
    }
      @Data

    public static class GenAadharOtpMetaData {

        private String status;

        private String message;

        private String version;

        private String code;

        private String time;

      }

      @Data

    public static class GenAadharOtpResourceData{

        private String aadharOtp;

        private String transactionId;

        private String message;

        private String statusCode;

      }


}
/**
 * {
 * "generateMobileOtpRes": {
 * "metaData": {
 * "status": "",
 * "message": "",
 * "version": "",
 * "code": "",
 * "time": ""
 * },
 * "resourceData": {
 * "mobileOtp": "",
 * "transctionId": "",
 * "message": "",
 * "statusCode": ""
 * }
 * }
 * }
 * {
 * "generateMobileOtpReq":{
 * "mobileNo":"hgdkcfhgdcgfn",
 * }
 * }
 */