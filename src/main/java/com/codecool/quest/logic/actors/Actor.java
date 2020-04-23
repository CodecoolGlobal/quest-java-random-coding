package com.codecool.quest.logic.actors;

import com.codecool.quest.Main;
import com.codecool.quest.logic.*;

public abstract class Actor extends AbstractDrawable {
    private int health = 10;
    private int strikeForce = 5;



    public Actor(Cell cell) {
        super(cell);
        cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.hasActor()) {
            Actor enemy = nextCell.getActor();
            enemy.changeHealth(this.strikeForce);
            System.out.println(enemy.getHealth());
            if (enemy.getHealth() <= 0) {
                nextCell.setActor(null);
            }
            if (enemy.getHealth() > 0){
              health-=2;
            }
        }
        if (nextCell.getTileName().equals("apple")){
            health+=5;
        }

        if (Main.inventory.getInventoryList().contains("sword")){
            strikeForce = 8;

        }
        if ((nextCell.getTileName().equals("floor")) && !(nextCell.hasActor()) || nextCell.getTileName().equals("open_door") || nextCell.getTileName().equals("apple")) {
            if (cell.getTileName().equals("apple")){
                cell.setType(CellType.FLOOR);
            }
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
            if (cell.getItem() != null) {
                Main.showPickUpButton();
            } else {
                Main.hidePickUpButton();
            }
        }

        if (nextCell.getTileName().equals("closed_door") && Main.inventory.getInventoryList().contains("key")) {
            nextCell.setType(CellType.OPEN);
            Main.inventory.removeItem("key");
        }



    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void changeHealth(int numberToDeduct) {
        health -= numberToDeduct;
    }
}
