package io.nmsolis12.destiny.service.domain.repository;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import io.nmsolis12.destiny.service.client.bungie.model.BungieClanResponseWrapper;
import io.nmsolis12.destiny.service.domain.model.Account;
import io.nmsolis12.destiny.service.domain.model.Clan;
import io.nmsolis12.destiny.service.domain.model.Guardian;
import io.nmsolis12.destiny.service.domain.model.bean.ModelDate;

@JsonApiResourceRepository(Clan.class)
@Component
public class ClanRepository {

	private static final Clan FAKE_CLAN_FOR_TEST = createFakeClan();
	
	@JsonApiFindOne
	public Clan findOne(long clanId, QueryParams requestParams){
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-API-Key", "33fec0f5d5684ca38be8f2eb079b71da");
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<BungieClanResponseWrapper> bungieClanResponse = 
				restTemplate.exchange("https://www.bungie.net/Platform/Group/Name/DadsOfDestiny Echo/", 
						HttpMethod.GET, 
						entity, 
						BungieClanResponseWrapper.class);
		
		Clan newClan = new Clan(Long.parseLong(bungieClanResponse.getBody().getResponse().getDetail().getGroupId()), null);
		return newClan;
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
