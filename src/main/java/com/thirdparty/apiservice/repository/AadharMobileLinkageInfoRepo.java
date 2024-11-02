package com.thirdparty.apiservice.repository;

import com.thirdparty.apiservice.entity.AadharMobileLinkageInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AadharMobileLinkageInfoRepo extends JpaRepository<AadharMobileLinkageInfoEntity,Integer> {


    List<AadharMobileLinkageInfoEntity> findByAadharNumberAndMobileNumber(String aadhar, String mobile);

}
