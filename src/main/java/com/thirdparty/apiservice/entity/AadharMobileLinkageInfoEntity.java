package com.thirdparty.apiservice.entity;

import jakarta.persistence.*;
import lombok.Data;
@Table(name = "AADHAR_MOBILE_LINKAGE_INFO")
@Entity
@Data
public class AadharMobileLinkageInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;


    @Column(name = "AADHAR_NUMBER")
    private String aadharNumber;
    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "AADHAR_MOBILE_LINKAGE_VALUE")
    private String linkedValue;
}


