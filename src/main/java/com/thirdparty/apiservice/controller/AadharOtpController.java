package com.thirdparty.apiservice.controller;

import com.thirdparty.apiservice.dto.GenerateAadharOtpRequest;
import com.thirdparty.apiservice.dto.GenerateAadharOtpResponse;
import com.thirdparty.apiservice.client.request.ValidateAadharOtpRequest;
import com.thirdparty.apiservice.client.response.ValidateAadharOtpResponse;
import com.thirdparty.apiservice.service.AadharOtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aadhar/otp")
public class AadharOtpController {
    @Autowired
    private AadharOtpService aadharOtpService;


    @PostMapping("/generate")
    public ResponseEntity<GenerateAadharOtpResponse> generateAadharOtp(@RequestBody GenerateAadharOtpRequest request) {
        GenerateAadharOtpResponse res = aadharOtpService.generateAadharotp(request.getGenerateAadharOtpReq().getAadharNo());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PostMapping("/validate")

    public ResponseEntity<ValidateAadharOtpResponse> validateAadharOtp(@RequestBody ValidateAadharOtpRequest request){

        ValidateAadharOtpResponse res = aadharOtpService.validateAadharOtp(request);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    /**
     * access specifier  returntype  methodname(datatype variablename,datatype variablename){
     *     operations
     *     1
     *     2
     *     3
     *     return variable;
     * }
     *  public String returnName(String name){
     *         return name;
     *     }
     */

}
