package com.thirdparty.apiservice.client.request;

import lombok.Data;

import java.util.List;

@Data
public class CheckGenericDedupeRequest {

    private CheckGenericDedupeReq checkGenericDedupeReq;

    @Data
    public static class CheckGenericDedupeReq{
        private String sourceSystem;
        private String schemeId;
        private String localApplicationNo;
        private String isTopIp;
        private String integrationType;
        private String businessUnit;
        private String businessType;
        private String aadharRefNo;
        private List<CustomerRequest> customerRequest;
    }

    @Data
    public static class CustomerRequest{
        private String typeOfApplicant;
        private String oldPosidexRequestId;
        private String customerIdentifier;
        private String customerCategory;
        private String crn;
        private CustomerEmailDetails emailDetails;
        private CustomerDemographics demographics;
        private CustomerContactDetails contactDetails;
        private CustomerAddress address;

    }
    @Data
    public static class CustomerEmailDetails{
        private String emailType;
        private String emailId;
    }
    @Data
    public static class CustomerDemographics{

        private String voterId;
        private String passportNo;
        private String pan;
        private String name;
        private String gender;
        private String dob;
        private String aadharRefNo;
        private String motherName;
        private String fatherName;
        private String spouseName;

    }
    @Data
    public static class CustomerContactDetails{
        private String mobileType;
        private String mobileNumber;

    }
    @Data
    public static class CustomerAddress{
        private String state;
        private String pincode;
        private String city;
        private String adddresType;
        private String address;
    }

}
