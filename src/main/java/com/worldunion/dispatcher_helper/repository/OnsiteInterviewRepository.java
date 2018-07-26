package com.worldunion.dispatcher_helper.repository;

import com.worldunion.dispatcher_helper.data.CredentialAction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnsiteInterviewRepository  extends MongoRepository<CredentialAction,String> {
    // 根据身份证查询缓存的数据
    CredentialAction findByIdCard(String idcard);
}
