package com.example.aventurasdemarcoyluis.characters.players;

import com.example.aventurasdemarcoyluis.characters.enemies.Boo;
import org.jetbrains.annotations.NotNull;

public class Marcos extends AbstractPlayers {
    /**
     * Creates a new player
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

    public void attackJump(@NotNull Boo boo){
        boo.attackedByMarcosJump(this);
    }

    public void attackHammer(@NotNull Boo boo){
        boo.attackedByMarcosHammer(this);
    }
}
