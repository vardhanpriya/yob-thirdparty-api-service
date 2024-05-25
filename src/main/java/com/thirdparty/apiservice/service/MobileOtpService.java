package com.thirdparty.apiservice.service;


import com.thirdparty.apiservice.dto.GenerateMobileOtpResponse;
import com.thirdparty.apiservice.dto.ValidateMobileOtpRequest;
import com.thirdparty.apiservice.dto.ValidateMobileOtpResponse;


public interface MobileOtpService {


     GenerateMobileOtpResponse generateMobileOtp(String mobile);

     ValidateMobileOtpResponse validateMobileOtp(ValidateMobileOtpRequest request);


}
