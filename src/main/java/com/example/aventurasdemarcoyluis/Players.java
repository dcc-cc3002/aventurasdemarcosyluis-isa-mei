package com.example.aventurasdemarcoyluis;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represent a Player in the game
 *
 *  @author Isabella Meirone
 */
public class Players implements ICharacter{
    private int atk;
    private int def;
    private int hp;
    private int maxHp;
    private int fp;
    private int maxFp;
    private int lvl;
    private String status;
    private final List<IItem> inventory;

    /**
     * Creates a new player
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param FP  fight points
     * @param LVL level of the Unit
     *
     */
    public Players(int ATK, int DEF, int HP, int FP, int LVL){
        this.atk = ATK;
        this.def = DEF;
        this.hp = this.maxHp = HP;
        this.fp = this.maxFp = FP;
        this.lvl = LVL;
        this.inventory = new ArrayList<>();
        this.status = "alive";

    }

    /**
     * Gives the Players' attack
     * @return atk
     */
    private int getAtk() { return this.atk; }

    /**
     * Gives the value of heal points
     * @return hp
     */
    public int getHp(){
        return this.hp;
    }

    /**
     * Gives the maximum value of heal points
     * @return maxHp
     */
    public int getMaxHp(){
        return this.maxHp;
    }

    /**
     * Gives the value of the fight points
     * @return fp
     */
    public int getFp(){
        return this.fp;
    }

    /**
     * Gives the maximum value of fight points
     * @return maxFp
     */
    public int getMaxFp() { return this.maxFp; }

    /**
     * Gives the Players' level
     * @return lvl
     */
    public int getLvl() { return this.lvl; }

    /**
     * Gives the Players' status
     * @return status
     */
    private String getStatus() { return this.status; }

    /**
     * Modify the value of the Players' hp
     * @param hp new hp
     */
    private void setHp(int hp){
        this.hp = hp;
    }

    /**
     * Modify the value of the Players' fp
     * @param fp new fp
     */
    private void setFp(int fp){
        this.fp = fp;
    }

    /**
     * Modify the value of Hp making sure to stay in between the valid values
     * If heal points are 0 then the player's status is changed
     * @param hp new heal points
     */
    protected void changeHp(int hp) {
        int maxHp = this.getMaxHp();
        if(hp <= 0){
            this.setHp(0);
            this.dead();
        }
        else{
            this.setHp(Math.min(hp, maxHp));
        }
    }

    /**
     * Modify the value of Fp making sure to stay in the valid values
     * @param fp new fight points
     */
    protected void changeFp(int fp) {
        int maxFp = this.getMaxFp();
        if (fp <= 0) {
            this.setFp(0);
        } else {
            this.setFp(Math.min(fp, maxFp));
        }
    }

    /**
     * Change the state of the character to dead.
     */
    private void dead(){
        this.status = "dead";
    }

    /**
     * Indicates if the character is dead or alive by giving a boolean valor
     * @return true if the player is dead, false if it isn't
     */
    public boolean isKO(){
        return "dead".equals(this.getStatus());
    }

    /**
     * The item is added in the Players' inventory
     * @param a item
     */
    public void addAItem(IItem a){
        inventory.add(a);
    }

    /**
     * The Player makes use of an item
     * @param item object that the Player is using
     */
    public void useItem(IItem item){
        item.usage(this);

    }

    /**
     * Attack an enemy doing a jump
     *
     * Incomplete. just for testing the damage and receiveDamage methods.
     *
     * @param enemy enemy to attack
     */
    public void attackJump(ICharacter enemy) {
        if (this.isKO() || this.getFp()==0) {
            enemy.receiveDamage(0);
        }
        else{
            double k = 1.0;
            int damage = damage(enemy, k);
            changeFp(getFp() - 1);
            enemy.receiveDamage(damage);
        }
    }

    /**
     * Calculated the damage that the player is going to inflicts
     * to the Enemy, according to their stats
     * @param character attacked
     * @param k parameter that depend on the attack
     * @return damage calculated
     */
    @Override
    public int damage(ICharacter character, double k) {
        int def_B = character.getDef();
        int atk_A = this.getAtk();
        int Lvl_A = this.getLvl();
        return (int) (k * atk_A * Lvl_A / def_B);
    }

    /**
     * Apply the damage done by the Enemy to the Player
     * @param damage calculated value
     */
    @Override
    public void receiveDamage(int damage) {
        int newHp = this.hp - damage;
        this.changeHp(newHp);
    }

    /**
     * Gives the Players' defense
     * @return def
     */
    @Override
    public int getDef() {
        return this.def;
    }
}