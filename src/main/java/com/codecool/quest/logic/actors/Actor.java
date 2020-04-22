package com.codecool.quest.logic.actors;

import com.codecool.quest.Main;
import com.codecool.quest.logic.*;

import static com.codecool.quest.logic.Inventory.inventoryList;

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

        if (nextCell.getTileName().equals("closed_door") && inventoryList.contains("key")) {
            nextCell.setType(CellType.OPEN);
        }

    }


    public int getHealth() {
        return health;
    }
}
