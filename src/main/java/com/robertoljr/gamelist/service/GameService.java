package com.robertoljr.gamelist.service;

import com.robertoljr.gamelist.dto.GameSummaryDTO;

import java.util.List;

public interface GameService {
    List<GameSummaryDTO> findAll();
}
