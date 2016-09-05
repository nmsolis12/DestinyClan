package io.nmsolis12.destiny.service.domain.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import io.nmsolis12.destiny.service.client.bungie.model.BungieClan;
import io.nmsolis12.destiny.service.client.bungie.model.BungieClanMember;
import io.nmsolis12.destiny.service.client.bungie.model.BungieClanResponseWrapper;
import io.nmsolis12.destiny.service.client.bungie.model.BungieDestinyCharacter;
import io.nmsolis12.destiny.service.dao.BungieRetrieve;
import io.nmsolis12.destiny.service.domain.model.Account;
import io.nmsolis12.destiny.service.domain.model.Clan;
import io.nmsolis12.destiny.service.domain.model.Guardian;
import io.nmsolis12.destiny.service.domain.model.bean.ModelDate;

@JsonApiResourceRepository(Clan.class)
@Component
public class ClanRepository {

	private static final Clan FAKE_CLAN_FOR_TEST = createFakeClan();
	
	@Autowired
	private final BungieRetrieve bungieRetrieve;
	
	public ClanRepository(BungieRetrieve bungieRetrieve) {
		this.bungieRetrieve =bungieRetrieve;
	}
	
	@JsonApiFindOne
	public Clan findOne(long clanId, QueryParams requestParams){
		return null;
	}
	
    @JsonApiFindAll
    public List<Clan> findAll(QueryParams requestParams) {
    	// TODO: All of this needs to be refactored into orchestration classes using adapters
		String clanName = getClanNameParameter(requestParams);
		BungieClan clan = bungieRetrieve.retrieveClanInformation(clanName);
		List<BungieClanMember> clanMembers = bungieRetrieve.retrieveClanMembers(clan.getGroupId(), 1);
		clanMembers.addAll(bungieRetrieve.retrieveClanMembers(clan.getGroupId(), 2));
		
		for (BungieClanMember clanMember: clanMembers) {
			//TODO: Use character summary to get each character's last play date. Then figure the latest play date.
			List<BungieDestinyCharacter> characters = bungieRetrieve.retrieveDestinyCharacters(clanMember.getMembershipType(), clanMember.getMembershipId());
			System.out.println(characters.size());
		}
		
		return null;
    }

	private String getClanNameParameter(QueryParams requestParams) {
		return "DadsOfDestiny Echo";
	}

	private static Clan createFakeClan() {
		Guardian blenWarlock = new Guardian(1L, "warlock", new ModelDate(11,7,1981));
		Guardian blenTitan = new Guardian(2L, "titan", new ModelDate(5,6,2001));
		Guardian blenHunter = new Guardian(3L, "hunter", new ModelDate(6,12,2011));
		Account blen = new Account(5L, Arrays.asList(blenWarlock, blenTitan, blenHunter), new ModelDate(6,12,2011));
		
		Guardian venWarlock = new Guardian(12L, "warlock", new ModelDate(11,7,1981));
		Guardian venTitan = new Guardian(14L, "titan", new ModelDate(5,6,2001));
		Guardian venHunter = new Guardian(16L, "hunter", new ModelDate(6,12,2011));
		Account ven = new Account(18L, Arrays.asList(venWarlock, venTitan, venHunter), new ModelDate(6,12,2011));
		
		Clan clan = new Clan(34L, Arrays.asList(blen, ven));
	
		return clan;
	}
}
