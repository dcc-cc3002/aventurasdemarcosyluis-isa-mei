package com.example.aventurasdemarcoyluis.characters.players;

import com.example.aventurasdemarcoyluis.characters.ICharacter;
import com.example.aventurasdemarcoyluis.characters.enemies.IEnemy;

/**
 * Interface that implements jump and hammer for AbstractPlayer
 */
public interface IPlayer extends ICharacter {

    /**
     * Gives the value of the damage made by attacking with jump
     * @param enemy enemy to attack
     * @return damage by jump
     */
    int jump(IEnemy enemy);

    /**
     * Gives the value of the damage made by attacking with hammer
     * @param enemy enemy to attack
     * @return damage by hammer
     */
    int hammer(IEnemy enemy);

}
