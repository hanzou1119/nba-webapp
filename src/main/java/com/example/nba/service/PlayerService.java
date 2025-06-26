package com.example.nba.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.nba.model.Player;
import com.example.nba.repository.PlayerRepository;


@Service
public class PlayerService {

    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public void save(Player player) {
        repository.save(player);
    }

    public List<Player> findAll() {
        return repository.findAll();
    }

    public Player findById(Integer id) {
        return repository.findById(id).orElse(null); // 見つからなければ null を返す
        // return repository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
    }

    public List<Player> searchByName(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Player> searchByNameAndTeam(String name, String team) {
        return repository.findByNameContainingAndTeam(name, team);
    }
}