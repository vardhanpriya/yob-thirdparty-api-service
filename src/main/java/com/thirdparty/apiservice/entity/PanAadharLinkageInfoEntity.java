package com.thirdparty.apiservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name ="PAN_AADHAR_LINKAGE_INFO" )
@Entity
@Data
public class PanAadharLinkageInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PAN_NUMBER")
    private String panNumber;

    @Column(name = "AADHAR_NUMBER")
    private String aadharNumber;

    @Column(name = "PAN_AADHAR_LINKAGE_VALUE")
    private String linkedValue;
}
