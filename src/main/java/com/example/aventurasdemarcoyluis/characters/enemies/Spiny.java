package com.example.aventurasdemarcoyluis.characters.enemies;

import com.example.aventurasdemarcoyluis.characters.players.IPlayer;

/**
 * Subclass of AbstractEnemies. Represents a Spiny in the game
 */
public class Spiny extends AbstractEnemies implements AttackedByPlayers {
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

    @Override
    public void attackedByPlayerJump(IPlayer player) {
        receiveDamage(0);
        player.receiveDamage((int) (0.05* player.getHp()));
    }

    @Override
    public void attackedByPlayerHammer(IPlayer player) {
        receiveDamage(player.hammer(this));
    }
}
