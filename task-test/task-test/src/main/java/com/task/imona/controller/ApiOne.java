package com.task.imona.controller;

import com.task.imona.entity.Game;
import com.task.imona.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiOne {

    private final GameService gameService;

    public ApiOne(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/api/game/{gameId}")
    public Game getGameDetails(@PathVariable("gameId") Long gameId) {
        // gameId'ye göre ilgili oyunun detaylarını al ve JSON formatında döndür.
        Game game = gameService.getGameById(gameId);
        return game;
    }
}
