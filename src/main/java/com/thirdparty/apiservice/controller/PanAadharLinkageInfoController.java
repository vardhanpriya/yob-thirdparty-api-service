package com.thirdparty.apiservice.controller;

import com.thirdparty.apiservice.client.request.PanAadharLinkageInfoRequest;
import com.thirdparty.apiservice.client.response.PanAadharLinkageInfoResponse;
import com.thirdparty.apiservice.dto.CommonResponse;
import com.thirdparty.apiservice.dto.PanAadharLinkSaveReq;
import com.thirdparty.apiservice.service.PanAadharLinkageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pan-service")
public class PanAadharLinkageInfoController {
    @Autowired
    private PanAadharLinkageInfoService panAadharLinkageInfoService;
    @PostMapping(path = "/add-update/details")
    public ResponseEntity<CommonResponse> addPanAadharDetailsIndb(@RequestBody PanAadharLinkSaveReq req) {
        CommonResponse resp = panAadharLinkageInfoService.addPanAadharLinkedInfoIndb(req);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


    @PostMapping(path = "/fetch/pan-aadhar-link")
    public ResponseEntity<PanAadharLinkageInfoResponse> fetchPanAadharLinkDetails(@RequestBody PanAadharLinkageInfoRequest req, @RequestHeader String source) {
       if(!source.equalsIgnoreCase("YOB")){
           PanAadharLinkageInfoResponse res=PanAadharLinkageInfoResponse.buildPanAadharErrorResponse(
                   401,"Unautorized access","Karza","Not allowed to Access API");
           return new ResponseEntity<>(res,HttpStatus.OK);
       }

        PanAadharLinkageInfoResponse   resp = panAadharLinkageInfoService.fetchPanAadharLinkageDetail(req.getPanNo(), req.getAadharNo());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


}
