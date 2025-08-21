package com.robertoljr.gamelist.service;

import com.robertoljr.gamelist.dto.GameListDTO;
import com.robertoljr.gamelist.exception.ResourceNotFoundException;
import com.robertoljr.gamelist.projection.GameSummaryProjection;
import com.robertoljr.gamelist.repository.GameListRepository;
import com.robertoljr.gamelist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListServiceImpl implements GameListService {

    private GameListRepository gameListRepository;
    private GameRepository gameRepository;

    @Autowired
    public GameListServiceImpl(GameListRepository gameListRepository, GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
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

    @Override
    @Transactional
    public void moveGameInList(Long listId, int sourceIndex, int targetIndex) {
        List<GameSummaryProjection> list = gameRepository.findAllByListId(listId);
        GameSummaryProjection gameToMove = list.remove(sourceIndex);
        list.add(targetIndex, gameToMove);

        // Update all positions from games between source and destination indexes
        int min = Math.min(sourceIndex, targetIndex);
        int max = Math.max(sourceIndex, targetIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
