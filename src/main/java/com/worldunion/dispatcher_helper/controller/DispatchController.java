package com.worldunion.dispatcher_helper.controller;

import com.worldunion.dispatcher_helper.callbackClient.ChannelAppClient;
import com.worldunion.dispatcher_helper.callbackClient.UserAppClient;
import com.worldunion.dispatcher_helper.data.CredentialAction;
import com.worldunion.dispatcher_helper.data.DataCrawledReport;
import com.worldunion.dispatcher_helper.repository.OnsiteInterviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/dispatch/api/callback")
@RestController
@Slf4j
public class DispatchController {
    @Autowired
    OnsiteInterviewRepository repository;

    @Autowired
    ChannelAppClient channelAppClient;

    @Autowired
    UserAppClient userAppClient;

    @PostMapping("report")
    public Map<String, String> handleCrawledState(@RequestBody DataCrawledReport data) {
        String certNo = data.getCertNo();
        if (certNo == null || certNo.isEmpty()) {
            log.warn("empty certid, then discard request");

            Map<String, String> response = new HashMap<>();
            response.put("resultCode", "CCOM8999");
            response.put("resultDesc", "empty certid, then discard request");
            return response;
        }
        CredentialAction action = repository.findByIdCard(certNo);
        if (action == null) {
            log.warn("certID not recognized {}", certNo);
            Map<String, String> response = new HashMap<>();
            response.put("resultCode", "CCOM8999");
            response.put("resultDesc", "certID not recognized");
            return response;
        }

        String initiativeSystem = action.initativeSystem;
        if (initiativeSystem == null || initiativeSystem.isEmpty()) {
            log.warn("unknown system");
            Map<String, String> response = new HashMap<>();
            response.put("resultCode", "CCOM8999");
            response.put("resultDesc", "unknown system");
            return response;
        }
        switch (initiativeSystem) {
            case "channel":
                return channelAppClient.handleCrawledState(data);
            case "userapp":
                return userAppClient.handleCrawledState(data);
            default:
                Map<String, String> response = new HashMap<>();
                response.put("resultCode", "CCOM8999");
                response.put("resultDesc", "unknown system");
                return response;
        }

    }
}
