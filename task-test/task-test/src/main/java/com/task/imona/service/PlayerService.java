package com.task.imona.service;

import com.task.imona.entity.Player;


import java.util.List;


public interface PlayerService {
    List<Player> getAllPlayers();

    Player savePlayer(Player player);

    Player getPlayerById(Long id);

    Player updatePlayer(Player player);

    void deletePlayerById(Long id);
}
