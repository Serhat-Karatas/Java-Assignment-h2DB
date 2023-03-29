package com.task.imona.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Base64;

@Entity
@Table
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=100)
    private String name;

    @Column(nullable = false)
    private String description;

    @Lob
    private byte[] logo;

    public Game(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Game() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLogoBase64() {
        return Base64.getEncoder().encodeToString(this.logo);
    }
}
