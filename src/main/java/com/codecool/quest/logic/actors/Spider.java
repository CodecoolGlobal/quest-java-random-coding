package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class Spider extends Actor {
    public Spider(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "spider";
    }

}
