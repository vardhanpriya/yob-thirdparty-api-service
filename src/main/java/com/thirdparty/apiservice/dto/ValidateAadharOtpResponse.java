package com.thirdparty.apiservice.dto;

import lombok.Data;

@Data
public class ValidateAadharOtpResponse {

    private ValidateAadharOtpRes validateAadharOtpRes;
    @Data
    public  static  class ValidateAadharOtpRes{

        private  ValidataAadharOtpMetaData metadata;

        private ValidataAadharOtpResourceData resourceData;
    }

    @Data
     public static class ValidataAadharOtpMetaData{

         private String status;

         private String message;

         private String version;

         private String code;

         private String time;



     }
      @Data
     public static class ValidataAadharOtpResourceData{

        private String message;

        private String statusCode;

        private String errorCode;

        private CustomerData customerData;

     }
     @Data
     public static class CustomerData{


        private String aadharName;

        private String aadharNo;

        private String aadharData;
     }
}
