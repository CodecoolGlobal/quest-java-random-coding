package com.codecool.quest.logic;

import com.codecool.quest.Tiles;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public static List<String> inventoryList = new ArrayList<>();

    public Node createCanvas(String item) {
        Canvas inventoryCanvas = new Canvas(
                Tiles.TILE_WIDTH,
                Tiles.TILE_WIDTH);
        Tiles.drawTile(inventoryCanvas.getGraphicsContext2D(), () -> item, 0, 0);
        return inventoryCanvas;
    }

    public List<String> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(String inventoryItem) {
        inventoryList.add(inventoryItem);
    }
}
