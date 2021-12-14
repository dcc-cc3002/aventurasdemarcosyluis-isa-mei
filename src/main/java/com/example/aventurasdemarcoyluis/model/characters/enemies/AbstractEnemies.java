package com.example.aventurasdemarcoyluis.model.characters.enemies;

import com.example.aventurasdemarcoyluis.model.characters.AbstractCharacter;
import com.example.aventurasdemarcoyluis.model.characters.players.IPlayer;

/**
 * Subclass of AbstractCharacter. Abstract class for the Enemies in the game
 *
 * @author Isabella Meirone
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
    public int attack(IPlayer player) {
        if (this.isKO()) {
            return 0;
        }
        else{
            double k = 0.75;
            return damage(player, k);
        }
    }

}
