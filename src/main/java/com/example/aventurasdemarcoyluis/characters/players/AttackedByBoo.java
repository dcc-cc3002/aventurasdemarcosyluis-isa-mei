package com.example.aventurasdemarcoyluis.characters.players;

import com.example.aventurasdemarcoyluis.characters.enemies.Boo;

/**
 * Interface that implements attackedByBoo for Luis class.
 */
public interface AttackedByBoo {

    /**
     * To use Double dispatch when Luis is attacked by Boo
     * @param boo a boo
     */
    void attackedByBoo(Boo boo);

}
