package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.Actor;
import com.codecool.quest.logic.items.Item;

public class Cell implements Drawable {
    private CellType type;
    private Item item;
    private Drawable occupant;
    private GameMap gameMap;
    private int x, y;

    Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setOccupant(Drawable occupant) {
        this.occupant = occupant;
    }
    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
    public Drawable getOccupant() {
        return occupant;
    }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
