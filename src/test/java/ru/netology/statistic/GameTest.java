package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void whenPlayerOneWin() {

        Player victor = new Player(2, "Victor", 15);
        Player igor = new Player(1, "Igor", 12);
        Game game = new Game();

        game.register(victor);
        game.register(igor);
        int actual = game.round("Victor", "Igor");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenPlayerTwoWin() {

        Player victor = new Player(2, "Victor", 15);
        Player igor = new Player(1, "Igor", 12);
        Game game = new Game();

        game.register(victor);
        game.register(igor);
        int actual = game.round("Igor", "Victor");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenPlayerDraw() {

        Player victor = new Player(2, "Victor", 15);
        Player igor = new Player(1, "Igor", 15);
        Game game = new Game();

        game.register(victor);
        game.register(igor);
        int actual = game.round("Igor", "Victor");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenPlayerOneNoteRegistered() {

        Player victor = new Player(2, "Victor", 15);
        Player igor = new Player(1, "Igor", 5);
        Game game = new Game();

        game.register(victor);
        game.register(igor);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Kirill", "Igor")
        );


    }
    @Test
    public void whenPlayerTwoNoteRegistered() {

        Player victor = new Player(2, "Victor", 15);
        Player igor = new Player(1, "Igor", 15);
        Game game = new Game();


        game.register(victor);
        game.register(igor);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Victor", "Kirill")
        );


    }
    @Test
    public void testIdPlayer(){
        Player igor = new Player(1, "Igor", 15);
        igor.getId();

        int expected = 1;
        int actual =igor.getId();
        Assertions.assertEquals(expected,actual);
    }

}
