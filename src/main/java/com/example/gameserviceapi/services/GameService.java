package com.example.gameserviceapi.services;

import com.example.gameserviceapi.commons.entities.Game;

import java.util.List;

public interface GameService {

    List<Game> getAll();

    Game getById(Long id);

    Game save(String userId, Game gameRequest);

    Game update(Long id, Game gameRequest);

    void delete(Long id);

}
