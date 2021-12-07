package com.example.aventurasdemarcoyluis.characters.enemies;

import com.example.aventurasdemarcoyluis.characters.ICharacter;
import com.example.aventurasdemarcoyluis.characters.players.IPlayer;

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
