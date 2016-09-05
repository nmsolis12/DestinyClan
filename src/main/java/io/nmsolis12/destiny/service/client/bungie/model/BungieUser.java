package io.nmsolis12.destiny.service.client.bungie.model;

public class BungieUser {

	private String membershipId;
	private String displayName;
	private String psnDisplayName;
	
	public String getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(String memberId) {
		this.membershipId = memberId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPsnDisplayName() {
		return psnDisplayName;
	}
	public void setPsnDisplayName(String psnDisplayName) {
		this.psnDisplayName = psnDisplayName;
	}
	
	
}
