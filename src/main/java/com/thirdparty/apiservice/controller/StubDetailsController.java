package com.thirdparty.apiservice.controller;


import com.thirdparty.apiservice.dto.CommonResponse;
import com.thirdparty.apiservice.dto.GenerateAadharOtpRequest;
import com.thirdparty.apiservice.dto.GenerateAadharOtpResponse;
import com.thirdparty.apiservice.entity.StubDetails;
import com.thirdparty.apiservice.repository.StubDetailsRepo;
import com.thirdparty.apiservice.service.StubDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stub")
public class StubDetailsController {

    @Autowired
    StubDetailService stubDetailService;

    @Autowired
    StubDetailsRepo stubDetailsRepo;

//    @PostMapping("/add-aadharOtpResponse")
//    public ResponseEntity<CommonResponse> generateAadharOtp(@RequestBody StubDetails request, @RequestHeader String uri,
//                                                            @RequestHeader String uniqueIdVal) {
//        CommonResponse res = stubDetailService.addAadharOtpResponseInDb(request,uri,uniqueIdVal);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }



}
