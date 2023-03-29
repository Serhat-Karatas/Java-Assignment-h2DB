package com.task.imona.service;

import com.task.imona.entity.Player;
import com.task.imona.entity.PlayerAction;
import com.task.imona.repository.PlayerActionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerActionService {
    private final PlayerActionRepository playerActionRepository;

    public PlayerActionService(PlayerActionRepository playerActionRepository) {
        this.playerActionRepository = playerActionRepository;
    }




}
