package com.thirdparty.apiservice.service.impl;

import static com.thirdparty.apiservice.client.request.CheckGenericDedupeRequest.*;
import  com.thirdparty.apiservice.client.request.CheckGenericDedupeRequest;
import com.thirdparty.apiservice.entity.PosidexCustomerAadharRef;
import com.thirdparty.apiservice.entity.PosidexCustomerDetails;
import com.thirdparty.apiservice.repository.PosidexCustomerAadharRefRepo;
import com.thirdparty.apiservice.repository.PosidexCustomerDetailsRepo;
import com.thirdparty.apiservice.service.PosidexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PosidexServiceImpl implements PosidexService {

    @Autowired
    private PosidexCustomerAadharRefRepo aadharRefRepo;

    @Autowired
    PosidexCustomerDetailsRepo customerDetailsRepo;
    @Override
    public void posidexDedupe(CheckGenericDedupeRequest request) {

        CheckGenericDedupeRequest.CheckGenericDedupeReq  request1 = request.getCheckGenericDedupeReq();
        CheckGenericDedupeRequest.CustomerRequest customerRequest = request.getCheckGenericDedupeReq().getCustomerRequest().get(0);

        PosidexCustomerAadharRef entity = new PosidexCustomerAadharRef();
        entity.setAadharRefNo(request1.getAadharRefNo());

        PosidexCustomerDetails  customerDetlEntity =  createCustomerDetlEntity (request1,customerRequest);

        List<PosidexCustomerDetails> customerDetailsList = new ArrayList<>();
        customerDetailsList.add(customerDetlEntity);

        entity.setPosidexCustomerDetailsList(customerDetailsList);
        try{
            PosidexCustomerAadharRef savedData = aadharRefRepo.save(entity);
        }catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));

        }



    }

    @Override
    public void posidexDedupe2(CheckGenericDedupeRequest request) {
//        CheckGenericDedupeRequest.CheckGenericDedupeReq  request1 = request.getCheckGenericDedupeReq();
//        CheckGenericDedupeRequest.CustomerRequest customerRequest = request.getCheckGenericDedupeReq().getCustomerRequest().get(0);
//        PosidexCustomerDetails  customerDetlEntity =  createCustomerDetlEntity (request1,customerRequest);
//        PosidexCustomerAadharRef ref = new PosidexCustomerAadharRef();
//        ref.setAadharRefNo(request.getCheckGenericDedupeReq().getAadharRefNo());
//
//        customerDetlEntity.setPosidexCustomerAadharRef(ref);
//
//        try {
//            customerDetailsRepo.save(customerDetlEntity);
//        }catch (Exception e){
//            System.out.println("Exception found");
//
//        }



    }

    public PosidexCustomerDetails  createCustomerDetlEntity(CheckGenericDedupeReq request1 ,CustomerRequest customerRequest){
       PosidexCustomerDetails  customerDetlEntity = new PosidexCustomerDetails();
       customerDetlEntity.setAahdarRefNo(request1.getAadharRefNo());
       customerDetlEntity.setSourceSystem(request1.getSourceSystem());
       customerDetlEntity.setSchemeId(request1.getSchemeId());
       customerDetlEntity.setLocalApplicationNo(request1.getLocalApplicationNo());
       customerDetlEntity.setBusinessUnit(request1.getBusinessUnit());
       customerDetlEntity.setBusinessType(request1.getBusinessType());
       customerDetlEntity.setTypeOfApplicant(customerRequest.getTypeOfApplicant());
       customerDetlEntity.setCustomerIdentifier(customerRequest.getCustomerIdentifier());
       customerDetlEntity.setCustomerCategory(customerRequest.getCustomerCategory());
       customerDetlEntity.setEmailId(customerRequest.getEmailDetails().getEmailId());
       customerDetlEntity.setMobileNumber(customerRequest.getContactDetails().getMobileNumber());
       customerDetlEntity.setVoterId(customerRequest.getDemographics().getVoterId());
       customerDetlEntity.setPassportNo(customerRequest.getDemographics().getPassportNo());
       customerDetlEntity.setPan(customerRequest.getDemographics().getPan());
       customerDetlEntity.setName(customerRequest.getDemographics().getName());
       customerDetlEntity.setGender(customerRequest.getDemographics().getGender());
       customerDetlEntity.setDob(customerRequest.getDemographics().getDob());
       customerDetlEntity.setMotherName(customerRequest.getDemographics().getMotherName());
       customerDetlEntity.setFatherName(customerRequest.getDemographics().getFatherName());
       customerDetlEntity.setAddressType(customerRequest.getAddress().getAdddresType());
       customerDetlEntity.setStateName(customerRequest.getAddress().getState());
       customerDetlEntity.setPincode(customerRequest.getAddress().getPincode());
       customerDetlEntity.setCity(customerRequest.getAddress().getCity());
       customerDetlEntity.setAddress(customerRequest.getAddress().getAddress());
       return customerDetlEntity;
    }

    @Override
    public PosidexCustomerAadharRef fetchCustomer(String req) {

      return   aadharRefRepo.findByAadharRefNo(req);

    }

    @Override
    public PosidexCustomerDetails updateApplicationStatus(Long req) {
        PosidexCustomerDetails  byCrn = customerDetailsRepo.findByCrn(req);
        byCrn.setSystemStatus("Live");
        customerDetailsRepo.save(byCrn);
        return byCrn;
    }
}
