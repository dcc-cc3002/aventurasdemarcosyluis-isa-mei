package com.example.aventurasdemarcoyluis;

/**
 * Subclass of AbstractEnemies. Represents a Goomba in the game
 */
public class Goomba extends AbstractEnemies{
    /**
     * Creates a new Goomba Enemy
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     */
    public Goomba(int ATK, int DEF, int HP, int LVL) {
        super(ATK, DEF, HP, LVL);
    }

}
