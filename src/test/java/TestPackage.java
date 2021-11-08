
import com.example.aventurasdemarcoyluis.characters.enemies.Boo;
import com.example.aventurasdemarcoyluis.characters.enemies.Goomba;
import com.example.aventurasdemarcoyluis.characters.enemies.Spiny;
import com.example.aventurasdemarcoyluis.characters.players.Luis;
import com.example.aventurasdemarcoyluis.characters.players.Marcos;
import com.example.aventurasdemarcoyluis.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.items.IItem;
import com.example.aventurasdemarcoyluis.items.RedMushroom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test
 */
public class TestPackage {

    private Goomba testGoomba;
    private Boo testBoo;
    private Spiny testSpiny;
    private Marcos testMarcos;
    private Luis testLuis;
    private IItem testRedMushroom;
    private IItem testHoneySyrup;


    @BeforeEach
    public void setUp() {
        testGoomba= new Goomba(2,4,15,8);
        testBoo = new Boo(5,9,3,8);
        testSpiny = new Spiny(4, 6, 20, 8);
        testMarcos = new Marcos(7, 7, 10, 5, 4);
        testLuis = new Luis(5, 9, 11, 5, 5);
        testRedMushroom = new RedMushroom();
        testHoneySyrup = new HoneySyrup();
    }

    @Test
    public void testCharacters() {
        assertEquals(testBoo.getLvl(), testGoomba.getLvl());
        assertNotEquals(testGoomba.getHp(), testSpiny.getHp());
        assertNotEquals(testMarcos.getLvl(), testLuis.getLvl());
        assertFalse(testLuis.isKO());
        assertEquals(testMarcos.getFp(), testLuis.getFp());

    }

    @Test
    public void testInteractionCharacter() {
        //Marcos is attacked, so his hp change but is not dead
        int actualHpMarcos = testMarcos.getHp();
        testGoomba.attack(testMarcos);
        assertNotEquals(actualHpMarcos, testMarcos.getHp());
        assertFalse(testMarcos.isKO());

        //Boo is attacked by Marcos and go dead. Marcos expend 1 fp
        int actualHpBoo = testBoo.getHp();
        int actualFpMarcos = testMarcos.getFp();
        testMarcos.attackJump(testBoo);
        assertNotEquals(actualFpMarcos, testMarcos.getFp());
        assertNotEquals(actualHpBoo, testBoo.getHp());
        assertTrue(testBoo.isKO());

        //If Boo is dead it cannot attack Luis.
        int actualHpLuis = testLuis.getHp();
        testBoo.attack((testLuis));
        assertEquals(actualHpLuis, testLuis.getHp());

        //Test para mostrar el error. Se corregirá cuando se implemeten bien los ataques
        //int actualHpMarcos2 = testMarcos.getHp();
        //testLuis.attackJump(testMarcos);
        //assertNotEquals(actualHpMarcos2, testMarcos.getHp());

        //Marcos expend all his fp, so after that he cannot attack the enemy.
        testSpiny.attack(testMarcos);
        testMarcos.jump(testSpiny);
        testMarcos.jump(testSpiny);
        testMarcos.jump(testSpiny);
        testMarcos.jump(testSpiny);
        int actualHpSpiny = testSpiny.getHp();
        assertEquals(0, testMarcos.getFp());
        testMarcos.jump(testSpiny);
        assertEquals(actualHpSpiny, testSpiny.getHp());

        //Spiny kills Marcos
        testSpiny.attack(testMarcos);
        testSpiny.attack(testMarcos);
        assertTrue(testMarcos.isKO());

    }

    @Test
    public void testItems() {
        //test Honey Syrup
        testLuis.jump(testGoomba);
        int actualFpLuis = testLuis.getFp();
        testLuis.useItem(testHoneySyrup);
        assertNotEquals(actualFpLuis, testLuis.getFp());
        assertEquals(testLuis.getMaxFp(), testLuis.getFp());

        //Test Red Mushroom
        testGoomba.attack(testLuis);
        int actualHpLuis = testLuis.getHp();
        testLuis.useItem(testRedMushroom);
        assertNotEquals(actualHpLuis, testLuis.getHp());
        assertEquals(testLuis.getMaxHp(), testLuis.getHp());

    }
}

