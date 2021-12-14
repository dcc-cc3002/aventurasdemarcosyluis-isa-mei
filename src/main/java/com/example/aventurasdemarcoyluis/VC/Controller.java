package com.example.aventurasdemarcoyluis.VC;

import com.example.aventurasdemarcoyluis.model.characters.ICharacter;
import com.example.aventurasdemarcoyluis.model.characters.enemies.Boo;
import com.example.aventurasdemarcoyluis.model.characters.enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.characters.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.model.characters.enemies.Spiny;
import com.example.aventurasdemarcoyluis.model.characters.players.IPlayer;
import com.example.aventurasdemarcoyluis.model.characters.players.Luis;
import com.example.aventurasdemarcoyluis.model.characters.players.Marcos;
import com.example.aventurasdemarcoyluis.model.item.Baul;
import com.example.aventurasdemarcoyluis.model.item.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.item.IItem;
import com.example.aventurasdemarcoyluis.model.item.RedMushroom;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class controller
 * @author Isabella Meirone
 */

public class Controller {
    public ICharacter actualTurn;
    public ICharacter nextTurn;
    public int level=1;
    public int turn = 0;
    private final Baul playersBaul;
    private final HoneySyrup honeySyrup;
    private final RedMushroom redMushroom;
    public List<IPlayer> playersInTurn;
    public List<IEnemy> enemiesInTurn;
    public List<IPlayer> playersDefeat;
    private List<IPlayer> players;
    private final Random random;

    /**
     * Class constructor
     */
    public Controller() {
        playersBaul = createBaul();
        honeySyrup = createHoney();
        redMushroom = createMushroom();
        random = new Random();
        playersInTurn = new ArrayList<>();
        enemiesInTurn = new ArrayList<>();
        playersDefeat = new ArrayList<>();
        players = new ArrayList<>();

    }

    /**
     * the controler creates a Marco and its add to the list of players
     * @param atk attack
     * @param def defense
     * @param maxHp max heal point
     * @param maxFp max fight point
     * @param lvl level
     * @return marco
     */
    public Marcos createMarcos(int atk, int def, int maxHp, int maxFp, int lvl) {
        Marcos marcos = new Marcos(atk, def, maxHp, maxFp, lvl);
        playersInTurn.add(marcos);
        players.add(marcos);
        actualTurn = marcos;

        return marcos;
    }

    /**
     * Controller creates a Luis antits add to the  list of players
     * @param atk attack
     * @param def defense
     * @param maxHp max heal points
     * @param maxFp mas fight points
     * @param lvl level
     * @return luis
     */
    public Luis createLuis(int atk, int def, int maxHp, int maxFp, int lvl) {
        Luis luis = new Luis(atk, def, maxHp, maxFp, lvl);
        playersInTurn.add(luis);
        players.add(luis);
        nextTurn = luis;

        return luis;
    }

    /**
     * Controller creates agoomba enemy and its add to list of enemies
     * @param atk attack
     * @param def defense
     * @param maxHp max heal points
     * @param lvl level
     * @return goomba
     */
    public Goomba createGoomba(int atk, int def, int maxHp, int lvl) {
        Goomba goomba = new Goomba(atk, def, maxHp, lvl);
        enemiesInTurn.add(goomba);

        return goomba;
    }

    /**
     * Controller creates a boo enemy and its add to thw list of enemies
     * @param atk attack
     * @param def defense
     * @param maxHp max heal points
     * @param lvl level
     * @return boo
     */
    public Boo createBoo(int atk, int def, int maxHp, int lvl) {
        Boo boo = new Boo(atk, def, maxHp, lvl);
        enemiesInTurn.add(boo);

        return boo;
    }

    /**
     * Controller creates a spiny enemy and its add to the list of enemies
     * @param atk attack
     * @param def defense
     * @param maxHp max heal points
     * @param lvl level
     * @return spiny
     */
    public Spiny createSpiny(int atk, int def, int maxHp, int lvl) {
        Spiny spiny = new Spiny(atk, def, maxHp, lvl);
        enemiesInTurn.add(spiny);

        return spiny;
    }

    /**
     * Creates an enemy by random and its added to the list of enemies
     * @param atk attack
     * @param def defense
     * @param maxHp max heal points
     * @param lvl level
     */
    public void addEnemy(int atk, int def, int maxHp, int lvl) {
        int n = random.nextInt(3);
        if (n == 0) { createGoomba(atk, def, maxHp, lvl); }
        if (n == 1) { createSpiny(atk, def, maxHp, lvl); }
        if (n == 2) {createBoo(atk, def, maxHp, lvl);}
    }

    /**
     * creates the players baul
     * @return a baul
     */
    public Baul createBaul() {
        return new Baul();
    }

