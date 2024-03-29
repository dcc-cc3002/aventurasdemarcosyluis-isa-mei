package com.example.aventurasdemarcoyluis.model.item;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to implement the share trunk that uses the Players to keep hte objets
 */
public class Baul {
    private final List<IItem> inventory;

    /**
     * Constructor to create a new Baul
     */
    public Baul(){
        inventory = new ArrayList<>();
    }

    /**
     * The item is added in the Players' inventory
     * @param anItem item to add
     */
    public void addItem(IItem anItem){
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

    public List<IItem> getInventory() { return inventory; }
}
