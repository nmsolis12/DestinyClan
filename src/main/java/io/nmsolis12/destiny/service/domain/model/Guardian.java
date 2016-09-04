package io.nmsolis12.destiny.service.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiId;
import io.nmsolis12.destiny.service.domain.model.bean.ModelDate;

public class Guardian {

	@JsonApiId
	private long guardianId;
	
	@JsonProperty
	private String classType;
	 
	@JsonProperty
	private ModelDate dateLastPlayed;

	public Guardian() {}
	
	public Guardian(long guardianId, String classType, ModelDate dateLastPlayed) {
		this.guardianId = guardianId;
		this.classType = classType;
		this.dateLastPlayed = dateLastPlayed;
	}
	
	public long getGuardianId() {
		return guardianId;
	}

	public void setGuardianId(long guardianId) {
		this.guardianId = guardianId;
	}

	public ModelDate getDateLastPlayed() {
		return dateLastPlayed;
	}

	public void setDateLastPlayed(ModelDate dateLastPlayed) {
		this.dateLastPlayed = dateLastPlayed;
	}
	
	
	
}
