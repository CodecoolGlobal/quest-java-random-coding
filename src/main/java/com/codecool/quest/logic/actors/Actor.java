package com.codecool.quest.logic.actors;

import com.codecool.quest.Main;
import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Drawable;
import com.codecool.quest.logic.AbstractDrawable;
import com.codecool.quest.logic.items.Item;
import com.codecool.quest.logic.items.Sword;

public abstract class Actor extends AbstractDrawable {
    private int health = 10;

    public Actor(Cell cell) {
        super(cell);
    }


    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (!nextCell.getTileName().equals("wall") && !(nextCell.getOccupant() instanceof Actor) && !nextCell.getTileName().equals("closed_door")) {
            cell.setOccupant(null);
            nextCell.setOccupant(this);
            cell = nextCell;
            if (cell.getItem() != null) {
                Main.showPickUpButton();

            } else {
                Main.hidePickUpButton();
            }


        }

    }


    public int getHealth() {
        return health;
    }
}
