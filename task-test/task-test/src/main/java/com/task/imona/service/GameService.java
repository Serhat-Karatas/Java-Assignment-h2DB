package com.task.imona.service;

import com.task.imona.entity.Game;
import com.task.imona.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id).get();
    }

    public Game getFirstObjectToAllList(){
        List<Game> game = gameRepository.findAll();
        Game firstGame = game.isEmpty() ? null : game.get(0);
        return firstGame;
    }

    public Game saveGame(Game game){return gameRepository.save(game); }

}
