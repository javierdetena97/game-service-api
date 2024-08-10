package com.example.gameserviceapi.controller;

import com.example.gameserviceapi.commons.constants.ApiPathsVariables;
import com.example.gameserviceapi.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathsVariables.V1_ROUTE + ApiPathsVariables.GAME_ROUTE)
public interface GameApi {

    @PostMapping
    ResponseEntity<Game> saveGame(@RequestBody Game game);

    @GetMapping
    ResponseEntity<Game> getGameById(@PathVariable String id);

    @DeleteMapping
    ResponseEntity<Void> deleteGame(@PathVariable String id);
}
