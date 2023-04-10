package com.mysql.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mysql.example.demo.responses.GamesByDate;
import com.mysql.example.demo.responses.mobile.GamesByDateMobileResponse;

public interface IGamesByDateClientService {
    public ResponseEntity<List<GamesByDateMobileResponse>> returnGamesByDate(List<GamesByDate> gamesByDateResponse);
}
