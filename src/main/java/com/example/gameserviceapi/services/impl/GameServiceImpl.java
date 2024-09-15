package com.example.gameserviceapi.services.impl;

import com.example.gameserviceapi.commons.constants.Topics;
import com.example.gameserviceapi.commons.entities.Game;
import com.example.gameserviceapi.commons.exceptions.GameException;
import com.example.gameserviceapi.repositories.GameRepository;
import com.example.gameserviceapi.services.GameService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final StreamBridge streamBridge;

    public GameServiceImpl(GameRepository gameRepository, StreamBridge streamBridge) {
        this.gameRepository = gameRepository;
        this.streamBridge = streamBridge;
    }

    @Override
    public List<Game> getAll() {
        return this.gameRepository.findAll();
    }

    @Override
    public Game getById(Long id) {
        return this.gameRepository.findById(id)
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Game not found"));
    }

    @Override
    public Game save(Game gameRequest) {
        return Optional.of(gameRequest)
                .map(gameRepository::save)
                .map(this::sendGameEvent)
                .orElseThrow(() -> new GameException(HttpStatus.BAD_REQUEST, "Error saving game"));
    }

    private Game sendGameEvent(Game game) {
        Optional.of(game)
                .map(givenName -> this.streamBridge.send(Topics.GAME_CREATED_TOPIC, game))
                .map(bool -> game);

        return game;
    }

    @Override
    public Game update(Long id, Game newGame) {
        return Optional.of(newGame)
                .map(game -> {
                    game.setId(id);
                    return this.gameRepository.save(game);
                })
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Error updating game"));
    }

    @Override
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }

}
