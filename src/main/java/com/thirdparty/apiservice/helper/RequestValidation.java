package com.thirdparty.apiservice.helper;


import com.thirdparty.apiservice.client.request.AadharMbileLinkageInfoRequest;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class RequestValidation {
    public static boolean validateAadharMobileLinkageRequest(AadharMbileLinkageInfoRequest req){
        if(ObjectUtils.isEmpty(req.getEkycAuthenticationReq()) ||
                StringUtils.isBlank(req.getEkycAuthenticationReq().getMobileNo())||
                StringUtils.isBlank(req.getEkycAuthenticationReq().getAadharNo()) ||
                req.getEkycAuthenticationReq().getAadharNo().length()!=12 ||
                req.getEkycAuthenticationReq().getMobileNo().length()!=10){
            return true;
        }else{
            return false;
        }
    }
}
