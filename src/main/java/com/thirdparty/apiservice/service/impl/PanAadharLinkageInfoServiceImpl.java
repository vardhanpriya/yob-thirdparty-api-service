package com.thirdparty.apiservice.service.impl;

import com.thirdparty.apiservice.client.response.PanAadharLinkageInfoResponse;
import com.thirdparty.apiservice.dto.CommonResponse;
import com.thirdparty.apiservice.dto.PanAadharLinkSaveReq;
import com.thirdparty.apiservice.entity.PanAadharLinkageInfoEntity;
import com.thirdparty.apiservice.repository.PanAadharLinkageInfoRepo;
import com.thirdparty.apiservice.service.PanAadharLinkageInfoService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanAadharLinkageInfoServiceImpl implements PanAadharLinkageInfoService {

    @Autowired
    private PanAadharLinkageInfoRepo panAadharLinkageInfoRepo;

    @Override
    public CommonResponse addPanAadharLinkedInfoIndb(PanAadharLinkSaveReq saveReq) {
        CommonResponse commonResponse=null;
        PanAadharLinkageInfoEntity panAadharLinkageInfoEntity = new PanAadharLinkageInfoEntity();
        panAadharLinkageInfoEntity.setAadharNumber(saveReq.getAadharNo());
        panAadharLinkageInfoEntity.setPanNumber(saveReq.getPanNo());
        panAadharLinkageInfoEntity.setLinkedValue(saveReq.getLinked());
        try{
            List<PanAadharLinkageInfoEntity> entityList = panAadharLinkageInfoRepo.findByPanNumberAndAadharNumber(saveReq.getPanNo(), saveReq.getAadharNo());
            if (entityList.isEmpty()) {
                panAadharLinkageInfoRepo.save(panAadharLinkageInfoEntity);
                commonResponse=CommonResponse.buildCommonResponse("SUCCESS", "Savd Successfully", "00");
            } else {
                PanAadharLinkageInfoEntity entity = entityList.get(0);
                entity.setLinkedValue(saveReq.getLinked());
                panAadharLinkageInfoRepo.save(entity);
                commonResponse=CommonResponse.buildCommonResponse("SUCCESS", "Updated Successfully", "00");
            }
            return commonResponse;
        }catch (Exception e){

            return CommonResponse.buildCommonResponse("SUCCESS", "Exception Found", "00");
        }
    }

    @Override
    public PanAadharLinkageInfoResponse fetchPanAadharLinkageDetail(String pan, String aadhar) {
        List<PanAadharLinkageInfoEntity> entityList = panAadharLinkageInfoRepo.findByPanNumberAndAadharNumber(pan, aadhar);
        if(entityList.isEmpty()){
            // String metaMsg, String metaSts, String resltMsg, boolean linked, Integer resourceStsCd
         return PanAadharLinkageInfoResponse.buildPanAadharLinkageInfoResponse("Failed to Fetch Details","ERROR","",false,103);

        }else {
            PanAadharLinkageInfoEntity infoEntity=entityList.get(0);
            if(infoEntity.getLinkedValue().equalsIgnoreCase("Y")){
                return PanAadharLinkageInfoResponse.buildPanAadharLinkageInfoResponse("Details Fetched Successfully","SUCCESS","your Pan is linked to Aadhar",true,101);

            }else {
                return PanAadharLinkageInfoResponse.buildPanAadharLinkageInfoResponse("Details Fetched Successfully","SUCCESS","your Pan is  not linked to Aadhar",false,102);


            }
        }

    }


}
