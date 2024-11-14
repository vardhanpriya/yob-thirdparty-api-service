package com.thirdparty.apiservice.repository;

import com.thirdparty.apiservice.entity.PosidexCustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosidexCustomerDetailsRepo extends JpaRepository<PosidexCustomerDetails, Long > {

    PosidexCustomerDetails findByCrn(Long crn);
}
