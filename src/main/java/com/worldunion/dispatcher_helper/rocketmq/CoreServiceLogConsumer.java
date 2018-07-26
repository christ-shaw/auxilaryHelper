package com.worldunion.dispatcher_helper.rocketmq;


import com.worldunion.clientServer.api.FeignLog.FeigLogSummary;
import com.worldunion.clientServer.rocketmq.annoation.MQConsumer;
import com.worldunion.clientServer.rocketmq.api.AbstractMQPushConsumer;
import com.worldunion.dispatcher_helper.repository.mongo.FeignLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Slf4j
@MQConsumer(topic = "TopicTest", consumerGroup = "local_dev")
public class CoreServiceLogConsumer extends AbstractMQPushConsumer<FeigLogSummary> {
    @Autowired
    FeignLogRepository repository;

    @Override
    public boolean process(FeigLogSummary message, Map<String, Object> extMap) {
        log.info("save log begins");
        repository.save(message);
        log.info("save log ends");
        return true;
    }
}