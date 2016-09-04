package io.nmsolis12.destiny.service.client.bungie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BungieClanResponseWrapper {

	@JsonProperty(value="Response")
	private BungieClanResponse response;
	
	@JsonProperty(value="ErrorCode")
	private String errorCode;
	
	public BungieClanResponse getResponse() {
		return response;
	}
	public void setResponse(BungieClanResponse response) {
		this.response = response;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
