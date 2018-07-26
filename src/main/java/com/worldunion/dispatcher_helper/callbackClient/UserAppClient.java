package com.worldunion.dispatcher_helper.callbackClient;

import com.worldunion.dispatcher_helper.data.DataCrawledReport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(url="LOANAPPLICATION_MICROSERVICE",name = "userappclient")
public interface UserAppClient {
    @PostMapping("/callback/report")
    Map<String, String> handleCrawledState(@RequestBody DataCrawledReport data);
}
