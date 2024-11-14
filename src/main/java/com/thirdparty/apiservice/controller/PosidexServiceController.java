package com.thirdparty.apiservice.controller;

import com.thirdparty.apiservice.client.request.CheckGenericDedupeRequest;
import com.thirdparty.apiservice.dto.CommonResponse;
import com.thirdparty.apiservice.dto.PanAadharLinkSaveReq;
import com.thirdparty.apiservice.entity.PosidexCustomerAadharRef;
import com.thirdparty.apiservice.entity.PosidexCustomerDetails;
import com.thirdparty.apiservice.service.PosidexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posidex")
public class PosidexServiceController {

    @Autowired
    PosidexService posidexService;

    @PostMapping(path = "/customer/dedupe")
    public ResponseEntity<CommonResponse> posidexCustomerDedupe(@RequestBody CheckGenericDedupeRequest req) {
        posidexService.posidexDedupe(req);
        return new ResponseEntity<>(CommonResponse.buildCommonResponse("Success" ,"done","00"), HttpStatus.OK);
    }

    @PostMapping(path = "/customer/dedupe/cust")
    public ResponseEntity<CommonResponse> posidexCustomerDedupe2(@RequestBody CheckGenericDedupeRequest req) {
        posidexService.posidexDedupe2(req);
        return new ResponseEntity<>(CommonResponse.buildCommonResponse("Success" ,"done","00"), HttpStatus.OK);
    }

    @PostMapping(path = "/customer/search")
    public ResponseEntity<PosidexCustomerAadharRef> posidexCustomerDedupe(@RequestBody String req) {
        PosidexCustomerAadharRef fetchCustomer = posidexService.fetchCustomer(req);
        return new ResponseEntity<>(fetchCustomer, HttpStatus.OK);
    }

    @PostMapping(path = "/update/application/status")
    public ResponseEntity<PosidexCustomerDetails> posidexApplicationStatusUpdate(@RequestBody String req) {
        PosidexCustomerDetails fetchCustomer = posidexService.updateApplicationStatus(Long.parseLong(req));
        return new ResponseEntity<>(fetchCustomer, HttpStatus.OK);
    }


}
