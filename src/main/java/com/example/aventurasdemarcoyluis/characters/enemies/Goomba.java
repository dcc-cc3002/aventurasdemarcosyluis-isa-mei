package com.example.aventurasdemarcoyluis.characters.enemies;

import com.example.aventurasdemarcoyluis.characters.players.IPlayer;

/**
 * Subclass of AbstractEnemies. Represents a Goomba in the game
 */
public class Goomba extends AbstractEnemies implements AttackedByPlayers {
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

    @Override
    public void attackedByPlayerJump(IPlayer player) {
        receiveDamage(player.jump(this));
    }

    @Override
    public void attackedByPlayerHammer(IPlayer player) {
        receiveDamage(player.hammer(this));
    }
}
