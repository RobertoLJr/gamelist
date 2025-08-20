package com.robertoljr.gamelist.service;

import com.robertoljr.gamelist.dto.GameListDTO;
import com.robertoljr.gamelist.exception.ResourceNotFoundException;
import com.robertoljr.gamelist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListServiceImpl implements GameListService {

    private GameListRepository gameListRepository;

    @Autowired
    public GameListServiceImpl(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        if (gameListRepository.findAll().isEmpty()) {
            throw new ResourceNotFoundException("No game list found");
        }

        return gameListRepository.findAll().stream()
                .map(GameListDTO::new)
                .toList();
    }
}
