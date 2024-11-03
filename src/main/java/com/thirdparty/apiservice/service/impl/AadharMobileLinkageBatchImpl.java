package com.thirdparty.apiservice.service.impl;

import com.thirdparty.apiservice.dto.BulkAddAadharMobileLinkage;
import com.thirdparty.apiservice.service.AadharMobileLinkageBatchRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;


@Repository
public class AadharMobileLinkageBatchImpl implements AadharMobileLinkageBatchRepo {


    private final JdbcTemplate jdbcTemplate;
    public AadharMobileLinkageBatchImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    String insertQuery = "INSERT INTO AADHAR_MOBILE_LINKAGE_INFO (" +
            "AADHAR_NUMBER, MOBILE_NUMBER, AADHAR_MOBILE_LINKAGE_VALUE) VALUES(?,?,?)";

    @Override
    public void addAadharMobileLinkage(List<BulkAddAadharMobileLinkage> request) {
        jdbcTemplate.batchUpdate(insertQuery,request,100,
                (PreparedStatement ps, BulkAddAadharMobileLinkage linkageReq) ->{
            ps.setString(1,linkageReq.getAadharNo());
            ps.setString(2,linkageReq.getMobileNo());
            ps.setString(3,linkageReq.getLinkedValue());
                });
    }
}
