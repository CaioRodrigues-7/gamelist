package com.cerd.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerd.gamelist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
