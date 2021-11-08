package com.example.aventurasdemarcoyluis.characters.enemies;

import com.example.aventurasdemarcoyluis.characters.players.Luis;
import com.example.aventurasdemarcoyluis.characters.players.Marcos;

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

    public void attack(Luis luis){
        super.attack(luis);
    }

    @Override
    public void attackedByMarcosJump(Marcos marcos) {
        receiveDamage(marcos.jump(this));
    }

    @Override
    public void attackedByMarcosHammer(Marcos marcos) {
        receiveDamage(0);
    }
}
