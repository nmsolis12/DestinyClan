package io.nmsolis12.destiny.service.client.bungie.model;

import java.util.List;

public class BungieClanMemberResponse {

	private List<BungieClanMember> results;

	public List<BungieClanMember> getResults() {
		return results;
	}

	public void setResults(List<BungieClanMember> results) {
		this.results = results;
	}
}
