package com.task.imona.service;

import com.task.imona.entity.Action;
import com.task.imona.entity.Player;
import com.task.imona.entity.PlayerAction;
import com.task.imona.repository.ActionRepository;
import com.task.imona.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RelationshipService {
    private final PlayerRepository playerRepository;

    private final ActionRepository actionRepository;

    public RelationshipService(PlayerRepository playerRepository, ActionRepository actionRepository) {
        this.playerRepository = playerRepository;
        this.actionRepository = actionRepository;
    }

    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }
/*
    public void addActionToPlayer(Long playerId, Long actionId) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException());
        Action action = actionRepository.findById(actionId).orElseThrow(() -> new RuntimeException());

        PlayerAction playerAction = new PlayerAction();
        playerAction.setPlayer(player);
        playerAction.setAction(action);

        player.getPlayerActions().add(playerAction);
        action.getPlayerActions().add(playerAction);

        playerRepository.save(player);
    }*/
}
