package com.example.aventurasdemarcoyluis.characters.enemies;

import com.example.aventurasdemarcoyluis.characters.players.AttackedByGoombaandSpiny;
import com.example.aventurasdemarcoyluis.characters.players.IPlayer;
import org.jetbrains.annotations.NotNull;

/**
 * Subclass of AbstractEnemies. Represents a Spiny in the game
 */
public class Spiny extends AbstractEnemies implements AttackedByPlayers, GoombaAndSpiny {
    /**
     * Creates a new Spiny Enemy
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     */
    public Spiny(int ATK, int DEF, int HP, int LVL) {
        super(ATK, DEF, HP, LVL);
    }

    /**
     * The Player attack with jump, but Spiny don´t receive damage and
     * hurt the player
     * @param player a Player
     */
    @Override
    public void attackedByPlayerJump(@NotNull IPlayer player) {
        player.jump(this);
        receiveDamage(0);
        player.receiveDamage((int) (0.05* player.getHp()));
    }

    /**
     * Receives the attack hammer made by any Player
     * @param player a player
     */
    @Override
    public void attackedByPlayerHammer(@NotNull IPlayer player) {
        receiveDamage(player.hammer(this));
    }

    /**
     * The enemy(Goomba or Spiny) attack a player, so receives damage
     * Is an overloaded method
     *
     * @param player player to attack
     */
    @Override
    public void attackTo(@NotNull AttackedByGoombaandSpiny player) {
        player.attackedByEnemy(this);
    }
}
