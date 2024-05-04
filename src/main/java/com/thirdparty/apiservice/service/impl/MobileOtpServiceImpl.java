package com.thirdparty.apiservice.service.impl;


import static com.thirdparty.apiservice.dto.GenerateMobileOtpResponse.GenerateMobileOtpRes;
import static com.thirdparty.apiservice.dto.GenerateMobileOtpResponse.GenerateMobileOtpMetaData;
import static com.thirdparty.apiservice.dto.GenerateMobileOtpResponse.GenerateMobileOtpResourceData;
import com.thirdparty.apiservice.dto.GenerateMobileOtpResponse;
import com.thirdparty.apiservice.entity.MobileOtpEntity;
import com.thirdparty.apiservice.repository.MobileOtpRepo;
import com.thirdparty.apiservice.service.MobileOtpService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MobileOtpServiceImpl implements MobileOtpService {


    @Autowired
       private MobileOtpRepo mobileOtpRepo;

    @Override
    public GenerateMobileOtpResponse generateMobileOtp(String mobile){

        MobileOtpEntity mobileOtpEntity=new MobileOtpEntity();
        String otp = RandomStringUtils.randomNumeric(4);
        String transactionId = RandomStringUtils.randomAlphanumeric(15);
        mobileOtpEntity.setOtp(otp);
        mobileOtpEntity.setTransactionId(transactionId);
        mobileOtpEntity.setCreatedTime(LocalDateTime.now().toString());
        mobileOtpEntity.setMobileNo(mobile);
        mobileOtpRepo.save(mobileOtpEntity);
        GenerateMobileOtpResponse mobileOtpResponse = new GenerateMobileOtpResponse();

        GenerateMobileOtpRes res = new GenerateMobileOtpRes();

        GenerateMobileOtpMetaData metadata = new GenerateMobileOtpMetaData();
        metadata.setCode("300");
        metadata.setMessage("otp generated succesfully");
        metadata.setStatus("success");
        metadata.setTime(LocalDateTime.now().toString());
        metadata.setVersion("v1");
        GenerateMobileOtpResourceData resourceData = new GenerateMobileOtpResourceData();
        resourceData.setMobileOtp(otp);
        resourceData.setTransactionId(transactionId);
        resourceData.setMessage("mobile otp generated successfully");
        resourceData.setStatusCode("200");

        res.setMetaData(metadata);
        res.setResourceData(resourceData);

        mobileOtpResponse.setGenerateMobileOtpRes(res);
        return mobileOtpResponse;


    }
}
