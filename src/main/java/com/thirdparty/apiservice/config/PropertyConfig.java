package com.thirdparty.apiservice.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class PropertyConfig {

    @Value("${EXIPIRY_TIME_MOBILE_OTP}")
    private long mobileOtpExpTime;
}
