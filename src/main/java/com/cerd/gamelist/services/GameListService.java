package com.cerd.gamelist.services;

import com.cerd.gamelist.dto.GameListDTO;
import com.cerd.gamelist.entities.GameList;
import com.cerd.gamelist.projections.GameMinProjection;
import com.cerd.gamelist.repositories.GameListRepository;
import com.cerd.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService
{
    @Autowired
    public GameListRepository gameListRepository;

    @Autowired
    public GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll()
    {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex)
    {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++)
        {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
