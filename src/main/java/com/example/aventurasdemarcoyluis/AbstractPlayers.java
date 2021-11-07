package com.example.aventurasdemarcoyluis;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represent a Player in the game
 *
 *  @author Isabella Meirone
 */
public abstract class AbstractPlayers extends AbstractCharacter implements IPlayer, AttackedByEnemy{
    private int fp;
    private int maxFp;
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
    public AbstractPlayers(int ATK, int DEF, int HP, int FP, int LVL){
        super(ATK, DEF, HP, LVL);
        this.fp = this.maxFp = FP;
        this.inventory = new ArrayList<>();

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
     * Modify the value of the Players' fp
     * @param fp new fp
     */
    private void setFp(int fp){
        this.fp = fp;
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

    public boolean cannotAttack(){
        return this.isKO() || this.getFp()==0 ;
    }


    public void attackJump(@NotNull AttackedByPlayers enemy){
        enemy.attackedByPlayerJump(this);
    }

    public void attackHammer(@NotNull AttackedByPlayers enemy){
        enemy.attackedByPlayerHammer(this);
    }

    @Override
    public int jump(IEnemy enemy) {
        if (this.cannotAttack()) {
            return 0;
        }
        else{
            double k = 1.0;
            changeFp(getFp() - 1);
            return damage(enemy, k);
        }
    }

    @Override
    public int hammer(IEnemy enemy) {
        double k = 1.5;
        changeFp(getFp() - 2);
        return damage(enemy, k);
    }

    @Override
    public void attackedByEnemy(IEnemy enemy) {
        enemy.attack(this);
    }
}