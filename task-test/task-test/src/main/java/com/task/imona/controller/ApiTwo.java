package com.task.imona.controller;

import com.task.imona.entity.Player;
import com.task.imona.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTwo {

    private final PlayerService playerService;

    public ApiTwo(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/api/player/{playerId}")
    public Player getPlayerDetails(@PathVariable("playerId") Long playerId) {
        Player player = playerService.getPlayerById(playerId);
        return player;
    }
}
