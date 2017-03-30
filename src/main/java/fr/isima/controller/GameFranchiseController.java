package fr.isima.controller;

import fr.isima.model.Game;
import fr.isima.model.GameFranchise;
import fr.isima.service.GameFranchiseService;
import fr.isima.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
public class GameFranchiseController {
    @Autowired
    private GameFranchiseService gameFranchiseService;

    @Autowired
    private GameService gameService;

    @RequestMapping(value="/gameFranchises")
    public Set<GameFranchise> getAll() {
        return gameFranchiseService.findAll();
    }

    @RequestMapping(value="/gameFranchises/{id}")
    public GameFranchise getById(@PathVariable long id) {
        return gameFranchiseService.findById(id);
    }

    @RequestMapping(value="/gameFranchises", method = RequestMethod.POST)
    public GameFranchise save(@RequestBody GameFranchise gameFranchise) {
        return gameFranchiseService.save(gameFranchise);
    }

    @RequestMapping(value="/gameFranchises/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        gameFranchiseService.deleteById(id);
    }

    @RequestMapping(value="/gameFranchises/{id}/games", method = RequestMethod.POST)
    public GameFranchise addGame(@PathVariable long id, @RequestBody Map<String, Long> json) {
        GameFranchise gameFranchise =  gameFranchiseService.findById(id);
        Game game = gameService.findById(json.get("id"));
        gameFranchise.getGames().add(game);
        gameFranchiseService.save(gameFranchise);
        return gameFranchise;
    }
}
