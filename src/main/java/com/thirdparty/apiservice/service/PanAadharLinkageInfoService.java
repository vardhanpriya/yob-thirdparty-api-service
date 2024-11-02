package com.thirdparty.apiservice.service;

import com.thirdparty.apiservice.client.response.PanAadharLinkageInfoResponse;
import com.thirdparty.apiservice.dto.CommonResponse;
import com.thirdparty.apiservice.dto.PanAadharLinkSaveReq;

public interface PanAadharLinkageInfoService {

    public CommonResponse addPanAadharLinkedInfoIndb(PanAadharLinkSaveReq saveReq);

    public PanAadharLinkageInfoResponse fetchPanAadharLinkageDetail(String pan,String aadhar);
}

