package com.robertoljr.gamelist.service;

import com.robertoljr.gamelist.dto.GameListDTO;

import java.util.List;

public interface GameListService {
    List<GameListDTO> findAll();
    void moveGameInList(Long listId, int sourceIndex, int targetIndex);
}
