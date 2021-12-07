package com.example.aventurasdemarcoyluis.characters.enemies;

import com.example.aventurasdemarcoyluis.characters.players.Luis;
import com.example.aventurasdemarcoyluis.characters.players.Marcos;
import org.jetbrains.annotations.NotNull;

/**
 * Subclass of AbstractEnemies. Represents a Boo in the game
 */
public class Boo extends AbstractEnemies implements AttackedByMarcos {
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

    /**
     * Boo only attacks Luis.
     * Is an overloaded method
     * @param luis luis to attack
     */
    public void attackTo(@NotNull Luis luis){
        luis.attackedByBoo(this);
    }

    /**
     * Receives the attack jump made by Marcos
     * @param marcos a marcos
     */
    @Override
    public void attackedByMarcosJump(@NotNull Marcos marcos) {
        receiveDamage(marcos.jump(this));
    }

    /**
     * Marcos attack with a hammer, but Boo don´t receives damage
     * @param marcos a marcos
     */
    @Override
    public void attackedByMarcosHammer(@NotNull Marcos marcos) {
        marcos.hammer(this);
        receiveDamage(0);
    }
}
