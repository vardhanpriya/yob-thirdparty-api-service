package com.thirdparty.apiservice.client.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class AadharMobileLinkageInfoResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String reason;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String service;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String details;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EkycAuthenticationResp ekycAuthenticationResp;

    @Data
    public static  class EkycAuthenticationResp{
        private AadharMobileLinkageMetadata metadata;
        private AadharMobileLinkageResource_data resourceData;
    }
    @Data
    public static class AadharMobileLinkageMetadata {
        private String status;
        private String message;
        private String version = "v2";
        private String code;
    }
    @Data
    public static class AadharMobileLinkageResource_data {
        private String code;
        private String status;
    }

    public static AadharMobileLinkageInfoResponse buildAadharMobileErrorResponse(Integer code,String reason,String service,String details){
        AadharMobileLinkageInfoResponse errorResponse=new AadharMobileLinkageInfoResponse();
        errorResponse.setCode(code);
        errorResponse.setReason(reason);
        errorResponse.setService(service);
        errorResponse.setDetails(details);
        return errorResponse;


    }
    public static AadharMobileLinkageInfoResponse buildAadharMobileLinkageInfoResponse(
            String metaStatus,String metaMsg,String metaCode,String rescd,String resSts) {
        AadharMobileLinkageInfoResponse response = new AadharMobileLinkageInfoResponse();
        EkycAuthenticationResp authenticationResp = new EkycAuthenticationResp();
        AadharMobileLinkageMetadata metadata = new AadharMobileLinkageMetadata();
        metadata.setStatus(metaStatus);
        metadata.setMessage(metaMsg);
        metadata.setCode(metaCode);
        authenticationResp.setMetadata(metadata);
        AadharMobileLinkageResource_data resourceData = new AadharMobileLinkageResource_data();
        resourceData.setCode(rescd);
        resourceData.setStatus(resSts);
        authenticationResp.setResourceData(resourceData);
        response.setEkycAuthenticationResp(authenticationResp);
        return response;
    }

}
