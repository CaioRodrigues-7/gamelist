package com.cerd.gamelist.services;

import com.cerd.gamelist.dto.GameDTO;
import com.cerd.gamelist.dto.GameMinDTO;
import com.cerd.gamelist.entities.Game;
import com.cerd.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService
{
    @Autowired
    public GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id)
    {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll()
    {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
