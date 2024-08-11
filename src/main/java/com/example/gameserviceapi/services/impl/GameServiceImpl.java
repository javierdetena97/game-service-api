package com.example.gameserviceapi.services.impl;

import com.example.gameserviceapi.commons.entities.Game;
import com.example.gameserviceapi.commons.exceptions.GameException;
import com.example.gameserviceapi.repositories.GameRepository;
import com.example.gameserviceapi.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAll() {
        return this.gameRepository.findAll();
    }

    @Override
    public Game getById(String id) {
        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Game not found"));
    }

    @Override
    public Game save(Game newGame) {
        return this.gameRepository.save(newGame);
    }

    @Override
    public Game update(String id, Game newGame) {
        return Optional.of(newGame)
                .map(game -> {
                    game.setId(Long.valueOf(id));
                    return this.gameRepository.save(game);
                })
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Game not found"));
    }

    @Override
    public void delete(String id) {
        gameRepository.deleteById(Long.valueOf(id));
    }

}
