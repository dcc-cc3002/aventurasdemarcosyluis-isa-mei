package com.example.aventurasdemarcoyluis.model.characters;

/**
 * Abstract Class that represents the characters of the game.
 *
 * @author Isabella Meirone
 */
public abstract class AbstractCharacter implements ICharacter {
    private int atk;
    private int def;
    private int hp;
    private int maxHp;
    private int lvl;
    private String status;

    /**
     * Constructor of the abstract character
     * @param atk attack points
     * @param def defense points
     * @param hp heal points
     * @param lvl level of the Unit
     */
    public AbstractCharacter(int atk, int def, int hp, int lvl){
        this.atk = atk;
        this.def = def;
        this.hp = this.maxHp = hp;
        this.lvl = lvl;
        this.status = "alive";
    }

    /**
     * Gives the Character's attack
     * @return atk
     */
    public int getAtk() { return this.atk ; }

    /**
     * Gives the maximum value of heal points
     * @return maxHp
     */
    @Override
    public int getMaxHp(){
        return this.maxHp;
    }

    /**
     * Gives the Character's level
     * @return lvl
     */
    @Override
    public int getLvl() { return this.lvl; }

    /**
     * Gives the Characters' status
     * @return status
     */
    private String getStatus() { return this.status; }

    /**
     * Modify the value of the Characters' heal points
     * @param hp new hp
     */
    protected void setHp(int hp){ this.hp = hp; }

    /**
     * Modify the value of the characters' max heal points
     * @param maxHp new maxHp
     */
    protected void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    }

    /**
     * Modify the value of the Characters' attack
     * @param atk new attack
     */
    protected void setAtk(int atk) { this.atk = atk; }

    /**
     * Modify the value of the Characters' defense
     * @param def new defense
     */
    protected void setDef(int def) { this.def = def; }

    /**
     * Modify the value of the Characters' level
     * @param lvl new level
     */
    protected  void setLvl(int lvl) { this.lvl = lvl; }

    /**
     * Modify the value of Hp making sure to stay in between the valid values
     * If heal points are 0 then the Character's status is changed
     * @param hp new heal points
     */
    @Override
    public void changeHp(int hp) {
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
     * Change the state of the character to dead.
     */
    private void dead(){
        this.status = "dead";
    }

    /**
     * Indicates if the character is dead or alive by giving a boolean valor
     * @return true if the player is dead, false if it isn't
     */
    @Override
    public boolean isKO(){
        return "dead".equals(this.getStatus());
    }

    /**
     * Calculated the damage that the Character is going to inflicts
     * to another Character, according to their stats
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
     * Apply the damage done to the Character
     * @param damage calculated value
     */
    @Override
    public void receiveDamage(int damage) {
        int newHp = this.hp - damage;
        this.changeHp(newHp);
    }

    /**
     * Gives the Characters' defense
     * @return def
     */
    @Override
    public int getDef() {
        return this.def;
    }

    /**
     * Gives the Character's heal points
     * @return hp
     */
    @Override
    public int getHp() { return this.hp; }
}
