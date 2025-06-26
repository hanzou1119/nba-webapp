package com.example.nba.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nba.model.Player;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
	List<Player> findByNameContaining(String name);

	List<Player> findByNameContainingAndTeam(String name, String team);

}
