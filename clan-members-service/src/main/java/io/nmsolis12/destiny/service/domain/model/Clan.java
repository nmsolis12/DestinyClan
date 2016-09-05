package io.nmsolis12.destiny.service.domain.model;

import java.util.List;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "clans")
public class Clan {

	@JsonApiId
	private long clanId;
	
	private List<Account> clanMemberAccounts;

	public Clan() {}

	public Clan(long clanId, List<Account> clanMemberAccounts) {
		this.clanId = clanId;
		this.clanMemberAccounts = clanMemberAccounts;
	}
	
	public long getClanId() {
		return clanId;
	}

	public void setClanId(long clanId) {
		this.clanId = clanId;
	}

	public List<Account> getClanMemberAcccounts() {
		return clanMemberAccounts;
	}

	public void setClanMembers(List<Account> clanMemberAccounts) {
		this.clanMemberAccounts = clanMemberAccounts;
	}
}
