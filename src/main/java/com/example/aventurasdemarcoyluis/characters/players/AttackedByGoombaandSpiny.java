package com.example.aventurasdemarcoyluis.characters.players;

import com.example.aventurasdemarcoyluis.characters.enemies.GoombaAndSpiny;

/**
 * Interface that implements attackedByenemy for the Players.
 * Allow the attack by Goomba or Spiny.
 */
public interface AttackedByGoombaandSpiny {

    /**
     * To use Double dispatch when a Player is attacked by an enemy(Goomba or Spiny)
     * @param enemy enemy attacking
     */
    void attackedByEnemy(GoombaAndSpiny enemy);
}
