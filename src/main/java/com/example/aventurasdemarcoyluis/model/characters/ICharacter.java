package com.example.aventurasdemarcoyluis.model.characters;

/**
 * Interface that implements damage, receiveDamage, getDfs and getHp
 * for AbstractCharacter.
 */
public interface ICharacter {
    /**
     * Calculate the damage that the character A gives to the
     * character B by attacking it
     * @param character attacked
     * @param k parameter that depend on the attack
     * @return damage calculated
     */
    int damage(ICharacter character, double k);

    /**
     * Apply the damage received in the hp of the character
     * @param damage calculated value
     */
    void receiveDamage(int damage);

    /**
     * Gives the character's defense
     * @return def
     */
    int getDef();

    /**
     * Gives the Character's heal points
     * @return hp
     */
    int getHp();

    /**
     * Gives the maximum value of heal points
     * @return maxHp
     */
    int getMaxHp();

    /**
     * Modify the value of Hp making sure to stay in between the valid values
     * If heal points are 0 then the Character's status is changed
     * @param newHp new heal points
     */
    void changeHp(int newHp);

    /**
     * Indicates if the character is dead or alive by giving a boolean valor
     * @return true if the player is dead, false if it isn't
     */
    boolean isKO();

    /**
     * Gives the Character's level
     * @return lvl
     */
    int getLvl();
}
