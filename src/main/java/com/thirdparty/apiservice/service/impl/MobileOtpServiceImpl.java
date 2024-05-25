package com.thirdparty.apiservice.service.impl;


import static com.thirdparty.apiservice.dto.GenerateMobileOtpResponse.GenerateMobileOtpRes;
import static com.thirdparty.apiservice.dto.GenerateMobileOtpResponse.GenerateMobileOtpMetaData;
import static com.thirdparty.apiservice.dto.GenerateMobileOtpResponse.GenerateMobileOtpResourceData;

import com.thirdparty.apiservice.config.PropertyConfig;
import com.thirdparty.apiservice.dto.GenerateMobileOtpResponse;
import com.thirdparty.apiservice.dto.ValidateAadharOtpResponse;
import com.thirdparty.apiservice.dto.ValidateMobileOtpRequest;
import com.thirdparty.apiservice.dto.ValidateMobileOtpResponse;
import com.thirdparty.apiservice.entity.MobileOtpEntity;
import com.thirdparty.apiservice.repository.MobileOtpRepo;
import com.thirdparty.apiservice.service.MobileOtpService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class MobileOtpServiceImpl implements MobileOtpService {


    @Autowired
    private MobileOtpRepo mobileOtpRepo;

    @Autowired
    PropertyConfig propertyConfig;


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
        resourceData.setMessage("mobile otp generated successfully and valid for " +propertyConfig.getMobileOtpExpTime()+" minutes");
        resourceData.setStatusCode("200");

        res.setMetaData(metadata);
        res.setResourceData(resourceData);

        mobileOtpResponse.setGenerateMobileOtpRes(res);
        return mobileOtpResponse;

    }


    @Override
    public ValidateMobileOtpResponse validateMobileOtp(ValidateMobileOtpRequest request) {

            MobileOtpEntity entity = mobileOtpRepo.findByTransactionId(request.getValidateMobileOtpReq().getTransactionId());
        System.out.println("Entity ka time : " + entity.getCreatedTime());
        System.out.println("av ka time " + LocalDateTime.now());
        LocalDateTime createddateTimeOTP = LocalDateTime.parse(entity.getCreatedTime());
        Duration duration = Duration.between(createddateTimeOTP,LocalDateTime.now());
        long durationInMinutes = duration.toMinutes();
            ValidateMobileOtpResponse response = new ValidateMobileOtpResponse();
            ValidateMobileOtpResponse.ValidateMobileOtpRes res = new ValidateMobileOtpResponse.ValidateMobileOtpRes();
            ValidateMobileOtpResponse.ValidateMobileOtpMetaData metaData = new ValidateMobileOtpResponse.ValidateMobileOtpMetaData();
            metaData.setMessage("Your request processed successfully..");
            metaData.setVersion("V1");
            ValidateMobileOtpResponse.ValidateMobileOtpResourceData resourceData = new ValidateMobileOtpResponse.ValidateMobileOtpResourceData();

            if (entity != null) {

                if (request.getValidateMobileOtpReq().getMobileOtp().equals(entity.getOtp()) &&
                        request.getValidateMobileOtpReq().getMobileNo().equals(entity.getMobileNo()) &&
                        durationInMinutes <= propertyConfig.getMobileOtpExpTime()) {
                    metaData.setStatus("SUCCESS");
                    metaData.setCode("00");
                    res.setMetadata(metaData);
                    resourceData.setMessage("Your Mobile Otp verified Successfully");
                    resourceData.setStatusCode("200");
                    res.setResourceData(resourceData);
                    response.setValidateMobileOtpRes(res);
                } else if (request.getValidateMobileOtpReq().getMobileOtp().equals(entity.getOtp()) &&
                        request.getValidateMobileOtpReq().getMobileNo().equals(entity.getMobileNo())) {
                    metaData.setStatus("ERROR");
                    metaData.setCode("01");
                    res.setMetadata(metaData);

                    resourceData.setMessage("You have entered expired OTP");
                    resourceData.setStatusCode("100");
                    res.setResourceData(resourceData);
                    response.setValidateMobileOtpRes(res);
                } else {
                    metaData.setStatus("ERROR");
                    metaData.setCode("01");
                    res.setMetadata(metaData);

                    resourceData.setMessage("You have entered wrong OTP");
                    resourceData.setStatusCode("100");
                    res.setResourceData(resourceData);
                    response.setValidateMobileOtpRes(res);

                }
            } else {
                metaData.setStatus("ERROR");
                metaData.setCode("01");
                res.setMetadata(metaData);
                resourceData.setMessage("Invalid Request");
                resourceData.setStatusCode("INV_REQ");
                res.setResourceData(resourceData);
                response.setValidateMobileOtpRes(res);
            }
            return response;
    }
}
