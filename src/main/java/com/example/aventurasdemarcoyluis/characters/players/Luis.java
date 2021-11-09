package com.example.aventurasdemarcoyluis.characters.players;

import com.example.aventurasdemarcoyluis.characters.enemies.Boo;
import org.jetbrains.annotations.NotNull;

/**
 * Subclass of AbstractPlayers. Class that represent Luis
 */
public class Luis extends AbstractPlayers implements AttackedByBoo {

    /**
     * Creates a new Luis Player
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param FP  fight points
     * @param LVL level of the Unit
     */
    public Luis(int ATK, int DEF, int HP, int FP, int LVL) {
        super(ATK, DEF, HP, FP, LVL);
    }

    /**
     * Luis is attacked by a Boo
     * @param boo a boo
     */
    @Override
    public void attackedByBoo(@NotNull Boo boo) {
        receiveDamage(boo.attack(this));
    }
}
