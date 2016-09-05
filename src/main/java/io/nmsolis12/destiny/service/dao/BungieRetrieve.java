package io.nmsolis12.destiny.service.dao;

import java.util.List;

import io.nmsolis12.destiny.service.client.bungie.model.BungieClan;
import io.nmsolis12.destiny.service.client.bungie.model.BungieClanMember;
import io.nmsolis12.destiny.service.client.bungie.model.BungieDestinyCharacter;

public interface BungieRetrieve {

	BungieClan retrieveClanInformation(String clanName);
	
	List<BungieClanMember> retrieveClanMembers(String clanId,int page);
	
	List<BungieDestinyCharacter> retrieveDestinyCharacters(int membershipType, String membershipId);
}
