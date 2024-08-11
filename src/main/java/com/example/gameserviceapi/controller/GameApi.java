package com.example.gameserviceapi.controller;

import com.example.gameserviceapi.commons.constants.ApiPathsVariables;
import com.example.gameserviceapi.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathsVariables.V1_ROUTE + ApiPathsVariables.GAME_ROUTE)
public interface GameApi {

    @GetMapping("/all")
    ResponseEntity<List<Game>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<Game> getById(@PathVariable String id);

    @PostMapping
    ResponseEntity<Game> save(@RequestBody Game game);

    @PutMapping("/{id}")
    ResponseEntity<Game> update(@PathVariable String id, @RequestBody Game game);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable String id);
}
