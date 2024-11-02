package com.thirdparty.apiservice.service.impl;

import com.thirdparty.apiservice.client.response.AadharMobileLinkageInfoResponse;
import com.thirdparty.apiservice.client.response.PanAadharLinkageInfoResponse;
import com.thirdparty.apiservice.dto.AadharMobileLinkageSaveReq;
import com.thirdparty.apiservice.dto.CommonResponse;
import com.thirdparty.apiservice.entity.AadharMobileLinkageInfoEntity;
import com.thirdparty.apiservice.entity.PanAadharLinkageInfoEntity;
import com.thirdparty.apiservice.repository.AadharMobileLinkageInfoRepo;
import com.thirdparty.apiservice.service.AadharMobileLinkageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AadharMobileLinkageServiceImpl implements AadharMobileLinkageInfoService {
    @Autowired
    private AadharMobileLinkageInfoRepo aadharMobileLinkageInfoRepo;

    @Override
    public CommonResponse addAadharMobileLinkageIndb(AadharMobileLinkageSaveReq req) {
        AadharMobileLinkageInfoEntity entity = new AadharMobileLinkageInfoEntity();
        entity.setAadharNumber(req.getAadharNo());
        entity.setMobileNumber(req.getMobileNo());
        entity.setLinkedValue(req.getLinkedValue());
        CommonResponse commonResponse = null;
        try {
            List<AadharMobileLinkageInfoEntity> dbEntityList = aadharMobileLinkageInfoRepo.findByAadharNumberAndMobileNumber(req.getAadharNo(), req.getMobileNo());
            /*
              int x= obj.m1(5); obj.m1(5) is method call recieving returned value in x of type int
              obj.m1(5); obj.m1(5) is just a method call in which we are not assignng returned value in any type
             */

            if (dbEntityList.isEmpty()) {
                aadharMobileLinkageInfoRepo.save(entity);
                commonResponse = CommonResponse.buildCommonResponse("SUCCESS", "Savd Successfully", "00");
            } else {
                AadharMobileLinkageInfoEntity entity1 = dbEntityList.get(0);
                entity1.setLinkedValue(req.getLinkedValue());
                aadharMobileLinkageInfoRepo.save(entity1);
                commonResponse = CommonResponse.buildCommonResponse("SUCCESS", "Updated Successfully", "00");
            }
            return commonResponse;
        } catch (Exception e) {
            return CommonResponse.buildCommonResponse("SUCCESS", "Exception Found", "00");

        }
    }

    @Override
    public AadharMobileLinkageInfoResponse fetchAadharMobileLinkageDetail(String aadhar, String mobile) {
        List<AadharMobileLinkageInfoEntity> entityList = aadharMobileLinkageInfoRepo.findByAadharNumberAndMobileNumber(aadhar, mobile);
        if (entityList.isEmpty()) {
            // String metaMsg, String metaSts, boolean linked, Integer resourceStsCd
            return AadharMobileLinkageInfoResponse.buildAadharMobileLinkageInfoResponse(
                    "ERROR", "Record Not found" ,"105","105","Record Not Found");

        } else {
            AadharMobileLinkageInfoEntity infoEntity = entityList.get(0);
            if (infoEntity.getLinkedValue().equalsIgnoreCase("Y")) {
                return AadharMobileLinkageInfoResponse.buildAadharMobileLinkageInfoResponse(
                        "SUCCESS", "Request Procesed Successfully", "200", "200", "Authenticated Successfully");

            } else {
                return AadharMobileLinkageInfoResponse.buildAadharMobileLinkageInfoResponse("ERROR", "Pi Mismatched", "100", "100", "Authenticated Failed");


            }
        }
    }
}