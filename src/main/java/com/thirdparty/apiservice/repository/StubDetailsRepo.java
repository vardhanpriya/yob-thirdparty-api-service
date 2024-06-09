package com.thirdparty.apiservice.repository;

import com.thirdparty.apiservice.entity.StubDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StubDetailsRepo extends JpaRepository<StubDetails, String> {

    StubDetails findByStubUrlAndUniqueIdVal(String stubUrl, String uniqueIdval);

}
