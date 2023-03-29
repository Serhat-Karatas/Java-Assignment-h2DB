package com.task.imona.controller;

import com.task.imona.entity.Player;
import com.task.imona.entity.PlayerAction;
import com.task.imona.repository.ActionRepository;
import com.task.imona.repository.PlayerActionRepository;
import com.task.imona.repository.PlayerRepository;
import com.task.imona.service.GameService;
import com.task.imona.service.PlayerService;
import com.task.imona.service.RelationshipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;



@Controller
public class PlayerController {

    private final PlayerService playerService;

    private final PlayerActionRepository playerActionRepository;

    private final PlayerRepository playerRepository;

    private final ActionRepository actionRepository;

    private final GameService gameService;

    private final  RelationshipService relationService;

    public PlayerController(PlayerService playerService, PlayerActionRepository playerActionRepository, PlayerRepository playerRepository, ActionRepository actionRepository, GameService gameService, RelationshipService relationService) {
        super();
        this.playerService = playerService;
        this.playerActionRepository = playerActionRepository;
        this.playerRepository = playerRepository;
        this.actionRepository = actionRepository;
        this.gameService = gameService;
        this.relationService = relationService;
    }

    @GetMapping("/game")
    public String showGame(Model model){
        //Game game = gameService.getFirstObjectToAllList();
        //String logoBase64 = game.getLogoBase64();
       // model.addAttribute("game", game);
       // model.addAttribute("logoBase64", logoBase64);
        return "game";
    }

    @GetMapping("/{playerId}/actions")
    public String listActions(@PathVariable Long playerId,Model model) {
        model.addAttribute("actions", relationService.getAllActions());
        model.addAttribute("playerId",playerId);
        return "actions";
    }

    @PostMapping("/{playerId}/actions/{actionId}")
    public String addActToPlyr(@PathVariable Long playerId, @PathVariable Long actionId) {
        PlayerAction pa= new PlayerAction(playerId,actionId);
        playerActionRepository.save(pa);
        return "redirect:players";
    }


    // handler method to handle list players and return model and view
    @GetMapping("/players")
    public String listPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers() );
        return "players";
    }

    @GetMapping("/players/new")
    public String createPlayerForm(Model model) {
        // create player object to hold player form data

        Player player = new Player();
        model.addAttribute("player", player);
        //model.addAttribute("city", city)
        return "create_player";

    }

    @PostMapping("/players")
    public String savePlayer(@ModelAttribute("player") Player player){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        playerService.savePlayer(player);
        return "redirect:/players";
    }

    @GetMapping("/players/edit/{id}")
    public String editPlayerForm(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.getPlayerById(id));
        return "edit_player";
    }

    @PostMapping("/players/{id}")
    public String updatePlayer(@PathVariable Long id,
                                @ModelAttribute("Player") Player player,
                                Model model) {

        // get player from database by id
        Player existingPlayer = playerService.getPlayerById(id);
        existingPlayer.setId(id);
        existingPlayer.setName(player.getName());
        existingPlayer.setSurname(player.getSurname());
        existingPlayer.setGender(player.getGender());
        existingPlayer.setBirth_date(player.getBirth_date());
        existingPlayer.setCity(player.getCity());
        existingPlayer.setIs_active(player.getIs_active());

        // save updated player object
        playerService.updatePlayer(existingPlayer);
        return "redirect:/players";
    }

    // handler method to handle delete player request

    @GetMapping("/players/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deletePlayerById(id);
        return "redirect:/players";
    }











}
