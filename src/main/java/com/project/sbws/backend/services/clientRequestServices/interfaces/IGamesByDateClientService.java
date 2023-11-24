package com.project.sbws.backend.services.clientRequestServices.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.sbws.backend.responses.GamesByDate;
import com.project.sbws.backend.responses.mobile.GamesByDateMobileResponse;

public interface IGamesByDateClientService {
    public ResponseEntity<List<GamesByDateMobileResponse>> returnGamesByDate(List<GamesByDate> gamesByDateResponse);
}
