package com.example.aventurasdemarcoyluis;

public interface IItem {

    /**
     * Implements the purpose of an item that a player
     * is going to use
     * @param player the one that uses an item
     */
    void usage(Players player);
}
