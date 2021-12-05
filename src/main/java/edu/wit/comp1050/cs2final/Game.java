package edu.wit.comp1050.cs2final;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

/**
 * Checkers game mechanics.
 */
public class Game {
    Board board;
    Player p1, p2;
    Button[][] boardButtons;

    public Game() {
        p1 = new HumanPlayer(Direction.UP);
        p2 = new HumanPlayer(Direction.DOWN);
        Board b = new Board(p1, p2);
    }

    /**
     * Initialize the game.
     * @param board checkers board
     * @param player1 player 1
     * @param player2 player 2
     */
    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.p1 = player1;
        this.p2 = player2;
    }

    public void displayPieces(Board b) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = b.getPiece(i, j);
                if (p == null)
                    continue;

                if (p.getOwner() == p1 && p.isKing()) {
                    boardButtons[i][j].setText("WK");
                } else if (p.getOwner() == p1 && !p.isKing()) {
                    boardButtons[i][j].setText("W");
                } else if (p.getOwner() == p2 && p.isKing()) {
                    boardButtons[i][j].setText("BK");
                } else if (p.getOwner() == p2 && !p.isKing()) {
                    boardButtons[i][j].setText("B");
                }
            }
        }
    }

    public void initButtons(GridPane pane) {
        boardButtons = new Button[8][8];
        for ( int r = 0; r < 8; r++) {
            for ( int c = 0; c < 8; c++) {
                int number = 8 * c + r;
                boardButtons[r][c] = new Button (String.valueOf((number)));
                boardButtons[r][c].setShape( new Rectangle(90, 90));
                pane.add(boardButtons[r][c], r, c);
            }
        }
    }

    /**
     * Start the game
     */
    public void start() {
        boolean running = true;

        /* TODO implement Player.doTurn() */
        /*
        while (running) {
            p1.doTurn();
            p2.doTurn();
        }
         */
    }

}
