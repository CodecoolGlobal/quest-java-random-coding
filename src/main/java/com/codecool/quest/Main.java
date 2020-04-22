package com.codecool.quest;
import com.codecool.quest.inventoryui.*;
import com.codecool.quest.logic.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    GameMap map = MapLoader.loadMap();
    Canvas canvas = new Canvas(
            map.getWidth() * Tiles.TILE_WIDTH,
            map.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Label inventoryLabel = new Label();
    static Button button = new Button("Pick up");
    public static Inventory inventory = new Inventory();
    private InventoryUI inventoryui = new InventoryUI();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane rightPanel = new GridPane();
        GridPane inventoryPanel = new GridPane();
        rightPanel.setPrefWidth(200);
        rightPanel.setPadding(new Insets(10));
        Label label = new Label();
        GridPane.setConstraints(label, 10, 20);
        inventoryui.setInventoryUI(inventoryPanel);
        inventory.setUI(inventoryui);
        rightPanel.add(inventoryPanel, 10,0);
        rightPanel.add(new Label("Health: "), 0, 0);
        rightPanel.add(healthLabel, 1, 0);

        rightPanel.add(new Label("Inventory: "), 0, 1);
        rightPanel.add(inventoryLabel, 1, 0);
        Canvas inventoryCanvas = new Canvas(
                Tiles.TILE_WIDTH,
                Tiles.TILE_WIDTH);
        rightPanel.add(inventoryCanvas, 0, 0);

        rightPanel.add(button, 6, 10);
        button.setVisible(false);



        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(canvas);
        borderPane.setRight(rightPanel);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        refresh();
        button.setOnAction(actionEvent -> {
            inventory.addItem(map.getPlayer().getCell().getItem().getTileName());
            map.getPlayer().getCell().setItem(null);
            borderPane.requestFocus();
        });
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Codecool Quest");
        primaryStage.show();
        borderPane.requestFocus();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                map.getPlayer().move(0, -1);
                refresh();
                break;
            case DOWN:
                map.getPlayer().move(0, 1);
                refresh();
                break;
            case LEFT:
                map.getPlayer().move(-1, 0);
                refresh();
                break;
            case RIGHT:
                map.getPlayer().move(1,0);
                refresh();
                break;
        }
    }

    public  static void showPickUpButton(){
        button.setVisible(true);
    }

    public  static void hidePickUpButton(){
        button.setVisible(false);
    }


    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getOccupant() != null) {
                    Tiles.drawTile(context, cell.getOccupant(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        healthLabel.setText("" + map.getPlayer().getHealth());

    }

}

