package com.thirdparty.apiservice.dto;

import lombok.Data;

@Data
public class PanAadharLinkSaveReq {
    private String panNo;
    private String aadharNo;
    private String linked;
}
