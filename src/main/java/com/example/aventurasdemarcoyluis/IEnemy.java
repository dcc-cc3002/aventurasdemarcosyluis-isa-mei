package com.example.aventurasdemarcoyluis;

public interface IEnemy extends ICharacter{

    /**
     * The enemy attack a player, so receives damage
     * @param player player to attack
     */
    void attack(IPlayer player);
}
