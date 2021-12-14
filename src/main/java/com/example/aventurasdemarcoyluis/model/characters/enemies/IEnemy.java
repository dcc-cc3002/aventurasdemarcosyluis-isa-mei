package com.example.aventurasdemarcoyluis.model.characters.enemies;

import com.example.aventurasdemarcoyluis.model.characters.ICharacter;
import com.example.aventurasdemarcoyluis.model.characters.players.IPlayer;

/**
 * Interface that implements attack for the Players
 */
public interface IEnemy extends ICharacter {

    /**
     * Calculate the damage that the enemy inflicts to the player
     * If enemy is KO it cannot attack, so player receive 0 damage
     * @param player player to attack
     * @return the damage calculated
     */
    int attack(IPlayer player);

}
