package com.thirdparty.apiservice.repository;

import com.thirdparty.apiservice.entity.PanAadharLinkageInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PanAadharLinkageInfoRepo extends JpaRepository <PanAadharLinkageInfoEntity,Integer>{


   List<PanAadharLinkageInfoEntity>   findByPanNumberAndAadharNumber(String panNumber, String aadharNumber);
}
