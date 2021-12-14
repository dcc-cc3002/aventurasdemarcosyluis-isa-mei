package com.example.aventurasdemarcoyluis;

import com.example.aventurasdemarcoyluis.VC.Controller;
import com.example.aventurasdemarcoyluis.model.characters.enemies.Boo;
import com.example.aventurasdemarcoyluis.model.characters.enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.characters.players.Luis;
import com.example.aventurasdemarcoyluis.model.characters.players.Marcos;
import com.example.aventurasdemarcoyluis.model.item.Baul;
import com.example.aventurasdemarcoyluis.model.item.HoneySyrup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestController {

    private Marcos marcos;
    private Luis luis;
    private HoneySyrup honeySyrup;
    private Goomba goomba;
    private Controller controller;
    private Marcos marcosController;
    private Luis luisController;
    private Goomba goombacontroller;
    private Baul baul;
    private Baul baulController;



    @BeforeEach
    public void setUp() {
        luis = new Luis(8, 10, 15, 10, 1);
        marcos = new Marcos(10, 9, 14, 18, 1);
        goomba = new Goomba(12, 7, 10, 2);
        honeySyrup = new HoneySyrup();
        baul = new Baul();
        controller = new Controller();
        marcosController = controller.createMarcos(marcos.getAtk(), marcos.getDef(), marcos.getMaxHp(),
                                                    marcos.getMaxFp(), marcos.getLvl());
        luisController = controller.createLuis(luis.getAtk(), luis.getDef(), luis.getMaxHp(),
                                                luis.getMaxFp(), luis.getLvl());
        goombacontroller = controller.createGoomba(goomba.getAtk(), goomba.getDef(), goomba.getMaxHp(),
                                                    goomba.getLvl());
        baulController = controller.createBaul();

    }

    @Test
    public void testCreate() {
        assertEquals(marcos.getClass(), marcosController.getClass());
        assertEquals(luis.getClass(), luisController.getClass());
        assertEquals(goomba.getClass(), goombacontroller.getClass());

        Boo boo = new Boo(5, 2, 20, 2);
        Boo booController = controller.createBoo(boo.getAtk(), boo.getDef(), boo.getMaxHp(), boo.getLvl());
        assertEquals(boo.getClass(), booController.getClass());

        assertEquals(baul.getClass(), baulController.getClass());

        HoneySyrup honeyController = controller.createHoney();
        assertEquals(honeySyrup.getClass(), honeyController.getClass());

    }

    @Test
    public void testBaul() {
        assertEquals(controller.getItems(), baul.getInventory());

        HoneySyrup honeyController = controller.createHoney();
        controller.addHoney();
        baul.addItem(honeyController);
        assertEquals(controller.getItems().get(0).getClass(), baul.getInventory().get(0).getClass());
        assertEquals(controller.getItems().size(), baul.getInventory().size());

        controller.getPlayersInTurn().get(0).changeFp(10);
        controller.playerUseHoney(controller.getPlayersInTurn().get(0));
        assertEquals(13, controller.getPlayersInTurn().get(0).getFp());

        assertTrue(controller.getItems().isEmpty());

        controller.addMushroom();
        controller.getPlayersInTurn().get(1).changeHp(0);
        controller.playerUseMushroom(controller.getPlayersInTurn().get(1));
        assertFalse(controller.getItems().isEmpty());

    }

    @Test
    public void testTurn() {
        assertEquals("Marcos", controller.getActualTurn().toString());
        assertEquals("Luis", controller.getNextTurn().toString());
        controller.tryToPass();
        assertEquals("Luis", controller.getActualTurn().toString());
        assertEquals("Goomba", controller.getNextTurn().toString());
        controller.tryToPass();
        assertEquals("Goomba", controller.getActualTurn().toString());
        assertEquals("Marcos", controller.getNextTurn().toString());
    }
    @Test
    public void testRemoveKOCheckWinAndNextLeve() {
        controller.getEnemiesInTurn().get(0).changeHp(0);
        controller.removeKO();
        assertFalse(controller.getEnemiesInTurn().contains(goombacontroller));
        assertEquals(2, controller.getCharactersInTurn().size());

        controller.getPlayersInTurn().get(0).changeHp(0);
        controller.removeKO();
        assertEquals(1, controller.getPlayersDefeat().size());
        assertTrue(controller.playersWin());

        controller.advanceLevel();
        assertEquals(2, controller.getCharactersInTurn().size());
        assertEquals(0, controller.getPlayersDefeat().size());
        assertEquals(2, controller.getPlayersInTurn().get(0).getLvl());
        assertEquals(2, controller.getPlayersInTurn().get(1).getLvl());

    }
    @Test
    public void testAddEnemy() {
        controller.setSeed(54321); // 0, 1, 2, 0
        controller.addEnemy(10, 10,30, 1);
        controller.addEnemy(15, 10,25, 1);
        controller.addEnemy(12, 20,18, 2);
        assertEquals(4, controller.getEnemiesInTurn().size());
        assertEquals(6, controller.getCharactersInTurn().size());
    }


}
