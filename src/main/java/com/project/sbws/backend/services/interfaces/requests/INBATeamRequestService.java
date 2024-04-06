package com.project.sbws.backend.services.interfaces.requests;

import java.util.List;

import com.project.sbws.backend.responses.PlayerInfoByTeam;

public interface INBATeamRequestService {
     List<PlayerInfoByTeam> playersOnCurrentTeamRoster( String teamName);
}
