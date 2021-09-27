package com.example.aventurasdemarcoyluis;

/**
 * Subclass of AbstractEnemies. Represents a Spiny in the game
 */
public class Spiny extends AbstractEnemies{
    /**
     * Creates a new Enemy
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     */
    public Spiny(int ATK, int DEF, int HP, int LVL) {
        super(ATK, DEF, HP, LVL);
    }

}
