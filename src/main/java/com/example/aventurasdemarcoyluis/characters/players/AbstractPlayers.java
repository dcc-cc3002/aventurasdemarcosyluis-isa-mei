package com.example.aventurasdemarcoyluis.characters.players;

import com.example.aventurasdemarcoyluis.characters.*;
import com.example.aventurasdemarcoyluis.characters.enemies.AttackedByPlayers;
import com.example.aventurasdemarcoyluis.characters.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.items.Baul;
import com.example.aventurasdemarcoyluis.items.IItem;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * Subclass of AbstractCharacter. Abstract class that represent a Player(Marcos & Luis) in the game
 *
 *  @author Isabella Meirone
 */
public abstract class AbstractPlayers extends AbstractCharacter
        implements IPlayer, AttackedByEnemy {
    private final Random random;
    private int fp;
    private int maxFp;

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
        random = new Random();
        this.fp = this.maxFp = FP;
    }

    /**
     * Set the seed for the random number generator.
     * The seed its set to obtain determinate series of integers
     * @param seed number of the seed
     */
    public void setSeed(long seed) {
        random.setSeed(seed);
    }

    /**
     * Gives a random integer number between 1 and 4
     * @return random integer
     */
    public int roll() {
        return random.nextInt(4)+1;
    }

    /**
     * The Player went up a level, so its stats changes.
     */
    public void levelUp() {
        double k = 0.15;
        int newFp = (int) (getMaxFp() + getMaxFp()*k);
        int newHp =  (int) (getMaxHp() + getMaxHp()*k);
        this.setLvl(getLvl()+1);
        this.setMaxFp(newFp);
        this.setFp(newFp);
        this.setMaxHp(newHp);
        this.setHp(newHp);
        this.setAtk((int) (getAtk() + getAtk()*k));
        this.setDef((int) (getDef() + getDef()*k));
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
     * Modify the value of the Players' maxFp
     * @param maxFp new maxFp
     */
    private void setMaxFp(int maxFp) { this.maxFp = maxFp; }

    /**
     * Modify the value of Fp making sure to stay in the valid values
     * @param fp new fight points
     */
    public void changeFp(int fp) {
        int maxFp = this.getMaxFp();
        if (fp <= 0) {
            this.setFp(0);
        } else {
            this.setFp(Math.min(fp, maxFp));
        }
    }


    /**
     * The Player makes use of an item, so its remove from the inventory
     * @param baul share trunk that contains the item for the PLayer
     * @param item object that the Player is using
     */
    public void useItem(@NotNull Baul baul, IItem item){
        if (baul.askForItem(item) & !(this.isKO())){
            item.usage(this);
            baul.removeItem(item);
        }
    }

    /**
     * Ask if the Player is dead or has not had fp to attack
     * @return true if player cannot attack, false if it can
     */
    private boolean cannotAttack(){
        return this.isKO() || this.getFp()==0 ;
    }

    /**
     * Use Double dispatch to attack an enemy(Goomba, Spiny) with a jump
     * @param enemy Goomba or Spiny
     */
    public void attackJump(@NotNull AttackedByPlayers enemy){
        enemy.attackedByPlayerJump(this);
    }

    /**
     * Use Double dispatch to attack an enemy(Goomba, Spiny) with the hammer
     * @param enemy Goomba or Spiny
     */
    public void attackHammer(@NotNull AttackedByPlayers enemy){
        enemy.attackedByPlayerHammer(this);
    }

    /**
     * Gives the value of the damage made by attacking with jump
     * @param enemy enemy to attack
     * @return damage by jump
     */
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

    /**
     * Gives the value of the damage made by attacking with hammer
     * @param enemy enemy to attack
     * @return damage by hammer
     */
    @Override
    public int hammer(IEnemy enemy) {
        if (this.cannotAttack()) {
            return 0;
        }
        else{
            double k = 1.5;
            changeFp(getFp() - 2);
            if (roll() == 2){
                return damage(enemy, k);
            }
            else {
                return 0;
            }
        }
    }

    /**
     * The player is attacked by an Enemy
     * @param enemy enemy to attack
     */
    @Override
    public void attackedByEnemy(@NotNull IEnemy enemy) {
        enemy.attack(this);
    }
}