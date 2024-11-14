package com.thirdparty.apiservice.service;

import com.thirdparty.apiservice.client.request.CheckGenericDedupeRequest;
import com.thirdparty.apiservice.entity.PosidexCustomerAadharRef;
import com.thirdparty.apiservice.entity.PosidexCustomerDetails;

public interface PosidexService {
    void posidexDedupe(CheckGenericDedupeRequest request);

    void posidexDedupe2(CheckGenericDedupeRequest request);

    PosidexCustomerAadharRef fetchCustomer(String req);


    PosidexCustomerDetails updateApplicationStatus(Long req);
}
