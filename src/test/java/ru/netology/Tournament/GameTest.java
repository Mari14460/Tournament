package ru.netology.Tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();
    Player player = new Player(1000, "Marina", 100);
    Player player1 = new Player(1001, "Sergey", 1000);
    Player player2 = new Player(1002, "Petr", 10);
    Player player3 = new Player(1003, "Kolia", 10);

    @BeforeEach
    public void setup () {
        game.register(player);
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    void shouldWin() {
        int expected = 1;
        int actual = game.round("Sergey", "Marina");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldLose() {
        int expected = 2;
        int actual = game.round("Petr", "Marina");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldTie() {
        int expected = 0;
        int actual = game.round("Petr", "Kolia");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldTrowException1() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Anatoliy", "Marina");
        });
    }

    @Test
    void shouldTrowException2() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Marina", "Sema");
        });
    }
}
