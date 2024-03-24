package com.project.sbws.backend.responses;

import java.sql.ResultSet;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
   
    @JsonProperty("resultSets")
    private List<ResultSet> resultSets;

}
