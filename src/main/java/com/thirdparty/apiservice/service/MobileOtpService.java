package com.thirdparty.apiservice.service;

import com.thirdparty.apiservice.dto.GenerateMobileOtpResponse;
public interface MobileOtpService {


     GenerateMobileOtpResponse generateMobileOtp(String mobile);
}
