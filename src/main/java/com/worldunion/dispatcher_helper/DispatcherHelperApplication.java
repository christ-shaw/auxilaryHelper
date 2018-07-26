package com.worldunion.dispatcher_helper;

import com.worldunion.clientServer.rocketmq.annoation.EnableRocketmq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableRocketmq
public class DispatcherHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(DispatcherHelperApplication.class, args);
    }
}
