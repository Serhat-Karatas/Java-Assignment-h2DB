package com.task.imona.repository;

import com.task.imona.entity.PlayerAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerActionRepository extends JpaRepository<PlayerAction,Long> {
   // public List<PlayerAction> findPlayerActionsByPlayer_id(Long id);
   // public List<PlayerAction> findPlayerActionsByAction_id(Long id);
}
