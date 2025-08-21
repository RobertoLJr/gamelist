package com.robertoljr.gamelist.service;

import com.robertoljr.gamelist.dto.GameCreateDTO;
import com.robertoljr.gamelist.dto.GameInfoDTO;
import com.robertoljr.gamelist.dto.GameSummaryDTO;
import com.robertoljr.gamelist.entity.Game;
import com.robertoljr.gamelist.exception.ResourceNotFoundException;
import com.robertoljr.gamelist.projection.GameSummaryProjection;
import com.robertoljr.gamelist.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional
    public GameInfoDTO save(GameCreateDTO dto) {
        Game entity = new Game();
        BeanUtils.copyProperties(dto, entity);

        entity = gameRepository.save(entity);
        return new GameInfoDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GameSummaryDTO> findAll() {
        if (gameRepository.findAll().isEmpty()) {
            throw new ResourceNotFoundException("No games found");
        }

        return gameRepository.findAll().stream()
                .map(GameSummaryDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public GameInfoDTO findById(Long id) {
        Optional<Game> gameDB = gameRepository.findById(id);

        return gameDB.map(GameInfoDTO::new).orElseThrow(
                () -> new ResourceNotFoundException("Game not found with ID " + id)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<GameSummaryDTO> findByListId(Long id) {
        List<GameSummaryProjection> gameProjectionsDB = gameRepository.findAllByListId(id);

        if (gameProjectionsDB.isEmpty()) {
            throw new ResourceNotFoundException("Game list not found with ID " + id);
        }

        return gameProjectionsDB.stream()
                .map(GameSummaryDTO::new)
                .toList();
    }
}
