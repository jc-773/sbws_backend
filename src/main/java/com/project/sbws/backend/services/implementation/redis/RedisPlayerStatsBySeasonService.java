package com.project.sbws.backend.services.implementation.redis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.project.sbws.backend.responses.PlayerStatsNBADotCom;

@Service
public class RedisPlayerStatsBySeasonService {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void savePlayerStatsBySeason(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Map<String, PlayerStatsNBADotCom> getValue(String key) {
        return  (Map<String, PlayerStatsNBADotCom>) redisTemplate.opsForValue().get(key);
    }
}
