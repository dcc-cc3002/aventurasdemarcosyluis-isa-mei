package com.example.aventurasdemarcoyluis;

public interface IPlayer extends ICharacter{

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
