package com.cerd.gamelist.services;

import com.cerd.gamelist.dto.GameMinDTO;
import com.cerd.gamelist.entities.Game;
import com.cerd.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService
{
    @Autowired
    public GameRepository gameRepository;

    public List<GameMinDTO> findAll()
    {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
