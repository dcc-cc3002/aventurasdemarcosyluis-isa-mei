package com.example.aventurasdemarcoyluis.characters.players;

import com.example.aventurasdemarcoyluis.characters.enemies.IEnemy;

/**
 * Interface that implements attackedByEnemy for the AbstractPlayer.
 */
public interface AttackedByEnemy {

    /**
     * To use Double dispatch when a Player is attacked by an enemy
     * @param enemy enemy to attack
     */
    void attackedByEnemy(IEnemy enemy);
}
