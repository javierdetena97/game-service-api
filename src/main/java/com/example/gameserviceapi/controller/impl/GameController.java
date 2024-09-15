package com.example.gameserviceapi.controller.impl;

import com.example.gameserviceapi.commons.entities.Game;
import com.example.gameserviceapi.controller.GameApi;
import com.example.gameserviceapi.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController implements GameApi {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<List<Game>> getAll() {
        return ResponseEntity.ok(this.gameService.getAll());
    }

    @Override
    public ResponseEntity<Game> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.gameService.getById(id));
    }

    @Override
    public ResponseEntity<Game> save(@RequestBody Game gameRequest) {
        Game gameCreated = this.gameService.save(gameRequest);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game) {
        Game gameUpdated = this.gameService.update(id, game);
        return ResponseEntity.ok(gameUpdated);
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.gameService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
