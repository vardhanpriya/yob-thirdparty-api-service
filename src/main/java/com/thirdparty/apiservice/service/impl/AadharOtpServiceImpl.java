package com.thirdparty.apiservice.service.impl;

import com.google.gson.Gson;
import com.thirdparty.apiservice.dto.GenerateAadharOtpResponse;
import com.thirdparty.apiservice.dto.ValidateAadharOtpRequest;
import com.thirdparty.apiservice.dto.ValidateAadharOtpResponse;
import com.thirdparty.apiservice.entity.AadharOtpEntity;
import com.thirdparty.apiservice.entity.StubDetails;
import com.thirdparty.apiservice.helper.EncryptionDecryption;
import com.thirdparty.apiservice.repository.AadharOtpRepo;
import com.thirdparty.apiservice.repository.StubDetailsRepo;
import com.thirdparty.apiservice.service.AadharOtpService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.thirdparty.apiservice.dto.GenerateAadharOtpResponse.GenAadharOtpMetaData;
import static com.thirdparty.apiservice.dto.GenerateAadharOtpResponse.GenAadharOtpResourceData;
import static com.thirdparty.apiservice.dto.GenerateAadharOtpResponse.GenerateAadharOtpRes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AadharOtpServiceImpl implements AadharOtpService {
    @Autowired
     private AadharOtpRepo aadharOtpRepo;

    @Autowired
    private StubDetailsRepo stubDetailsRepo;

    @Autowired
    private EncryptionDecryption encDecHelper;

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
        Gson gson = new Gson();
        AadharOtpEntity entity = aadharOtpRepo.findByTransactionId(request.getValidateAadharOtpReq().getTransactionId());
        ValidateAadharOtpResponse response = new ValidateAadharOtpResponse();
        // difference btwn == ,.equals(),.equalIgnoreCase()
        if(entity!= null){

            if(request.getValidateAadharOtpReq().getAadharOtp().equals(entity.getOtp())&&
                    request.getValidateAadharOtpReq().getAadharNo().equals(entity.getAadharNo())){

              StubDetails stubDetails = stubDetailsRepo.findByStubUrlAndUniqueIdVal("/get/aadhar/details",encDecHelper.encryptAadharData(request.getValidateAadharOtpReq().getAadharNo()));
              if(stubDetails!=null){
                  String aadharRes  = stubDetails.getResponse();
                  response   = gson.fromJson(aadharRes,ValidateAadharOtpResponse.class);
                  return response;
              }else {

                  return getErrorResponse("No data added in the database for this customer.. ","DATA-NOT-FOUND","DATA-NOT-FOUND");
              }

            }
            else {

                return getErrorResponse("Resident authentication failed (usually wrong otp) ","k-100","403");

            }
        }
        else {
            return getErrorResponse("Data can't be processed or Ivalid Request","IN-REQ","IN_REQ");
        }
    }
    private ValidateAadharOtpResponse getErrorResponse(String message, String metadaCd, String resDataCd){
        ValidateAadharOtpResponse response = new ValidateAadharOtpResponse();
        ValidateAadharOtpResponse.ValidateAadharOtpRes res = new ValidateAadharOtpResponse.ValidateAadharOtpRes();
        ValidateAadharOtpResponse.ValidataAadharOtpMetaData metaData = new ValidateAadharOtpResponse.ValidataAadharOtpMetaData();
        List <ValidateAadharOtpResponse.ValidataAadharOtpResourceData > resourceDataList = new ArrayList<>();
        ValidateAadharOtpResponse.ValidataAadharOtpResourceData resourceData = new ValidateAadharOtpResponse.ValidataAadharOtpResourceData();
        metaData.setStatus("ERROR");
        metaData.setMessage(message);
        metaData.setVersion("V1");
        metaData.setCode(metadaCd);
        metaData.setTime(LocalDateTime.now().toString());
        res.setMetadata(metaData);
        resourceData.setCode(resDataCd);
        resourceDataList.add(resourceData);
        res.setResource_data(resourceDataList);
        response.setVerifyAadhaarResp(res);
        return response;
    }
}
