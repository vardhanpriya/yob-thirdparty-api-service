package com.thirdparty.apiservice.controller;

import com.thirdparty.apiservice.dto.GenerateMobileOtpRequest;
import com.thirdparty.apiservice.dto.GenerateMobileOtpResponse;
import com.thirdparty.apiservice.dto.ValidateMobileOtpRequest;
import com.thirdparty.apiservice.dto.ValidateMobileOtpResponse;
import com.thirdparty.apiservice.service.MobileOtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile/otp")
public class MobileOtpController {


    @Autowired
    private MobileOtpService mobileOtpService;

    @PostMapping("/generate")

    public ResponseEntity<GenerateMobileOtpResponse> generateMobileOtp(@RequestBody GenerateMobileOtpRequest request){

        GenerateMobileOtpResponse res = mobileOtpService.generateMobileOtp(request.getGenerateMobileOtpReq().getMobileNo());
        return new ResponseEntity<>(res, HttpStatus.OK);


    }
    @PostMapping("/validate")
    public ResponseEntity<ValidateMobileOtpResponse> validateMobileOtp(@RequestBody ValidateMobileOtpRequest request){

        ValidateMobileOtpResponse res = mobileOtpService.validateMobileOtp(request);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
