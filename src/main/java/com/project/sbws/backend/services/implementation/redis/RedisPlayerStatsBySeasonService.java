package com.project.sbws.backend.services.implementation.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisPlayerStatsBySeasonService {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void savePlayerStatsBySeason(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
