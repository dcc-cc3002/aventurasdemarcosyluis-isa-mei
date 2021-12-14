package com.example.aventurasdemarcoyluis.model.characters.enemies;

import com.example.aventurasdemarcoyluis.model.characters.players.AttackedByGoombaandSpiny;

/**
 * Interface for Goomba and Spiny that allow attack Marcos and Luis
 * implements attackTo method
 */

public interface GoombaAndSpiny extends IEnemy{

    /**
     * The enemy(Goomba or Spiny) attack a player, so receives damage
     * Is an overloaded method
     * @param player player to attack
     */
    void attackTo(AttackedByGoombaandSpiny player);
}
