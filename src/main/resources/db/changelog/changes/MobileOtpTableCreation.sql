CREATE TABLE MOBILE_OTP_TABLE(

    ID int(20) AUTO_INCREMENT PRIMARY KEY,
    OTP varchar(16) DEFAULT NULL,
    TRANSACTION_ID  varchar(30) DEFAULT NULL,
    CREATED_TIME varchar(30) DEFAULT NULL,
    MOBILE_NO varchar(100) DEFAULT NULL

);