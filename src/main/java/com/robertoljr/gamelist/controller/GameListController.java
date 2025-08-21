package com.robertoljr.gamelist.controller;

import com.robertoljr.gamelist.dto.GameListDTO;
import com.robertoljr.gamelist.dto.GameReplacementDTO;
import com.robertoljr.gamelist.dto.GameSummaryDTO;
import com.robertoljr.gamelist.service.GameListService;
import com.robertoljr.gamelist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/{list_id}/replacement")
    public ResponseEntity<Void> moveGameInList(@PathVariable Long list_id, @RequestBody GameReplacementDTO body) {
        gameListService.moveGameInList(list_id, body.getSourceIndex(), body.getTargetIndex());
        return ResponseEntity.ok().build();
    }
}
