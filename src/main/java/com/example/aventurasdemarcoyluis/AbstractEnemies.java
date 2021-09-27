package com.example.aventurasdemarcoyluis;

/**
 * Abstract class for the Enemies in the game
 */
public abstract class AbstractEnemies implements ICharacter{
    private int atk;
    private int def;
    private int hp;
    private int maxHp;
    private int lvl;
    private String status;

    /**
     * Creates a new Enemy
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     *
     */
    public AbstractEnemies(int ATK, int DEF, int HP, int LVL){
        this.atk = ATK;
        this.def = DEF;
        this.hp = this.maxHp = HP;
        this.lvl = LVL;
        this.status = "alive";

    }

    /**
     * Gives the Enemy's attack
     * @return atk
     */
    private int getAtk() { return this.atk ; }

    /**
     * Gives the Enemy's heal points
     * @return hp
     */
    public int getHp() { return this.hp; }

    /**
     * Gives the Enemy's level
     * @return lvl
     */
    public int getLvl() { return this.lvl; }

    /**
     * Gives the Enemy's status
     * @return status
     */
    private String getStatus() { return this.status; }

    /**
     * Modify the value of the hp
     * @param hp new hp
     */
    private void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Change the state of the character to dead.
     */
    private void dead(){
        this.status = "dead";
    }

    /**
     * Indicates if the character is dead or alive by giving a boolean valor
     * @return true if the enemy is dead, false if it isn't
     */
    public boolean isKO(){
        return "dead".equals(this.getStatus());
    }

    /**
     * The enemy attack a player, so receives damage
     * @param player player to attack
     */
    public void attack(Players player) {
        if (this.isKO()) {
            player.receiveDamage(0);
        }
        else{
            double k = 0.75;
            int damage = damage(player, k);
            player.receiveDamage(damage);
        }
    }

    /**
     * Calculated the damage that the Enemy is going to inflicts
     * to the Player, according to their stats
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
     * Apply the damage done by a Player to the Enemy
     * @param damage calculated value
     */
    @Override
    public void receiveDamage(int damage) {
        if (damage >= this.getHp()) {
            this.setHp(0);
            this.dead();
        }
        else {
            int newHp = this.getHp() - damage;
            this.setHp(newHp);
        }
    }

    /**
     * Gives the Enemy's defense
     * @return def
     */
    @Override
    public int getDef() {
        return this.def;
    }

}
