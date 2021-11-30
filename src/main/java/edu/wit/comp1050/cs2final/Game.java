package edu.wit.comp1050.cs2final;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

/**
 * Checkers game mechanics.
 */
public class Game {
    Board board;
    Player player1, player2;


    /**
     * Initialize the game.
     * @param board checkers board
     * @param player1 player 1
     * @param player2 player 2
     */
    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Start the game
     */
    public void start() {
        boolean running = true;

        while (running) {
            player1.doTurn();
            player2.doTurn();
        }
    }

}
