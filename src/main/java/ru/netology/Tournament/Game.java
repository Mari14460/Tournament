package ru.netology.Tournament;

import java.util.ArrayList;

public class Game {

    protected ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String name1, String name2) {
        Player player1 = findByName(name1);
        Player player2 = findByName(name2);
        if (player1 == null) {
            throw new NotFoundException("Player with name =" + name1 + " doesn't exist");
        }
        if (player2 == null) {
            throw new NotFoundException("Player with name =" + name2 + " doesn't exist");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}
