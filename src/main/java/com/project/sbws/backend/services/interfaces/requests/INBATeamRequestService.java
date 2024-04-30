package com.project.sbws.backend.services.interfaces.requests;

import java.util.LinkedHashMap;
import java.util.List;

public interface INBATeamRequestService {
     List<LinkedHashMap> playersOnCurrentTeamRoster( String teamName);
}
