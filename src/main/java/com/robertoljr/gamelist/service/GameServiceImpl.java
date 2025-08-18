package com.robertoljr.gamelist.service;

import com.robertoljr.gamelist.dto.GameSummaryDTO;
import com.robertoljr.gamelist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameSummaryDTO> findAll() {
        return gameRepository.findAll().stream()
                .map(GameSummaryDTO::new)
                .toList();
    }
}
