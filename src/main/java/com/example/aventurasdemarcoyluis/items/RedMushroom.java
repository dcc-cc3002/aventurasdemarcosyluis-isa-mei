package com.example.aventurasdemarcoyluis.items;

import com.example.aventurasdemarcoyluis.characters.players.IPlayer;

/**
 *  Class for the object Red mushroom
 */
public class RedMushroom implements IItem {

    /**
     * Creates a RedMushroom
     */
    public RedMushroom() {
    }

    /**
     * Heal the player 10% of the max Hp
     * @param player the one that uses an item
     */
    @Override
    public void usage(IPlayer player) {
        int newHp = player.getHp() + player.getMaxHp()/10;
        player.changeHp(newHp);

    }
}
