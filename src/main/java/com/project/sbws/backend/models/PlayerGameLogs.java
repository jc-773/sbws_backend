package com.project.sbws.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerGameLogs {
      @JsonProperty("SEASON_YEAR")
    private String seasonYear;

    @JsonProperty("PLAYER_ID")
    private int playerId;

    @JsonProperty("PLAYER_NAME")
    private String playerName;

    @JsonProperty("NICKNAME")
    private String nickname;

    @JsonProperty("TEAM_ID")
    private int teamId;

    @JsonProperty("TEAM_ABBREVIATION")
    private String teamAbbreviation;

    @JsonProperty("TEAM_NAME")
    private String teamName;

    @JsonProperty("GAME_ID")
    private int gameId;

    @JsonProperty("GAME_DATE")
    private String gameDate;

    @JsonProperty("MATCHUP")
    private String matchup;

    @JsonProperty("WL")
    private String wl;

    @JsonProperty("MIN")
    private String min;

    @JsonProperty("FGM")
    private int fgm;

    @JsonProperty("FGA")
    private int fga;

    @JsonProperty("FG_PCT")
    private double fgPct;

    @JsonProperty("FG3M")
    private int fg3m;

    @JsonProperty("FG3A")
    private int fg3a;

    @JsonProperty("FG3_PCT")
    private double fg3Pct;

    @JsonProperty("FTM")
    private int ftm;

    @JsonProperty("FTA")
    private int fta;

    @JsonProperty("FT_PCT")
    private double ftPct;

    @JsonProperty("OREB")
    private int oreb;

    @JsonProperty("DREB")
    private int dreb;

    @JsonProperty("REB")
    private int reb;

    @JsonProperty("AST")
    private int ast;

    @JsonProperty("TOV")
    private int tov;

    @JsonProperty("STL")
    private int stl;

    @JsonProperty("BLK")
    private int blk;

    @JsonProperty("BLKA")
    private int blka;

    @JsonProperty("PF")
    private int pf;

    @JsonProperty("PFD")
    private int pfd;

    @JsonProperty("PTS")
    private int pts;

    @JsonProperty("PLUS_MINUS")
    private double plusMinus;

    @JsonProperty("NBA_FANTASY_PTS")
    private double nbaFantasyPts;

    @JsonProperty("DD2")
    private int dd2;

    @JsonProperty("TD3")
    private int td3;

    @JsonProperty("WNBA_FANTASY_PTS")
    private double wnbaFantasyPts;

    @JsonProperty("GP_RANK")
    private int gpRank;

    @JsonProperty("W_RANK")
    private int wRank;

    @JsonProperty("L_RANK")
    private int lRank;

    @JsonProperty("W_PCT_RANK")
    private int wPctRank;

    @JsonProperty("MIN_RANK")
    private int minRank;

    @JsonProperty("FGM_RANK")
    private int fgmRank;

    @JsonProperty("FGA_RANK")
    private int fgaRank;

    @JsonProperty("FG_PCT_RANK")
    private int fgPctRank;

    @JsonProperty("FG3M_RANK")
    private int fg3mRank;

    @JsonProperty("FG3A_RANK")
    private int fg3aRank;

    @JsonProperty("FG3_PCT_RANK")
    private int fg3PctRank;

    @JsonProperty("FTM_RANK")
    private int ftmRank;

    @JsonProperty("FTA_RANK")
    private int ftaRank;

    @JsonProperty("FT_PCT_RANK")
    private int ftPctRank;

    @JsonProperty("OREB_RANK")
    private int orebRank;

    @JsonProperty("DREB_RANK")
    private int drebRank;

    @JsonProperty("REB_RANK")
    private int rebRank;

    @JsonProperty("AST_RANK")
    private int astRank;

    @JsonProperty("TOV_RANK")
    private int tovRank;

    @JsonProperty("STL_RANK")
    private int stlRank;

    @JsonProperty("BLK_RANK")
    private int blkRank;

    @JsonProperty("BLKA_RANK")
    private int blkaRank;

    @JsonProperty("PF_RANK")
    private int pfRank;

    @JsonProperty("PFD_RANK")
    private int pfdRank;

    @JsonProperty("PTS_RANK")
    private int ptsRank;

    @JsonProperty("PLUS_MINUS_RANK")
    private int plusMinusRank;

    @JsonProperty("NBA_FANTASY_PTS_RANK")
    private int nbaFantasyPtsRank;

    @JsonProperty("DD2_RANK")
    private int dd2Rank;

    @JsonProperty("TD3_RANK")
    private int td3Rank;

    @JsonProperty("WNBA_FANTASY_PTS_RANK")
    private int wnbaFantasyPtsRank;

    @JsonProperty("AVAILABLE_FLAG")
    private int availableFlag;

    @JsonProperty("MIN_SEC")
    private String minSec;
}
