package com.task.imona.service.impl;

import com.task.imona.entity.Player;
import com.task.imona.entity.PlayerAction;
import com.task.imona.repository.PlayerActionRepository;
import com.task.imona.repository.PlayerRepository;
import com.task.imona.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private final PlayerActionRepository playerActionRepository;


    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerActionRepository playerActionRepository) {
        super();
        this.playerRepository = playerRepository;
        this.playerActionRepository = playerActionRepository;
    }
    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).get();
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }
}
