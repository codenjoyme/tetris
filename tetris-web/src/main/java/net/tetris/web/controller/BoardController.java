package net.tetris.web.controller;

import net.tetris.services.Player;
import net.tetris.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class BoardController {
    public static final ArrayList<Object> EMPTY_LIST = new ArrayList<>();
    @Autowired
    private PlayerService playerService;

    public BoardController() {
    }

    //for unit test
    BoardController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/board/{playerName}",method = RequestMethod.GET)
    public String board(ModelMap model, @PathVariable("playerName") String playerName) {
        Player player = playerService.findPlayer(playerName);
        if (player == null) {
            model.addAttribute("players", EMPTY_LIST);
        }else{
            model.addAttribute("players", Collections.singletonList(player));
        }
        model.addAttribute("allPlayersScreen", false);
        return "board";
    }

    @RequestMapping(value = "/board",method = RequestMethod.GET)
    public String boardAll(ModelMap model) {
        model.addAttribute("players", playerService.getPlayers());
        model.addAttribute("allPlayersScreen", true);
        return "board";
    }

    @RequestMapping(value = "/leaderboard",method = RequestMethod.GET)
    public String leaderBoard() {
        return "leaderboard";
    }

    @RequestMapping(value = "/help")
    public String help() {
        return "help";
    }
}
