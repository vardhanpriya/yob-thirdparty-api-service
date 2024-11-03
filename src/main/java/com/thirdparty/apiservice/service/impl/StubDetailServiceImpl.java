package com.thirdparty.apiservice.service.impl;

import com.thirdparty.apiservice.dto.CommonResponse;
import com.thirdparty.apiservice.entity.StubDetails;
import com.thirdparty.apiservice.repository.StubDetailsRepo;
import com.thirdparty.apiservice.service.StubDetailService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StubDetailServiceImpl implements StubDetailService {

    @Autowired
    private StubDetailsRepo stubDetailsRepo;
//   @Override
//   public CommonResponse addAadharOtpResponseInDb(StubDetails request,String uri,String uniqueIdVal) {
//        StubDetails stubDetails = stubDetailsRepo.findByStubUrlAndUniqueIdVal("/get/aadhar/details",uniqueIdVal);
//        if(ObjectUtils.isEmpty(stubDetails)){
//
//        }
//
//    }
}
