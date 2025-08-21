package com.robertoljr.gamelist.service;

import com.robertoljr.gamelist.dto.GameCreateDTO;
import com.robertoljr.gamelist.dto.GameInfoDTO;
import com.robertoljr.gamelist.dto.GameSummaryDTO;

import java.util.List;

public interface GameService {
    GameInfoDTO save(GameCreateDTO dto);

    List<GameSummaryDTO> findAll();

    GameInfoDTO findById(Long id);

    List<GameSummaryDTO> findByListId(Long id);
}
