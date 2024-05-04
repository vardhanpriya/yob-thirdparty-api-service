package com.thirdparty.apiservice.repository;

import com.thirdparty.apiservice.entity.AadharOtpEntity;
import com.thirdparty.apiservice.entity.MobileOtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileOtpRepo extends JpaRepository<MobileOtpEntity,Integer> {


}
