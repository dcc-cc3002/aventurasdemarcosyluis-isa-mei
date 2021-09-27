package com.example.aventurasdemarcoyluis;

/**
 * Class for the object Star
 */
public class Star implements IItem{

    /**
     * Creates a Star
     */
    public Star() {
    }

    /**
     * Make the player invincible
     * @param player the one that uses an item
     */
    @Override
    public void usage(Players player) {
        System.out.println("I'm invincible je je je");
    }
}
