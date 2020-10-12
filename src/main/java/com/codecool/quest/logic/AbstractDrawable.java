package com.codecool.quest.logic;

public abstract class AbstractDrawable implements Drawable {
    protected Cell cell;

    public AbstractDrawable(Cell cell) {
        this.cell = cell;
        cell.setOccupant(this);
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
