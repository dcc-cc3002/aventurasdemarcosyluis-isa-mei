package com.example.aventurasdemarcoyluis.characters.players;

import com.example.aventurasdemarcoyluis.characters.ICharacter;
import com.example.aventurasdemarcoyluis.characters.enemies.IEnemy;

public interface IPlayer extends ICharacter {

    /**
     * Attack an enemy doing a jump
     * @param enemy enemy to attack
     * @return
     */
    int jump(IEnemy enemy);

    /**
     * Attack an enemy with the hammer
     * @param enemy enemy to attack
     * @return
     */
    int hammer(IEnemy enemy);

}
