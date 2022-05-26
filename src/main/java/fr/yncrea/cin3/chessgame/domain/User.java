package fr.yncrea.cin3.chessgame.domain;

import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;
    private String name;
    private String password;
    private final String email;
    private String pp;
    private int elo;
    private int win;
    private int lose;
    private List<User> friends;


    public User(UUID id, String name, String password, String email, String pp, int elo,
                int win, int lose, List<User> friends) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.pp = pp;
        this.elo = elo;
        this.win = win;
        this.lose = lose;
        this.friends = friends;
    }


    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
