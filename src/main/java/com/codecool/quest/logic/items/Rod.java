package com.codecool.quest.logic.items;
import com.codecool.quest.logic.Cell;

public class Rod extends Item {
    public Rod(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "rod";
    }
}
