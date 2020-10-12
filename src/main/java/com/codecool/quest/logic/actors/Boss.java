package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class Boss extends Actor {
    public Boss(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "boss";
    }
}
