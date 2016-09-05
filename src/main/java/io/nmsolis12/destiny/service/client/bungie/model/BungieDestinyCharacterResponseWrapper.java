package io.nmsolis12.destiny.service.client.bungie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BungieDestinyCharacterResponseWrapper {

	@JsonProperty(value="Response")
	private BungieDestinyCharacterResponse response;
	
	@JsonProperty(value="ErrorCode")
	private String errorCode;
	
	public BungieDestinyCharacterResponse getResponse() {
		return response;
	}
	public void setResponse(BungieDestinyCharacterResponse response) {
		this.response = response;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
