package com.thirdparty.apiservice.entity;

import jakarta.persistence.*;
import lombok.Data;
@Table(name = "mobile_otp_table")
@Entity
@Data
public class MobileOtpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "OTP")
    private String otp;

    @Column(name = "Mobile_NO")
    private String mobileNo;

    @Column(name = "CREATED_TIME")
    private String createdTime;

    @Column(name = "TRANSACTION_ID")
    private String transactionId;


}
