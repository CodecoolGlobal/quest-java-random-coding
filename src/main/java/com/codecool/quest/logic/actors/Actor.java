package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Drawable;
import com.codecool.quest.logic.AbstractDrawable;

public abstract class Actor extends AbstractDrawable {
    private int health = 10;

    public Actor(Cell cell) {
        super(cell);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (!nextCell.getTileName().equals("wall")) {
            cell.setOccupant(null);
            nextCell.setOccupant(this);
            cell = nextCell;
        }
    }

    public int getHealth() {
        return health;
    }
}
