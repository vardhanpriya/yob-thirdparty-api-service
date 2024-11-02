package com.thirdparty.apiservice.dto;

import lombok.Data;

@Data
public class AadharMobileLinkageSaveReq {
    private  String aadharNo;
    private String mobileNo;
    private String linkedValue;
}
