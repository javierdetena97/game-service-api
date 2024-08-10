package com.example.gameserviceapi.services;

import com.example.gameserviceapi.commons.entities.Game;

public interface GameService {
    Game saveGame(Game gameRequest);
    Game getGameById(String id);
}
