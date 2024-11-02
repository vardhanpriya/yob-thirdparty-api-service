package com.thirdparty.apiservice.dto;

import lombok.Data;

@Data
public class DownStreamErrRes {
    private Integer code;
    private String reason;
    private String service;
    private String details;

    public static DownStreamErrRes buildDownStreamErrRes(Integer code,String reason,String service,String details){
        DownStreamErrRes errRes=new DownStreamErrRes();
        errRes.setCode(code);
        errRes.setReason(reason);
        errRes.setService(service);
        errRes.setDetails(details);
        return errRes;
    }
}
