package com.thirdparty.apiservice.entity;


import jakarta.persistence.*;
import lombok.Data;

@Table(name ="aadhar_otp_table" )
@Entity
@Data
public class AadharOtpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "OTP")
    private String otp;

    @Column(name = "AADHAR_NO")
    private String aadharNo;

    @Column(name = "CREATED_TIME")
    private String createdTime;

    @Column(name = "TRANSACTION_ID")
    private String transactionId;


}
/**
 *  ID             | int          | NO   | PRI | NULL    | auto_increment |
 * | OTP            | varchar(10)  | YES  |     | NULL    |                |
 * | TRANSACTION_ID | varchar(30)  | YES  |     | NULL    |                |
 * | CREATED_TIME   | varchar(30)  | YES  |     | NULL    |                |
 * | AADHAR_NO      | varchar(100) | YES  |     | NULL    |                |
 * +----------------+--------------+------+-----+---------+----------------+
 */