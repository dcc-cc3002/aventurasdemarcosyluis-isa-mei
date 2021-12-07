package com.example.aventurasdemarcoyluis.items;

import com.example.aventurasdemarcoyluis.characters.players.IPlayer;

/**
 * Interface for the item, each one has to implement it
 */
public interface IItem {

    /**
     * Implements the purpose of an item that a player
     * is going to use
     * @param player the one that uses an item
     */
    void usage(IPlayer player);
}
