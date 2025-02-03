package com.cerd.gamelist.controllers;

import com.cerd.gamelist.dto.GameListDTO;
import com.cerd.gamelist.dto.GameMinDTO;
import com.cerd.gamelist.dto.ReplacementDTO;
import com.cerd.gamelist.services.GameListService;
import com.cerd.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
public class GameListController
{
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll()
    {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId)
    {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body)
    {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
