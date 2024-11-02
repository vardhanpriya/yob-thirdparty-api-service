package com.thirdparty.apiservice.client.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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


    public static ValidateAadharOtpResponse buildValidateAadharOtpResponse(String resourceSts,String encAadahrNo,
                                                                           String encAadharName,String encAadharData ){
        ValidateAadharOtpResponse response = new ValidateAadharOtpResponse();
        ValidateAadharOtpRes res = new ValidateAadharOtpRes();

        ValidataAadharOtpMetaData metadata = new ValidataAadharOtpMetaData();
        metadata.setMessage("Request Processed Successfully");
        metadata.setStatus("SUCCESS");
        metadata.setVersion("v1");
        metadata.setTime(LocalDateTime.now().toString());
        metadata.setCode("200");
        res.setMetadata(metadata);

        List<ValidataAadharOtpResourceData> resource_dataList = new ArrayList<>();

        ValidataAadharOtpResourceData resourceData = new ValidataAadharOtpResourceData();
        resourceData.setStatus(resourceSts);
        resourceData.setCode(UUID.randomUUID().toString());
        resourceData.setTransaction(UUID.randomUUID().toString());
        resourceData.setAadharNumber(encAadahrNo);
        resourceData.setAadharName(encAadharName);
        resourceData.setAadharData(encAadharData);
        resource_dataList.add(resourceData);

        res.setResource_data(resource_dataList);
        response.setVerifyAadhaarResp(res);
        return response;
    }
}
