package io.nmsolis12.destiny.service.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.nmsolis12.destiny.service.domain.model.bean.ModelDate;

public class Account {

	@JsonApiId
	private long accountId;
	
	private List<Guardian> guardians;
	
	@JsonProperty
	private ModelDate dateLastPlayed;
	
	public Account() {}
	
	public Account(long accountId, List<Guardian> guardians, ModelDate dateLastPlayed) {
		this.accountId = accountId;
		this.guardians = guardians;
		this.dateLastPlayed = dateLastPlayed;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public List<Guardian> getGuardians() {
		return guardians;
	}

	public void setGuardians(List<Guardian> guardians) {
		this.guardians = guardians;
	}

	public ModelDate getDateLastPlayed() {
		return dateLastPlayed;
	}

	public void setDateLastPlayed(ModelDate dateLastPlayed) {
		this.dateLastPlayed = dateLastPlayed;
	}
	
	
}
