package com.thirdparty.apiservice.repository;

import com.thirdparty.apiservice.entity.CustomerAadharInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAadharInfoRepo extends JpaRepository<CustomerAadharInfoEntity,Integer> {

    CustomerAadharInfoEntity findByAadharNumber(String aadharNo);
}
