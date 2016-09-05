package io.nmsolis12.destiny.client.bungie;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class BungieHttpEntity{

	private final HttpEntity<String> httpEntity;
	
	public BungieHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-API-Key", "33fec0f5d5684ca38be8f2eb079b71da");
		
		httpEntity = new HttpEntity<String>("parameters", headers);
	}
	
	public HttpEntity<String> getHttpEntity() {
		return httpEntity;
	}

}
