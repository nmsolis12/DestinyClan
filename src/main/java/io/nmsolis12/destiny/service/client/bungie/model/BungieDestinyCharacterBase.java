package io.nmsolis12.destiny.service.client.bungie.model;

public class BungieDestinyCharacterBase {
	
	private String characterId;
	private String dateLastPlayed;
	private int powerLevel;
    private String raceHash;
    private String genderHash;
    private String classHash;
    
	public String getCharacterId() {
		return characterId;
	}
	public void setCharacterId(String characterId) {
		this.characterId = characterId;
	}
	public String getDateLastPlayed() {
		return dateLastPlayed;
	}
	public void setDateLastPlayed(String dateLastPlayed) {
		this.dateLastPlayed = dateLastPlayed;
	}
	public int getPowerLevel() {
		return powerLevel;
	}
	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}
	public String getRaceHash() {
		return raceHash;
	}
	public void setRaceHash(String raceHash) {
		this.raceHash = raceHash;
	}
	public String getGenderHash() {
		return genderHash;
	}
	public void setGenderHash(String genderHash) {
		this.genderHash = genderHash;
	}
	public String getClassHash() {
		return classHash;
	}
	public void setClassHash(String classHash) {
		this.classHash = classHash;
	}
}
