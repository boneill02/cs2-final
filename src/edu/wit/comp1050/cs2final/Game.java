package edu.wit.comp1050.cs2final;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Checkers game mechanics.
 */
public class Game {
    private Board board;
    private Player p1, p2;
    private Button[][] boardButtons;

    private Button selected1, selected2;
    private Player currentPlayer;

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
                    boardButtons[i][j].setShape(new Circle(3));
                } else if (p.getOwner() == p2 && p.isKing()) {
                    boardButtons[i][j].setText("BK");
                } else if (p.getOwner() == p2 && !p.isKing()) {
                    boardButtons[i][j].setText("B");
                    boardButtons[i][j].setShape(new Circle(3));
                }
            }
        }
    }

    /**
     * Get x coordinate of button
     * @param b button
     * @return coordinate if exists, otherwise -1.
     */
    public int getX(Button b) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (boardButtons[i][j] == b) {
                    return i;
                }
            }
        }
        return -1;
    }

    /*
     * Get x coordinate of button
     * @param b button
     * @return coordinate if exists, otherwise -1.
     */
    public int getY(Button b) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (boardButtons[i][j] == b) {
                    return j;
                }
            }
        }
        return -1;
    }

    public void initButtons(GridPane pane) {
        boardButtons = new Button[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Button b = new Button();
                b.setShape(new Rectangle(90, 90));
                b.setOnAction(event -> {
                    if (selected1 == null) {
                        selected1 = b;
                    } else {
                        selected2 = b;
                        int sx = getX(selected1);
                        int sy = getY(selected1);
                        int dx = getX(selected2);
                        int dy = getY(selected2);
                        System.out.printf("moving (%d, %d) to (%d, %d)%n", sx, sy, dx, dy);
                        if (board.move(currentPlayer, getX(selected1), getY(selected1),  getX(selected2), getY(selected2))) {
                            if (currentPlayer == p1) {
                                currentPlayer = p2;
                            } else {
                                currentPlayer = p1;
                            }
                        }

                        selected1 = null;
                        selected2 = null;
                        displayPieces(board);
                    }

                });
                boardButtons[i][j] = b;
                pane.add(boardButtons[i][j], j, i);
            }
        }
    }

    /**
     * Start the game
     */
    public void start() {
        currentPlayer = p1;

        displayPieces(board);

    }

}
