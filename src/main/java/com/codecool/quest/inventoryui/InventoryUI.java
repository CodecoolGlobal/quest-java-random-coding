package com.codecool.quest.inventoryui;

import com.codecool.quest.Tiles;
import com.codecool.quest.logic.Inventory;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;

public class InventoryUI {
    private GridPane gridPane;

    public void setInventoryUI(GridPane gridPane){
        this.gridPane = gridPane;
    }

    private Node createCanvas(String item) {
        Canvas inventoryCanvas = new Canvas(
                Tiles.TILE_WIDTH,
                Tiles.TILE_WIDTH);
        Tiles.drawTile(inventoryCanvas.getGraphicsContext2D(), () -> item, 0, 0);
        return inventoryCanvas;
    }

    public void draw(Inventory inventory){
        gridPane.getChildren().clear();
        int colNum = 0;
        int rowNum = 0;
        for (String item : inventory.getInventoryList()) {
            gridPane.add(createCanvas(item), colNum, rowNum);
            rowNum++;
        }
    }

}
