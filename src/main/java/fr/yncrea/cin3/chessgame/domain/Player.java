package fr.yncrea.cin3.chessgame.domain;

import java.util.List;
import java.util.UUID;

public class Player {
    private final UUID id;
    private String name;
    private String pp;
    private int elo;
    private int win;
    private int lose;
    private List<Player> friends;


    public Player(UUID id, String name, String pp, int elo, int win, int lose, List<Player> friends) {
        this.id = id;
        this.name = name;
        this.pp = pp;
        this.elo = elo;
        this.win = win;
        this.lose = lose;
        this.friends = friends;
    }


    public List<Player> getFriends() {
        return friends;
    }

    public void setFriends(List<Player> friends) {
        this.friends = friends;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
}
