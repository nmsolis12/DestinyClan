package io.nmsolis12.destiny.client.bungie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BungieClanMemberResponseWrapper {

	@JsonProperty(value="Response")
	private BungieClanMemberResponse response;
	
	@JsonProperty(value="ErrorCode")
	private String errorCode;
	
	public BungieClanMemberResponse getResponse() {
		return response;
	}
	public void setResponse(BungieClanMemberResponse response) {
		this.response = response;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
