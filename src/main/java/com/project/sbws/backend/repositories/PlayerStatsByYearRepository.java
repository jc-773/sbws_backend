package com.project.sbws.backend.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.sbws.backend.repositories.documents.PlayerStatsBySeasonDocument;

public interface PlayerStatsByYearRepository extends MongoRepository <PlayerStatsBySeasonDocument, String> {
    Optional<PlayerStatsBySeasonDocument> findById(String id);
}
