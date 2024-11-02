package com.thirdparty.apiservice.client.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.UUID;

@Data
public class PanAadharLinkageInfoResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String reason;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String service;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String details;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PanAadharLinkageMetadata metadata;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PanAadharLinkageResource_data resource_data;

    @Data
    public static class PanAadharLinkageMetadata {
        private String status;
        private String message;
        private String version = "v1";

    }

    @Data
    public static class PanAadharLinkageResource_data {
        private PanAadharLinkageResourceResult result;
        private String requestId = UUID.randomUUID().toString();
        private Integer statusCode;
        private String serviceProvider = "Karza";

    }

    @Data
    public static class PanAadharLinkageResourceResult {
        private String message;
        private boolean linked;
    }

    public static PanAadharLinkageInfoResponse buildPanAadharErrorResponse(Integer code,String reason,String service,String details){
        PanAadharLinkageInfoResponse errorResponse=new PanAadharLinkageInfoResponse();
        errorResponse.setCode(code);
        errorResponse.setReason(reason);
        errorResponse.setService(service);
        errorResponse.setDetails(details);
        return errorResponse;


    }

    public static PanAadharLinkageInfoResponse buildPanAadharLinkageInfoResponse(
            String metaMsg, String metaSts, String resltMsg, boolean linked, Integer resourceStsCd) {
        PanAadharLinkageInfoResponse response = new PanAadharLinkageInfoResponse();

        PanAadharLinkageMetadata metadata = new PanAadharLinkageMetadata();
        metadata.setMessage(metaMsg);
        metadata.setStatus(metaSts);
        response.setMetadata(metadata);

        PanAadharLinkageResource_data resourceData = new PanAadharLinkageResource_data();

        resourceData.setStatusCode(resourceStsCd);
        PanAadharLinkageResourceResult resourceResult = new PanAadharLinkageResourceResult();

        if (metaSts.equalsIgnoreCase("SUCCESS")) {
            resourceResult.setMessage(resltMsg);
            resourceResult.setLinked(linked);
            resourceData.setResult(resourceResult);
        }
        response.setResource_data(resourceData);
        return response;
    }


}
