package edu.wit.comp1050.cs2final;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Checkers game mechanics.
 * 
 * @author Ben O'Neill, Yogi Patel
 * 
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
	 * 
	 * @param board   checkers board
	 * @param player1 player 1
	 * @param player2 player 2
	 */
	public Game(Board board, Player player1, Player player2) {
		this.board = board;
		this.p1 = player1;
		this.p2 = player2;
	}

	public void displayPieces(Board b) {

		int countWhite = 0;
		int countBlack = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				Piece p = b.getPiece(i, j);

				// Make King when it reaches to the other side
				if (i == 0 && p != null && p.getOwner() == p1) {
					p.king();
				}

				if (i == 7 && p != null && p.getOwner() == p2) {
					p.king();
				}

				if (p == null) {
					boardButtons[i][j].setText("X");
					boardButtons[i][j].setPrefSize(40, 40);
					boardButtons[i][j].setTextFill(Color.BLACK);

					// set piece/button visibility to false for unwanted pieces
					if (i % 2 != 1 && j % 2 != 1) {
						boardButtons[i][j].setVisible(false);
					}

					if (i % 2 == 1 && j % 2 != 0) {
						boardButtons[i][j].setVisible(false);
					}

				}

				else if (p.getOwner() == p1 && p.isKing()) {
					boardButtons[i][j].setText("WK");
					boardButtons[i][j].setShape(new Circle(3));
					boardButtons[i][j].setPrefSize(40, 40);
					boardButtons[i][j].setTextFill(Color.BLUE);
					countWhite++;
				}

				else if (p.getOwner() == p1 && !p.isKing()) {
					boardButtons[i][j].setText("W");
					boardButtons[i][j].setShape(new Circle(3));
					boardButtons[i][j].setPrefSize(40, 40);
					boardButtons[i][j].setTextFill(Color.BLUE);
					countWhite++;
				}

				else if (p.getOwner() == p2 && p.isKing()) {
					boardButtons[i][j].setText("BK");
					boardButtons[i][j].setShape(new Circle(3));
					boardButtons[i][j].setPrefSize(40, 40);
					boardButtons[i][j].setTextFill(Color.RED);
					countBlack++;
				}

				else if (p.getOwner() == p2 && !p.isKing()) {
					boardButtons[i][j].setText("B");
					boardButtons[i][j].setShape(new Circle(3));
					boardButtons[i][j].setPrefSize(40, 40);
					boardButtons[i][j].setTextFill(Color.RED);
					countBlack++;
				}
			}
		}

		System.out.printf("White Pieces left; %d%n", countWhite);
		System.out.printf("Black Pieces left; %d%n%n", countBlack);
		if (countWhite == 0) {
			System.out.print("Black Wins !!! ");
			System.exit(0);
		}
		if (countBlack == 0) {
			System.out.print("White Wins !!! ");
			System.exit(0);
		}
	}

	/**
	 * Get x coordinate of button
	 * 
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
	 * 
	 * @param b button
	 * 
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

	/**
	 * Initialize buttons in GridPane, including adding EventHandlers for piece
	 * movement.
	 * 
	 * @param pane GridPane to display on
	 */
	public void initButtons(GridPane pane) {
		boardButtons = new Button[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Button b = new Button();
				b.setShape(new Circle(3));
				b.setTextFill(Color.BLACK);
				b.setPrefSize(40, 40);

				/* initialize button event handler for piece movement */
				b.setOnAction(event -> {
					if (selected1 == null) { // no start piece is selected
						selected1 = b;
					} else { // start piece is selected

						/* get start and destination coordinates */
						selected2 = b;
						int sx = getX(selected1);
						int sy = getY(selected1);
						int dx = getX(selected2);
						int dy = getY(selected2);

						/* try to execute move */
						System.out.printf("moving (%d, %d) to (%d, %d)%n", sx, sy, dx, dy);
						if (board.move(currentPlayer, getX(selected1), getY(selected1), getX(selected2),
								getY(selected2))) {
							if (currentPlayer == p1) {
								currentPlayer = p2;
							} else {
								currentPlayer = p1;
							}
						}

						/* reset and display results */
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
