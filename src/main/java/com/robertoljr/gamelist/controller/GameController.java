package com.robertoljr.gamelist.controller;

import com.robertoljr.gamelist.dto.GameCreateDTO;
import com.robertoljr.gamelist.dto.GameInfoDTO;
import com.robertoljr.gamelist.dto.GameSummaryDTO;
import com.robertoljr.gamelist.service.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping()
    public ResponseEntity<GameInfoDTO> save(@Valid @RequestBody GameCreateDTO dto) {
        return ResponseEntity.ok(gameService.save(dto));
    }

    @GetMapping()
    public ResponseEntity<List<GameSummaryDTO>> findAll() {
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameInfoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.findById(id));
    }
}
