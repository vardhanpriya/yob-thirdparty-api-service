package com.thirdparty.apiservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="POSIDEX_CUSTOMER_AADHAR_REF")
@Data
public class PosidexCustomerAadharRef {

    @Id
    @Column(name = "AADHAR_REF_NO")
    private String aadharRefNo;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_AADHAR_REF_NO")
    @JsonManagedReference
    private List<PosidexCustomerDetails> posidexCustomerDetailsList = new ArrayList<>();


}
