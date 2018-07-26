package com.worldunion.dispatcher_helper.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataCrawledReport {
    String msgCode;
    String MsgDesc;
    String dataType;
    String name;
    String mobile;
    String certNo;

}