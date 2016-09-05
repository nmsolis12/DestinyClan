package io.nmsolis12.destiny.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.nmsolis12.destiny.service.client.bungie.BungieHttpEntity;
import io.nmsolis12.destiny.service.client.bungie.model.BungieClan;
import io.nmsolis12.destiny.service.client.bungie.model.BungieClanMember;
import io.nmsolis12.destiny.service.client.bungie.model.BungieClanMemberResponseWrapper;
import io.nmsolis12.destiny.service.client.bungie.model.BungieClanResponseWrapper;
import io.nmsolis12.destiny.service.client.bungie.model.BungieDestinyCharacter;
import io.nmsolis12.destiny.service.client.bungie.model.BungieDestinyCharacterResponseWrapper;
import io.nmsolis12.destiny.service.domain.model.Clan;

@Component
public class BungieRetrieveImpl implements BungieRetrieve {
	
	@Autowired
	private BungieHttpEntity bungieHttpEntity;
	
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public BungieClan retrieveClanInformation(String clanName) {

		ResponseEntity<BungieClanResponseWrapper> bungieClanResponse = 
				restTemplate.exchange(
						String.format("https://www.bungie.net/Platform/Group/Name/%1$s/", clanName), 
						HttpMethod.GET, 
						bungieHttpEntity.getHttpEntity(), 
						BungieClanResponseWrapper.class);
		
		return bungieClanResponse.getBody().getResponse().getDetail();
	}

	@Override
	public List<BungieClanMember> retrieveClanMembers(String groupId, int page) {
		ResponseEntity<BungieClanMemberResponseWrapper> bungieClanMemberResponse = 
				restTemplate.exchange(
						String.format("https://www.bungie.net/Platform/Group/%1$s/MembersV3/?currentPage=%2$d&platformType=2&itemsPerPage=50", groupId, page), 
						HttpMethod.GET, 
						bungieHttpEntity.getHttpEntity(), 
						BungieClanMemberResponseWrapper.class);
		
		return bungieClanMemberResponse.getBody().getResponse().getResults();
	}

	@Override
	public List<BungieDestinyCharacter> retrieveDestinyCharacters(int membershipType, String membershipId) {
		ResponseEntity<BungieDestinyCharacterResponseWrapper> bungieClanMemberResponse = 
				restTemplate.exchange(
						String.format("https://www.bungie.net/Platform/Destiny/%1$d/Account/%2$s/Summary/", membershipType, membershipId), 
						HttpMethod.GET, 
						bungieHttpEntity.getHttpEntity(), 
						BungieDestinyCharacterResponseWrapper.class);
		
		return bungieClanMemberResponse.getBody().getResponse().getData().getCharacters();
	}

	
}
