package edu.wit.comp1050.cs2final;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

/**
 * Checkers game mechanics.
 */
public class Game {
    private Board board;
    private Player p1, p2;
    private Button[][] boardButtons;

    public Game() {
        p1 = new HumanPlayer(Direction.UP);
        p2 = new HumanPlayer(Direction.DOWN);
        board = new Board(p1, p2);
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
                if (p == null) {
                    boardButtons[i][j].setText("X");
                } else if (p.getOwner() == p1 && p.isKing()) {
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
        for ( int i = 0; i < 8; i++) {
            for ( int j = 0; j < 8; j++) {
                boardButtons[i][j] = new Button();
                boardButtons[i][j].setShape(new Rectangle(90, 90));
                pane.add(boardButtons[i][j], j, i);
            }
        }
    }

    /**
     * Start the game
     */
    public void start() {
        boolean running = true;

        displayPieces(board);

        /* TODO implement Player.doTurn() */
        /*
        while (running) {
            p1.doTurn();
            p2.doTurn();
        }
         */
    }

}
