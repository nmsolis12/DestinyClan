package io.nmsolis12.destiny.client.bungie;

import java.util.List;

import io.nmsolis12.destiny.client.bungie.model.BungieClan;
import io.nmsolis12.destiny.client.bungie.model.BungieClanMember;
import io.nmsolis12.destiny.client.bungie.model.BungieDestinyCharacter;

public interface BungieRetrieve {

	BungieClan retrieveClanInformation(String clanName);
	
	List<BungieClanMember> retrieveClanMembers(String clanId,int page);
	
	List<BungieDestinyCharacter> retrieveDestinyCharacters(int membershipType, String membershipId);
}
