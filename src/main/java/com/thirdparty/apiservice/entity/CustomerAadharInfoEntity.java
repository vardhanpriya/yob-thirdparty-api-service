package com.thirdparty.apiservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER_AADHAR_DATA_INFO")
public class CustomerAadharInfoEntity {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "AADHAR_NUMBER")
    private String aadharNumber;

    @Column(name = "AADHAR_NAME")
    private String aadharName;

    @Column(name = "RET")
    private String ret;

    @Column(name = "ENROLMENT_DATE")
    private String enrolmentDate;

    @Column(name = "DOB")
    private String dob;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CO")
    private String co;

    @Column(name = "HOUSE")
    private String house;

    @Column(name = "STREET")
    private String street;

    @Column(name = "LM")
    private String lm;

    @Column(name = "LOC")
    private String loc;

    @Column(name = "VTC")
    private String vtc;

    @Column(name = "DIST")
    private String dist;

    @Column(name = "STATE")
    private String state;

    @Column(name = "PINCODE")
    private String pincode;

    @Column(name = "POST_OFFICE")
    private String postOffice;

    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "AADHAR_PDF")
    private String aadharPdf;
}
