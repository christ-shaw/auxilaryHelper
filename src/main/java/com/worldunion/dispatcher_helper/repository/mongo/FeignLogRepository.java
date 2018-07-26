package com.worldunion.dispatcher_helper.repository.mongo;

import com.worldunion.clientServer.api.FeignLog.FeigLogSummary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeignLogRepository extends MongoRepository<FeigLogSummary,String> {

}
