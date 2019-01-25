package com.cans.ponggame.api;

public class Game {
    private String name;

    Game()
    {
    }

    Game(int id, String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
