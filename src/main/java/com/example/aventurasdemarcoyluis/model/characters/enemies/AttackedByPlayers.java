package com.example.aventurasdemarcoyluis.model.characters.enemies;

import com.example.aventurasdemarcoyluis.model.characters.players.IPlayer;

/**
 * Interface that implements attackedByPlayerJump and attackedByPlayerHammer
 * for Goomba and Spiny
 */
public interface AttackedByPlayers{

    /**
     * To use double dispatch when a Player attack an enemy whit a jump
     * @param player a Player
     */
    void attackedByPlayerJump(IPlayer player);

    /**
     * To use double dispatch when a Player attack an enemy whit the hammer
     * @param player a player
     */
    void attackedByPlayerHammer(IPlayer player);

}
