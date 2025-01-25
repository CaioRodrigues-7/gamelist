package com.cerd.gamelist.controllers;

import com.cerd.gamelist.dto.GameMinDTO;
import com.cerd.gamelist.entities.Game;
import com.cerd.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ClientInfoStatus;
import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController
{
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll()
    {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
