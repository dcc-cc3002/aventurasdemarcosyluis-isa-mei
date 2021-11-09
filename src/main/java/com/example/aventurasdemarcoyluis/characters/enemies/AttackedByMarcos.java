package com.example.aventurasdemarcoyluis.characters.enemies;

import com.example.aventurasdemarcoyluis.characters.players.Marcos;

/**
 * Interface that implements attackedByMarcosJump and attackedByMarcosHammer
 * for Boo
 */
public interface AttackedByMarcos{

    /**
     * To use double dispatch when Marcos attack boo with jump
     * @param marcos a marcos
     */
    void attackedByMarcosJump(Marcos marcos);

    /**
     * To use double dispatch when Marcos attack boo with the hammer
     * @param marcos a marcos
     */
    void attackedByMarcosHammer(Marcos marcos);
}
