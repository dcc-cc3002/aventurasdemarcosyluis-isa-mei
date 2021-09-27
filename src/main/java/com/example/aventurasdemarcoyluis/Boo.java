package com.example.aventurasdemarcoyluis;

/**
 * Subclass of AbstractEnemies. Represents a Boo in the game
 */
public class Boo extends AbstractEnemies{
    /**
     * Creates a new Boo Enemy
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     */
    public Boo(int ATK, int DEF, int HP, int LVL) {
        super(ATK, DEF, HP, LVL);
    }

}
