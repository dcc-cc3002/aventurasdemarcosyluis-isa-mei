package com.example.aventurasdemarcoyluis.characters.enemies;

import com.example.aventurasdemarcoyluis.characters.ICharacter;
import com.example.aventurasdemarcoyluis.characters.players.IPlayer;

/**
 * Interface that implements attack for AbstractEnemy
 */
public interface IEnemy extends ICharacter {

    /**
     * The enemy attack a player, so receives damage
     * @param player player to attack
     */
    void attack(IPlayer player);
}
