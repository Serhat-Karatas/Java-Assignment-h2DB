package com.task.imona.entity;

import jakarta.persistence.*;

@Entity
public class PlayerAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long player_id;

    @Column(nullable = false)
    private Long action_id;

    public PlayerAction(Long player_id, Long action_id) {
        this.player_id = player_id;
        this.action_id = action_id;
    }

    public PlayerAction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Long player_id) {
        this.player_id = player_id;
    }

    public Long getAction_id() {
        return action_id;
    }

    public void setAction_id(Long action_id) {
        this.action_id = action_id;
    }
}
