package com.example.aventurasdemarcoyluis.model.characters.players;

import com.example.aventurasdemarcoyluis.model.characters.enemies.Boo;
import org.jetbrains.annotations.NotNull;

/**
 * Subclass of AbstractPlayers. Class that represent Marcos
 */
public class Marcos extends AbstractPlayers {
    /**
     * Creates a new Marcos Player
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param FP  fight points
     * @param LVL level of the Unit
     */
    public Marcos(int ATK, int DEF, int HP, int FP, int LVL) {
        super(ATK, DEF, HP, FP, LVL);
    }

    /**
     * Use double dispatch to attack a Boo with jump
     * Is an overload method
     * @param boo a boo
     */
    public void attackJump(@NotNull Boo boo){
        boo.attackedByMarcosJump(this);
    }

    /**
     * Use double dispatch to attack a Boo with the hammer
     * Is an overload method
     * @param boo a boo
     */
    public void attackHammer(@NotNull Boo boo){
        boo.attackedByMarcosHammer(this);
    }

    @Override
    public String toString() {
        return "Marcos";
    }
}
