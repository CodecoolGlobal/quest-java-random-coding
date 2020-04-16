package com.codecool.quest.logic;

import com.codecool.quest.Tiles;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;

public class Inventory {

    public Node createCanvas(String item) {
        Canvas inventoryCanvas = new Canvas(
                Tiles.TILE_WIDTH,
                Tiles.TILE_WIDTH);
        Tiles.drawTile(inventoryCanvas.getGraphicsContext2D(), () -> item, 0, 0);
        return inventoryCanvas;
    }
}
