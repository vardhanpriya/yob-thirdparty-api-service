package com.thirdparty.apiservice.repository;

import com.thirdparty.apiservice.entity.AadharOtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadharOtpRepo  extends JpaRepository<AadharOtpEntity,Integer> {

     AadharOtpEntity findByTransactionId(String transactionId);


}
