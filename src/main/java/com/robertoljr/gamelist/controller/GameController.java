package com.robertoljr.gamelist.controller;

import com.robertoljr.gamelist.dto.GameSummaryDTO;
import com.robertoljr.gamelist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/games")
public class GameController {

    private GameService gameService;

    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping()
    public ResponseEntity<List<GameSummaryDTO>> findAll() {
        return  ResponseEntity.ok(gameService.findAll());
    }
}
