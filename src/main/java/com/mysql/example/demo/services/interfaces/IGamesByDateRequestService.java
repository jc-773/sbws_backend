package com.mysql.example.demo.services.interfaces;

public interface IGamesByDateRequestService {
    <T> T GamesByDateResponse_Get(Class<T> clazz, String date, String key);
}
