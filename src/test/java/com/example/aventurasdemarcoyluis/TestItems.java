package com.example.aventurasdemarcoyluis;

import com.example.aventurasdemarcoyluis.characters.players.Luis;
import com.example.aventurasdemarcoyluis.characters.players.Marcos;
import com.example.aventurasdemarcoyluis.items.Baul;
import com.example.aventurasdemarcoyluis.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.items.IItem;
import com.example.aventurasdemarcoyluis.items.RedMushroom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestItems {
    private Marcos testMarcos;
    private Luis testLuis;
    private IItem testRedMushroom;
    private IItem testHoneySyrup;
    private Baul testBaul;


    @BeforeEach
    public void setUp() {
        testMarcos = new Marcos(7, 7, 10, 5, 4);
        testLuis = new Luis(5, 9, 11, 5, 5);
        testRedMushroom = new RedMushroom();
        testHoneySyrup = new HoneySyrup();
        testBaul = new Baul();
    }

    @Test
    public void testBaul(){
        assertFalse(testBaul.askForItem(testHoneySyrup));
        testBaul.addItem(testHoneySyrup);
        testBaul.addItem(testRedMushroom);
        assertTrue(testBaul.askForItem(testHoneySyrup));
        assertTrue(testBaul.askForItem(testRedMushroom));
        testBaul.removeItem(testRedMushroom);
        assertFalse(testBaul.askForItem(testRedMushroom));

    }
    @Test
    public void TestRedMushroom(){
        testMarcos.changeHp(4);
        int actualHpMarcos = testMarcos.getHp();
        testMarcos.useItem(testBaul, testRedMushroom);

        //Marcos is not healing, because baul is empty
        assertEquals(actualHpMarcos, testMarcos.getHp());

        //Marcos use RedMushroom, so it's removed from baul
        testBaul.addItem(testRedMushroom);
        testMarcos.useItem(testBaul, testRedMushroom);
        assertNotEquals(actualHpMarcos, testMarcos.getHp());
        assertEquals(actualHpMarcos+testMarcos.getMaxHp()/10, testMarcos.getHp());

        //Luis and Marcos share inventory, so in baul isn't a redMushroom and Luis is cannot use one.
        testLuis.changeHp(5);
        int actualHpLuis = testLuis.getHp();
        testLuis.useItem(testBaul, testRedMushroom);
        assertEquals(actualHpLuis, testLuis.getHp());
    }

    @Test
    public void TestHoneySyrup() {
        testBaul.addItem(testHoneySyrup);
        testBaul.addItem(testHoneySyrup);

        //Restore Luis' Fp not surpassing the maximum
        testLuis.changeFp(3);
        int actualFpLuis = testLuis.getFp();
        testLuis.useItem(testBaul, testHoneySyrup);
        assertNotEquals(actualFpLuis, testLuis.getFp());
        assertEquals(testLuis.getMaxFp(), testLuis.getFp());

        //Marcos is dead, so it cannot use the item, and it's not remove it from baul
        testMarcos.changeFp(1);
        testMarcos.changeHp(0);
        testMarcos.useItem(testBaul, testHoneySyrup);
        assertEquals(1, testMarcos.getFp());
        assertTrue(testBaul.askForItem(testHoneySyrup));
    }
}
