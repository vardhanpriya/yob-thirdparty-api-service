package com.thirdparty.apiservice.service;

import com.thirdparty.apiservice.dto.GenerateAadharOtpResponse;
import com.thirdparty.apiservice.dto.ValidateAadharOtpRequest;
import com.thirdparty.apiservice.dto.ValidateAadharOtpResponse;

public interface AadharOtpService {
   //we  only write method declaration in interface
   //interface is 100% abstract
   //we can never write implementation of the method in interface
   //to implement the method
   // 1.create an implementation class
   // 2.override the metods present in the interface
    GenerateAadharOtpResponse generateAadharotp(String aadhar);

    ValidateAadharOtpResponse validateAadharOtp (ValidateAadharOtpRequest request);

}
