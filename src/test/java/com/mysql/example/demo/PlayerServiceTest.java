package com.mysql.example.demo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import com.project.sbws.backend.responses.PlayerProjectionResponse;
import com.project.sbws.backend.responses.containers.PlayerProjectionContainer;
import com.project.sbws.backend.responses.mobile.PlayerProfileResponse;
import com.project.sbws.backend.services.clientRequestServices.implementations.PlayerService;

@SpringBootTest(classes=PlayerService.class)
public class PlayerServiceTest {
    
    @Bean
	public PlayerService playerService() {
		return new PlayerService();
	}

    @Test
	void testStreamPlayerCollectionMatchesPassedInPlayerID_Success() {
		PlayerService p = new PlayerService();
		PlayerProjectionContainer ppc = new PlayerProjectionContainer();
		ppc.response = new ArrayList<>();

		PlayerProjectionResponse ppr = new PlayerProjectionResponse();
		ppr.assists = 13.5;
		ppr.playerID = 20000554;

		ppc.response.add(ppr);

		PlayerProjectionResponse pprFinal = p.returnPlayerProfileMatchingPlayerID(ppc,"20000554");

		Assert.notNull(pprFinal, "Daaaaaamn");
	}

    @Test
	void testStreamPlayerCollectionMatchesPassedInPlayerID_NullPlayerID_Fail() {
		PlayerService p = new PlayerService();
		PlayerProjectionContainer ppc = new PlayerProjectionContainer();
		ppc.response = new ArrayList<>();

		PlayerProjectionResponse ppr = new PlayerProjectionResponse();
		ppr.assists = 13.5;
		ppr.playerID = 20000554;

		ppc.response.add(ppr);

		PlayerProjectionResponse pprFinal = p.returnPlayerProfileMatchingPlayerID(ppc,null);

		Assert.isNull(pprFinal, "Daaaaaamn");
	}

    @Test
	void testStreamPlayerCollectionMatchesPassedInPlayerID_NoPlayerIDInCollection_Fail() {
		PlayerService p = new PlayerService();
		PlayerProjectionContainer ppc = new PlayerProjectionContainer();
		ppc.response = new ArrayList<>();

		PlayerProjectionResponse ppr = new PlayerProjectionResponse();
		ppr.assists = 13.5;
		ppr.playerID = 20004;

		ppc.response.add(ppr);

		PlayerProjectionResponse pprFinal = p.returnPlayerProfileMatchingPlayerID(ppc,"20000554");

		Assert.isNull(pprFinal, "Daaaaaamn");
	}

@Test
void testPlayerProfileInformationBuild_Success() {
    PlayerProjectionResponse playerProjectionResponse = new PlayerProjectionResponse();
    playerProjectionResponse.points = 1.0;
    playerProjectionResponse.assists = 1.0;
    playerProjectionResponse.rebounds = 1.0;
    playerProjectionResponse.threePointersMade = 1.0;

    PlayerService p = new PlayerService();

    PlayerProfileResponse ppr = p.buildPlayerProfileBasicInformation(playerProjectionResponse);

    Assert.notNull(ppr, "");
}

@Test
void testPlayerProfileInformationBuild_NULLPlayerProjectionResponse_Fail() {
    PlayerProjectionResponse playerProjectionResponse = null;

    PlayerService p = new PlayerService();

    PlayerProfileResponse ppr = p.buildPlayerProfileBasicInformation(playerProjectionResponse);

    Assert.isNull(ppr, "");
}

}
