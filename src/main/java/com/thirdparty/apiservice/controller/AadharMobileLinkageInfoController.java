package com.thirdparty.apiservice.controller;

import com.thirdparty.apiservice.client.request.AadharMbileLinkageInfoRequest;
import com.thirdparty.apiservice.client.response.AadharMobileLinkageInfoResponse;
import com.thirdparty.apiservice.dto.AadharMobileLinkageSaveReq;
import com.thirdparty.apiservice.dto.CommonResponse;
import com.thirdparty.apiservice.dto.PanAadharLinkSaveReq;
import com.thirdparty.apiservice.service.AadharMobileLinkageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aadhar-mobile-link/service")
public class AadharMobileLinkageInfoController {

    @Autowired
    private AadharMobileLinkageInfoService service;

    @PostMapping(path = "/add-update/details")
    public ResponseEntity<CommonResponse> addAadhaMobileDetailsIndb(@RequestBody AadharMobileLinkageSaveReq req) {
        CommonResponse resp= service.addAadharMobileLinkageIndb(req);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    @PostMapping(path = "/fetch/aadhar-mobile/linkage")
    public ResponseEntity<AadharMobileLinkageInfoResponse> fetchAadharMobileLinkage(@RequestBody AadharMbileLinkageInfoRequest req) {
        AadharMobileLinkageInfoResponse resp= service.fetchAadharMobileLinkageDetail(req.getEkycAuthenticationReq().getAadharNo(),req.getEkycAuthenticationReq().getMobileNo());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }



}
