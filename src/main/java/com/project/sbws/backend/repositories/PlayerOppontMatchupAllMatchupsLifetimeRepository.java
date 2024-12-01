package com.project.sbws.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.sbws.backend.repositories.documents.PlayerOppontMatchupAllMatchupsLifetimeDocument;

public interface PlayerOppontMatchupAllMatchupsLifetimeRepository extends MongoRepository <PlayerOppontMatchupAllMatchupsLifetimeDocument, String>{
    Optional<PlayerOppontMatchupAllMatchupsLifetimeDocument> findById(String id);

    //@Query(value = "{ '_id': ?0 }", fields = "{ 'gameLog': { '$filter': { 'input': '$gameLog', 'as': 'log', 'cond': { '$and': [ { '$eq': ['$$log.playerName', 'Larry Nance Jr.'] }, { '$gte': ['$$log.pts', 10] } ] } } } }")
    //@Query(value = "{ '_id': ?0 }", fields = "{ 'gameLog': { '$filter': { 'input': '$gameLog', 'as': 'log', 'cond': { '$and': [ { '$eq': ['$$log.playerName', ?1] }, { '$gte': ['$$log.pts', 10] } ] } } } }")
    //@Query(value = "{ '_id': ?0, 'gameLog.matchup': ?1 }", fields = "{ 'gameLog': 1, '_id': 0 }")
     @Aggregation(pipeline = {
        "{ '$match': { '_id': ?0, 'gameLog.matchup': ?1 } }",
        "{ '$project': { 'gameLog': { '$filter': { 'input': '$gameLog', 'as': 'log', 'cond': { '$eq': ['$$log.matchup', ?1] } } }, '_id': 0 } }"
    })
    Optional<PlayerOppontMatchupAllMatchupsLifetimeDocument> findByPlayerIdAndMatchup(String playerID, String matchup);
}
