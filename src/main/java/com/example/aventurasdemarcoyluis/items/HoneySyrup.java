package com.example.aventurasdemarcoyluis.items;

import com.example.aventurasdemarcoyluis.characters.players.IPlayer;

/**
 * Class for the object Honey Syrup
 */
public class HoneySyrup implements IItem {

    /**
     * Creates a HoneySyrup
     */
    public HoneySyrup() {
    }


    /**
     * Restore 3 Fp of the player
     * @param player the one that uses an item
     */
    @Override
    public void usage(IPlayer player) {
        int newFp = player.getFp() + 3;
        player.changeFp(newFp);
    }
}
