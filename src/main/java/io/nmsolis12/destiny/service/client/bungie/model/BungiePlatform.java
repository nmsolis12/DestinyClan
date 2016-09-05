package io.nmsolis12.destiny.service.client.bungie.model;

public enum BungiePlatform {

	XBOX("1"),
	PLAYSTATION("2");
	
	private String bungieValue;
	BungiePlatform(String bungieValue) {
		this.bungieValue = bungieValue;
	}
	
	public String bungieValue() {
		return bungieValue;
	}
}
