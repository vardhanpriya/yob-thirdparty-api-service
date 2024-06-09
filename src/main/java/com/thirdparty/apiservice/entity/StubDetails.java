package com.thirdparty.apiservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "STUB_DETAILS")
@Entity
@Data
public class StubDetails {

    @Id
    @Column(name = "ROWID")
    private String rowId;
    @Column(name = "STUBURL")
    private String stubUrl;
    @Column(name = "UNIQUEID")
    private String uniqueId;
    @Column(name = "UNIQUEIDVAL")
    private String uniqueIdVal;
    @Column(name = "RESPONSE")
    private String response;

}
