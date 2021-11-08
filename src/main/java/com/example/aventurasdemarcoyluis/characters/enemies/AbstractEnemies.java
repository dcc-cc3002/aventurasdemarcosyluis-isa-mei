package com.example.aventurasdemarcoyluis.characters.enemies;

import com.example.aventurasdemarcoyluis.characters.AbstractCharacter;
import com.example.aventurasdemarcoyluis.characters.players.IPlayer;

/**
 * Abstract class for the Enemies in the game
 */
public abstract class AbstractEnemies
        extends AbstractCharacter implements IEnemy {

    /**
     * Creates a new Enemy
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     *
     */
    public AbstractEnemies(int ATK, int DEF, int HP, int LVL){
        super(ATK, DEF, HP, LVL);
    }


    @Override
    public void attack(IPlayer player) {
        if (this.isKO()) {
            player.receiveDamage(0);
        }
        else{
            double k = 0.75;
            player.receiveDamage(damage(player, k));
        }
    }
}
