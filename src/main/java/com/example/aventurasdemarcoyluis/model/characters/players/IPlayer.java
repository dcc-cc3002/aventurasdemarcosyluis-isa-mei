package com.example.aventurasdemarcoyluis.model.characters.players;

import com.example.aventurasdemarcoyluis.model.characters.ICharacter;
import com.example.aventurasdemarcoyluis.model.characters.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.model.item.Baul;
import com.example.aventurasdemarcoyluis.model.item.IItem;

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

    /**
     * Gives the value of the fight points
     * @return fp
     */
    int getFp();

    /**
     * Modify the value of Fp making sure to stay in the valid values
     * @param newFp new fight points
     */
    void changeFp(int newFp);

    /**
     * The Player makes use of an item, so its remove from the inventory
     * @param baul share trunk that contains the item for the PLayer
     * @param item object that the Player is using
     */
    void useItem(Baul baul, IItem item);

    /**
     * The Player went up a level, so its stats changes.
     */
    void levelUp();
}
