package com.thirdparty.apiservice.controller;

import com.thirdparty.apiservice.client.request.AadharMbileLinkageInfoRequest;
import com.thirdparty.apiservice.client.response.AadharMobileLinkageInfoResponse;
import com.thirdparty.apiservice.dto.AadharMobileLinkageSaveReq;
import com.thirdparty.apiservice.dto.CommonResponse;
import com.thirdparty.apiservice.dto.PanAadharLinkSaveReq;
import com.thirdparty.apiservice.helper.RequestValidation;
import com.thirdparty.apiservice.service.AadharMobileLinkageInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/aadhar-mobile-link/service")
public class AadharMobileLinkageInfoController {

    @Autowired
    private AadharMobileLinkageInfoService service;


    @Operation(summary = "Api to add aadharMobileLinkage details in DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "400", description = "The Reques you were trying to make is bad request"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource yuou were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found"),

    })
    @PostMapping(path = "/add-update/details", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> addAadhaMobileDetailsIndb(@RequestBody AadharMobileLinkageSaveReq req) {
        CommonResponse resp= service.addAadharMobileLinkageIndb(req);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping(path = "/bulk/add/details")
    public ResponseEntity<CommonResponse> bulkaddAadhaMobileDetailsIndb(@RequestParam("file")MultipartFile file) throws IOException {
        CommonResponse resp= service.bulkaddAadharMobileLinkageIndb(file.getInputStream());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    @PostMapping(path = "/fetch/aadhar-mobile/linkage")
    public ResponseEntity<AadharMobileLinkageInfoResponse> fetchAadharMobileLinkage(@RequestBody  AadharMbileLinkageInfoRequest req) {
       // boolean isValid =RequestValidation.validateAadharMobileLinkageRequest(req);
//        String value = "A";
//        AadharMobileLinkageInfoResponse response=null;
//
//        switch (value){
//            case  "A" :
//                response=AadharMobileLinkageInfoResponse.buildAadharMobileErrorResponse();
//                break;
//            case "B" :
//                response=AadharMobileLinkageInfoResponse.buildAadharMobileErrorResponse();
//                break;
//            case "C" :
//                 response=AadharMobileLinkageInfoResponse.buildAadharMobileErrorResponse();
//                 break;
//        }
//        if (response!=null){
//            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
//        }
        if(RequestValidation.validateAadharMobileLinkageRequest(req)){
            return new ResponseEntity<>(AadharMobileLinkageInfoResponse.buildAadharMobileErrorResponse(
                    400,"Bad Request","AadharMobileLinkage","Please provide request as per contract"),HttpStatus.BAD_REQUEST);
        }else{
            AadharMobileLinkageInfoResponse resp= service.fetchAadharMobileLinkageDetail(req.getEkycAuthenticationReq().getAadharNo(),req.getEkycAuthenticationReq().getMobileNo());
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }
    }

}
