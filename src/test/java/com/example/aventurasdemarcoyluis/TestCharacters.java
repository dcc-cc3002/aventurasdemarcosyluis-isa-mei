package com.example.aventurasdemarcoyluis;

import com.example.aventurasdemarcoyluis.model.characters.enemies.Boo;
import com.example.aventurasdemarcoyluis.model.characters.enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.characters.enemies.Spiny;
import com.example.aventurasdemarcoyluis.model.characters.players.Luis;
import com.example.aventurasdemarcoyluis.model.characters.players.Marcos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test
 */
public class TestCharacters {

    private Goomba testGoomba;
    private Boo testBoo;
    private Spiny testSpiny;
    private Marcos testMarcos;
    private Luis testLuis;


    @BeforeEach
    public void setUp() {
        testGoomba= new Goomba(2,4,15,8);
        testBoo = new Boo(5,9,3,8);
        testSpiny = new Spiny(4, 6, 10, 8);
        testMarcos = new Marcos(7, 7, 20, 7, 3);
        testLuis = new Luis(5, 9, 11, 5, 1);
    }

    @Test
    public void testCharacters() {
        assertEquals(testBoo.getLvl(), testGoomba.getLvl());
        assertNotEquals(testGoomba.getHp(), testSpiny.getHp());
        assertNotEquals(testMarcos.getLvl(), testLuis.getLvl());
        assertFalse(testLuis.isKO());
    }

    @Test
    public void testHammerAttack() {
        testLuis.setSeed(2);//random numbers with this seed: 3, 2, 4, 1, 2, 4,...
        int actualHpSpiny = testSpiny.getHp();
        testLuis.attackHammer(testSpiny);
        assertEquals(actualHpSpiny, testSpiny.getHp());//miss it
        testLuis.attackHammer(testSpiny);
        assertNotEquals(actualHpSpiny, testSpiny.getHp());

        testMarcos.setSeed(10);//random numbers with this seed: 3, 2, 2, 2, 1,...
        testMarcos.attackHammer(testGoomba);
        int actualHpBoo = testBoo.getHp();
        int actualFpMarcos = testMarcos.getFp();
        //Marcos attack Boo with the hammer, but boo cannot be attack by hammer,
        // so it not receives damage
        testMarcos.attackHammer(testBoo);
        assertEquals(actualHpBoo, testBoo.getHp());
        assertNotEquals(actualFpMarcos, testMarcos.getFp());
    }

    @Test
    public void testJumpAttack() {
        int actualHpGoomba = testGoomba.getHp();
        int actualFpLuis = testLuis.getFp();
        testLuis.attackJump(testGoomba);
        assertNotEquals(actualHpGoomba, testGoomba.getHp());
        assertEquals(actualFpLuis-1, testLuis.getFp());

        //Marcos attack Spiny whit jump, but it has not effective and Marcos receive damage
        int actualHpSpiny = testSpiny.getHp();
        int actualHpMarcos = testMarcos.getHp();
        testMarcos.attackJump(testSpiny);
        assertEquals(actualHpSpiny, testSpiny.getHp());
        assertNotEquals(actualHpMarcos, testMarcos.getHp());
    }

    @Test
    public void testLevelUp(){
        int actualHP = testMarcos.getHp();
        int actualFp = testMarcos.getFp();
        int actualMaxHp = testMarcos.getMaxHp();
        int actualMaxFp = testMarcos.getMaxFp();
        int actualDef = testMarcos.getDef();
        int actualAtk = testMarcos.getAtk();
        int actualLvl = testMarcos.getLvl();
        testMarcos.levelUp();
        assertNotEquals(actualHP, testMarcos.getHp());
        assertNotEquals(actualFp, testMarcos.getFp());
        assertNotEquals(actualMaxHp, testMarcos.getMaxHp());
        assertNotEquals(actualMaxFp, testMarcos.getMaxFp());
        assertNotEquals(actualDef, testMarcos.getDef());
        assertNotEquals(actualAtk, testMarcos.getAtk());
        assertEquals(actualLvl+1, testMarcos.getLvl());
    }

    @Test
    public void TestBoo() {
        //Boo attacks Luis
        int actualHpLuis = testLuis.getHp();
        testBoo.attackTo(testLuis);
        assertNotEquals(actualHpLuis, testLuis.getHp());

        //Marcos kill Boo
        int actualHpBoo = testBoo.getHp();
        testMarcos.attackJump(testBoo);
        testMarcos.attackJump(testBoo);
        assertNotEquals(actualHpBoo, testBoo.getHp());
        assertTrue(testBoo.isKO());

        //Boo is dead, so it cannot attack Luis
        int actualHpLuis2 = testLuis.getHp();
        testBoo.attackTo((testLuis));
        assertEquals(actualHpLuis2, testLuis.getHp());
    }

    @Test
    public void TestSpiny(){
        //Spiny not receive damage being attacked by jump and hurt the player
        int actualHpMarcos = testMarcos.getHp();
        int actualHpSpiny = testSpiny.getHp();
        testMarcos.attackJump(testSpiny);
        testMarcos.attackJump(testSpiny);
        assertEquals(actualHpSpiny, testSpiny.getHp());
        assertNotEquals(actualHpMarcos, testMarcos.getHp());

        //Spiny attack a player
        int actualHpLuis = testLuis.getHp();
        testSpiny.attackTo(testLuis);
        assertNotEquals(actualHpLuis, testLuis.getHp());

        //Spiny can be attacked by the hammer
        testMarcos.setSeed(10);
        testMarcos.attackHammer(testSpiny);
        testMarcos.attackHammer(testSpiny);
        assertNotEquals(actualHpSpiny, testSpiny.getHp());

    }

    @Test
    public void TestGoomba() {
        //goomba attack a player
        int actualHpMarcos = testMarcos.getHp();
        testGoomba.attackTo(testMarcos);
        assertNotEquals(actualHpMarcos,testMarcos.getHp());

        //Goomba can be attacked by jump and hammer
        testLuis.setSeed(10);
        int actualHPGoomba = testGoomba.getHp();
        testLuis.attackHammer(testGoomba);
        testLuis.attackHammer(testGoomba);
        assertNotEquals(actualHPGoomba, testGoomba.getHp());
        int actualHPGoomba2 = testGoomba.getHp();
        testLuis.attackJump(testGoomba);
        assertNotEquals(actualHPGoomba2, testGoomba.getHp());
    }

    @Test
    public void testToString() {
        assertEquals("Marcos", testMarcos.toString());
        assertEquals("Luis", testLuis.toString());
        assertEquals("Goomba", testGoomba.toString());
        assertEquals("Boo", testBoo.toString());
        assertEquals("Spiny", testSpiny.toString());
    }

}

