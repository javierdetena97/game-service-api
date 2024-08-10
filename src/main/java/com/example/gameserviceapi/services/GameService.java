package com.example.gameserviceapi.services;

import com.example.gameserviceapi.commons.entities.Game;

import java.util.List;

public interface GameService {

    List<Game> getAll();

    Game getById(String id);

    Game save(Game gameRequest);

    Game update(Game gameRequest);

    boolean delete(String id);

}
