package com.task.imona.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String descriptions;

    @Column(nullable = false)
    private long score;

    public Action(String name, String descriptions, long score) {
        this.name = name;
        this.descriptions = descriptions;
        this.score = score;
    }

    public Action() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }


}
