package io.nmsolis12.destiny.client.bungie.model;

public class BungieClanMember {

	private String membershipId;
	private int membershipType;
	private BungieUser user;

	public String getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}

	public int getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(int membershipType) {
		this.membershipType = membershipType;
	}

	public BungieUser getUser() {
		return user;
	}

	public void setUser(BungieUser user) {
		this.user = user;
	}
}
