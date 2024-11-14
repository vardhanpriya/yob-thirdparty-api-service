package com.thirdparty.apiservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="POSIDEX_CUSTOMER_DETAILS_TABLE")
@Data
public class PosidexCustomerDetails {
    @Id
    @Column(name = "CRN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crn;


    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "FK_AADHAR_REF_NO", referencedColumnName = "AADHAR_REF_NO" )
   @JsonBackReference
    private PosidexCustomerAadharRef posidexCustomerAadharRef;


    @Column(name = "SOURCE_SYSTEM")
    private String sourceSystem;

    @Column(name = "AADHAR_REF_NO")
    private String aahdarRefNo;

    @Column(name = "SCHEME_ID")
    private String schemeId;

    @Column(name = "LOCAL_APPLICATION_NO")
    private String localApplicationNo;

    @Column(name = "BUSINESS_UNIT")
    private String businessUnit;

    @Column(name = "SYSTEM_STATUS")
    private String systemStatus;

    @Column(name = "BUSINESS_TYPE")
    private String businessType;

    @Column(name = "TYPE_OF_APPLICANT")
    private String typeOfApplicant;

    @Column(name = "CUSTOMER_IDENTIFIER")
    private String customerIdentifier;

    @Column(name = "CUSTOMER_CATEGORY")
    private String customerCategory;

    @Column(name = "ACCOUNT_NO")
    private String accountNo;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "VOTER_ID")
    private String voterId;

    @Column(name = "PASSPORT_NO")
    private String passportNo;

    @Column(name = "PAN")
    private String pan;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DOB")
    private String dob;

    @Column(name = "MOTHER_NAME")
    private String motherName;

    @Column(name = "FATHER_NAME")
    private String fatherName;

    @Column(name = "SPOUSE_NAME")
    private String spouseName;

    @Column(name = "ADDRESS_TYPE")
    private String addressType;

    @Column(name = "STATE_NAME")
    private String stateName;

    @Column(name = "PINCODE")
    private String pincode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ADDRESS")
    private String address;
}
