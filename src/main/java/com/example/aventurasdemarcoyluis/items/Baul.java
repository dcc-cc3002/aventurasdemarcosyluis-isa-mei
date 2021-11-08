package com.example.aventurasdemarcoyluis.items;

import java.util.ArrayList;
import java.util.List;

public class Baul {
    private final List<IItem> inventory;

    public Baul(){
        inventory = new ArrayList<>();
    }

    /**
     * The item is added in the Players' inventory
     * @param anItem item to add
     */
    protected void addItem(IItem anItem){
        inventory.add(anItem);
    }

    /**
     * Verify that the item is in the inventory
     * @param anItem item for ask
     * @return true if it is, false if it isn't
     */
    public boolean askForItem(IItem anItem) {return inventory.contains(anItem);}

    /**
     * Delete the item form the inventory
     * @param anItem item to delete
     */
    public void removeItem(IItem anItem) { inventory.remove(anItem); }
}