    /**
     * creates a honey syrup item
     * @return a rhoney syrup
     */
    public HoneySyrup createHoney() {
        return new HoneySyrup();
    }

    /**
     * creates a red mushroom item
     * @return a red mushroom
     */
    public RedMushroom createMushroom() {
        return new RedMushroom();
    }

    /**
     * Show the items in the players' baul
     * @return the players' itesm
     */
    public List<IItem> getItems() {
        return playersBaul.getInventory();
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
     * Indicates the character in turn
     * @return character
     */
    public ICharacter getActualTurn() {
        return actualTurn;
    }

    /**
     * Gives all the actual characters that are alive in the game and
     * in the correct order
     * @return characters in turn
     */
    public List<ICharacter> getCharactersInTurn() {
        List<ICharacter> inTurn= new ArrayList<>();
        inTurn.addAll(playersInTurn);
        inTurn.addAll(enemiesInTurn);
        return  inTurn;
    }

    /**
     * Gives the players that are alive in the game
     * @return players in turn
     */
    public List<IPlayer> getPlayersInTurn() {
        return playersInTurn;
    }

    /**
     * Gives the enemies that are alive in the game
     * @return enemies in turn
     */
    public List<IEnemy> getEnemiesInTurn() {
        return enemiesInTurn;
    }

    /**
     * Indicates the character that is next in the turn
     * @return next character
     */
    public ICharacter getNextTurn() {
        return nextTurn;
    }

    /**
     * Advance in one turn
     */
    public void nextTurn() {
        turn =  (turn + 1)%getCharactersInTurn().size();
    }

    /**
     * Finalize the turn, then removes the KO characters from the list, advance to
     * the next turn and teh actual character in turn and the next are updated
     */
    public void endTurn() {
        removeKO();
        nextTurn();
        List<ICharacter> characters= getCharactersInTurn();
        actualTurn = characters.get(turn);
        nextTurn = characters.get((turn + 1)%characters.size());
    }

    /**
     * if the given players is KO, its remove from the list and
     * is added to the defeat players list
     * @param player player to check
     */
    private void removePlayerKO(@NotNull IPlayer player) {
        if (player.isKO()) {
            playersDefeat.add(player);
            getPlayersInTurn().remove((player));
        }
    }

    /**
     * If the given enemy is KO, its eliminated from the turn
     * @param enemy enemy to check
     */
    private void removeEnemyKO(@NotNull IEnemy enemy) {
        if (enemy.isKO()) {
            getEnemiesInTurn().remove(enemy);
        }
    }

    /**
     * Removes all the characters that are kO
     */
    public void removeKO() {
        for (int i=0; i < getPlayersInTurn().size(); i++){
            removePlayerKO(getPlayersInTurn().get(i));
        }
        for (int i=0; i < getEnemiesInTurn().size(); i++){
            removeEnemyKO(getEnemiesInTurn().get(i));
        }
    }

    /**
     * The player use or is given a honey syrup to use, and the turn is finished
     * @param player player to use the honey syrup
     */
    public void playerUseHoney(@NotNull IPlayer player) {
        player.useItem(playersBaul, honeySyrup);
        endTurn();
    }

    /**
     * The player use or is given a red mushroom to use, and the turn is finished
     * @param player player to use a red mushroom
     */
    public void playerUseMushroom(@NotNull IPlayer player) {
        player.useItem(playersBaul, redMushroom);
        endTurn();
    }

    /**
     * The player pass its turn
     */
    public void tryToPass() {
        endTurn();
    }

    /**
     * its added a honey syrup to the players baul
     */
    public void addHoney() {
        playersBaul.addItem(honeySyrup);
    }

    /**
     * its added a red mushroom to the players baul
     */
    public void addMushroom() {
        playersBaul.addItem(redMushroom);
    }

    /**
     * Indicates that the players defeat all the enemims so they win
     * @return true if players win
     */
    public boolean playersWin() {
        return (getEnemiesInTurn().size() == 0) && (playersDefeat.size() < 2) ;
    }

    /**
     * the game advanced to the  next level, so yhe players get level up
     * and the actual player, next player and turn are reset-
     */
    private void nextLevel() {
        players.get(0).levelUp();
        players.get(1).levelUp();
        playersInTurn.clear();
        playersInTurn.add(players.get(0));
        playersInTurn.add(players.get(1));
        players = playersInTurn;
        playersDefeat.clear();
        actualTurn = playersInTurn.get(0);
        nextTurn = playersInTurn.get(1);
        level++;
        turn = 0;
    }

    /**
     * Advanced to the next level it the players win
     */
    public void advanceLevel(){
        if (playersWin()) { nextLevel();}
    }

    /**
     * Gives the players that are dead
     * @return players defeat
     */
    public List<IPlayer> getPlayersDefeat() {
        return playersDefeat;
    }

}
