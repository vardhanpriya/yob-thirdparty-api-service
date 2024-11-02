package com.thirdparty.apiservice.client.request;

import com.thirdparty.apiservice.client.response.AadharMobileLinkageInfoResponse;
import lombok.Data;

@Data
public class AadharMbileLinkageInfoRequest {
    private EkycAuthenticationReq ekycAuthenticationReq;
    @Data
    public static class EkycAuthenticationReq {
        private String aadharNo;
        private String mobileNo;
    }
}