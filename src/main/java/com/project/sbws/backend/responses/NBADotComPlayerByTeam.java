package com.project.sbws.backend.responses;

import java.util.List;

public class NBADotComPlayerByTeam {
    private Meta meta;
    private Data data;

    // getters and setters
}

class Meta {
    private String schema;
    private String updated;

    // getters and setters
}

class Data {
    private Team t;
    private String seasonType;

    // getters and setters
}

class Team {
    private int tid;
    private String istGroup;
    private List<Player> pl;
    private String ta;
    private String tn;
    private String tc;

    // getters and setters
}

class Player {
    private String fn;
    private String ln;
    private int pid;
    private String num;
    private String pos;
    private String dob;
    private String ht;
    private int wt;
    private int y;
    private String twc;
    private String status;
    private String playerCode;
    private int draftYear;
    private String school;
    private String schoolType;
    private String hcc;

    // getters and setters
}