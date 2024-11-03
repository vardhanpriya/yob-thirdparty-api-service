package com.thirdparty.apiservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AadharDataClientDto {

    private AadharDataKyc kyc;

    @Data
    public static class AadharDataKyc{
        private String ret;
        private String code = UUID.randomUUID().toString();
        private  UidDataAadhar uidData;

    }

    @Data
    public static class UidDataAadhar{
        private String uid;
        private String enrolmentDate;
        private UidAadharPoi poi;
        private UidAadharPoa poa;
        private String photo;
        private UidAadharPdf pdf;

    }
    @Data
    public static class UidAadharPoi{
        private String name;
        private String dob;
        private String gender;

    }
    @Data
    public static class UidAadharPoa{
        private String co="";
        private String house="";
        private String street="";
        private String  lm="";
        private String loc="";
        private String vtc="";
        private String  dist="";
        private String  state="";
        private String pincode="";
        private String  postOfc="";

    }
    @Data
    public static class UidAadharPdf{
        private String type = "PDF";
        private String content="";

    }
}
