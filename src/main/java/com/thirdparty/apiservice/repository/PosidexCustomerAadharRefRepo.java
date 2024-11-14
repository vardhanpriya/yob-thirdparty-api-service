package com.thirdparty.apiservice.repository;

import com.thirdparty.apiservice.entity.PosidexCustomerAadharRef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosidexCustomerAadharRefRepo extends JpaRepository<PosidexCustomerAadharRef,String> {

    PosidexCustomerAadharRef findByAadharRefNo(String aadharRefNo);
}
