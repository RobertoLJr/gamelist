package com.robertoljr.gamelist.repository;

import com.robertoljr.gamelist.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
