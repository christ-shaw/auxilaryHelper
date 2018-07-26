package com.worldunion.dispatcher_helper.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

public class CredentialAction implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6058779981344106182L;

	@Id
    @JsonIgnore
    public String id;

    @Indexed
    public String applicationId;

    @Indexed
    public String idCard;
    public String isEconSigned;// 0 未查询征信，,1 客户授信成功， 2失败
    public String bankCardNo;
    public String bankName;
    public String bankVerification;// 0 未查询征信，,1 客户授信成功， 2失败

    public String initativeSystem; // 面签发起系统  目前包括channel ，userapp

    public CredentialState jdState = CredentialState.UNCOMMITTED;
    public CredentialState taobaoState = CredentialState.UNCOMMITTED;
    public CredentialState carrierState = CredentialState.UNCOMMITTED;
    public CredentialState chiscState = CredentialState.UNCOMMITTED;


    
}