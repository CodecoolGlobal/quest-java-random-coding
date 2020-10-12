package com.codecool.quest.logic.actors;

import com.codecool.quest.Main;
import com.codecool.quest.logic.Cell;

public class Player extends Actor {
    public Player(Cell cell) {

        super(cell);
    }



    public String getTileName() {
        if (Main.inventory.getInventoryList().contains("rod")) {
            return "mage";
        } else if (Main.inventory.getInventoryList().contains("sword")) {
            return "warrior";
        } else {
            return "player";
        }
    }
}
