package com.robertoljr.gamelist.controller;

import com.robertoljr.gamelist.dto.GameListDTO;
import com.robertoljr.gamelist.dto.GameSummaryDTO;
import com.robertoljr.gamelist.service.GameListService;
import com.robertoljr.gamelist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/game_lists")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    @Autowired
    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping()
    public ResponseEntity<List<GameListDTO>> findAll() {
        return ResponseEntity.ok(gameListService.findAll());
    }

    @GetMapping(value = "/{list_id}/games")
    public ResponseEntity<List<GameSummaryDTO>> findByListId(@PathVariable Long list_id) {
        return  ResponseEntity.ok(gameService.findByListId(list_id));
    }
}
