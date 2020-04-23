package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class Goblin extends Actor {
    public Goblin(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "goblin";
    }
}
