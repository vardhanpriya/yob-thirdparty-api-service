package com.thirdparty.apiservice.service;

import com.thirdparty.apiservice.client.response.AadharMobileLinkageInfoResponse;
import com.thirdparty.apiservice.dto.AadharMobileLinkageSaveReq;
import com.thirdparty.apiservice.dto.CommonResponse;
import com.thirdparty.apiservice.entity.AadharMobileLinkageInfoEntity;

import java.io.IOException;
import java.io.InputStream;

public interface AadharMobileLinkageInfoService {

    public CommonResponse addAadharMobileLinkageIndb(AadharMobileLinkageSaveReq req);
    public AadharMobileLinkageInfoResponse fetchAadharMobileLinkageDetail(String aadhar,String mobile);

   CommonResponse bulkaddAadharMobileLinkageIndb(InputStream inputStream) throws IOException;




}
