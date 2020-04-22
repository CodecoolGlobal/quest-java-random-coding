package com.codecool.quest.logic;


import com.codecool.quest.inventoryui.InventoryUI;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<String> inventoryList = new ArrayList<>();
    private InventoryUI inventoryUI;

    public List<String> getInventoryList() {
        return inventoryList;
    }

    public void addItem(String inventoryItem) {
        inventoryList.add(inventoryItem);
        inventoryUI.draw(this);
    }

    public void removeItem(String inventoryItem){
        inventoryList.remove(inventoryItem);
        inventoryUI.draw(this);
    }

    public void setUI(InventoryUI inventoryui){
        this.inventoryUI = inventoryui;
    }
}
