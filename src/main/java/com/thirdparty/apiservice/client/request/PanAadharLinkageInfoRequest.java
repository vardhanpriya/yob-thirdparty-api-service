package com.thirdparty.apiservice.client.request;

import lombok.Data;

@Data

public class PanAadharLinkageInfoRequest {

    private String panNo;
    private String aadharNo;
    private String consent;
}
