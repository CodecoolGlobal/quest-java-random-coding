package com.codecool.quest.logic;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    DOOR("closed_door"),
    OPEN("open_door"),
    TREE("tree"),
    FOOD("apple"),
    RIVER("river"),
    SKULL("skull"),
    WEB("web"),
    TURN("turn"),
    CIRCLE("circle");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
