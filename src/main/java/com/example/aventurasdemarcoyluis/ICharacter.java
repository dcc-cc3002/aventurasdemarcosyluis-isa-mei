package com.example.aventurasdemarcoyluis;

/**
 * Interface that implements damage, receiveDamage and getDfs
 * for Players class and AbstractEnemyClass
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
}
