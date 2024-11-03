package com.thirdparty.apiservice.service;

import com.thirdparty.apiservice.dto.BulkAddAadharMobileLinkage;

import java.util.List;

public interface AadharMobileLinkageBatchRepo {

    void addAadharMobileLinkage(List<BulkAddAadharMobileLinkage> request);
}
