package com.thirdparty.apiservice.service.impl;

import com.thirdparty.apiservice.dto.GenerateAadharOtpResponse;
import com.thirdparty.apiservice.dto.ValidateAadharOtpRequest;
import com.thirdparty.apiservice.dto.ValidateAadharOtpResponse;
import com.thirdparty.apiservice.entity.AadharOtpEntity;
import com.thirdparty.apiservice.repository.AadharOtpRepo;
import com.thirdparty.apiservice.service.AadharOtpService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.thirdparty.apiservice.dto.GenerateAadharOtpResponse.GenAadharOtpMetaData;
import static com.thirdparty.apiservice.dto.GenerateAadharOtpResponse.GenAadharOtpResourceData;
import static com.thirdparty.apiservice.dto.GenerateAadharOtpResponse.GenerateAadharOtpRes;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AadharOtpServiceImpl implements AadharOtpService {
    @Autowired
     private AadharOtpRepo aadharOtpRepo;

    @Override
    public GenerateAadharOtpResponse generateAadharotp(String aadhar) {

        AadharOtpEntity aadharOtpEntity=new AadharOtpEntity();
        String otp= RandomStringUtils.randomNumeric(6);
        String transactionId=RandomStringUtils.randomAlphanumeric(15);
        aadharOtpEntity.setOtp(otp);
        aadharOtpEntity.setTransactionId(transactionId);
        aadharOtpEntity.setCreatedTime(LocalDateTime.now().toString());
        aadharOtpEntity.setAadharNo(aadhar);
        aadharOtpRepo.save(aadharOtpEntity);
        GenerateAadharOtpResponse aadharOtpResponse=new GenerateAadharOtpResponse();
        GenerateAadharOtpRes res= new GenerateAadharOtpRes();

        GenAadharOtpMetaData metaData=new GenAadharOtpMetaData();
        metaData.setCode("200");
        metaData.setMessage("otp generated");
        metaData.setStatus("success");
        metaData.setTime(LocalDateTime.now().toString());
        metaData.setVersion("v1");

        GenAadharOtpResourceData resourceData=new GenAadharOtpResourceData();
        resourceData.setAadharOtp(otp);
        resourceData.setTransactionId(transactionId);
        resourceData.setMessage("otp generated successfully");
        resourceData.setStatusCode("100");
        res.setMetaData(metaData);
        res.setResourceData(resourceData);
        aadharOtpResponse.setGenerateAadharOtpRes(res);
        return aadharOtpResponse;
    }

    @Override
    public ValidateAadharOtpResponse validateAadharOtp(ValidateAadharOtpRequest request) {
        AadharOtpEntity entity = aadharOtpRepo.findByTransactionId(request.getValidateAadharOtpReq().getTransactionId());

        // difference btwn == ,.equals(),.equalIgnoreCase()
        if(entity!= null){

            if(request.getValidateAadharOtpReq().getAadharOtp().equals(entity.getOtp())&&
                    request.getValidateAadharOtpReq().getAadharNo().equals(entity.getAadharNo())){
                System.out.println("otp is correct");

            }
            else {

                System.out.println("otp is incorrect");
            }
        }
        else {
            System.out.println("nothing in db");
        }


        return new ValidateAadharOtpResponse();
    }
}
