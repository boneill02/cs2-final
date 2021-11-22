package edu.wit.comp1050.cs2final;

/**
 * This class represents a checker's board. When initialized, it puts pieces in
 * the default starting positions.
 *
 * Player 1 will be on black squares (odd x values) and player 2 will be on red
 * white squares (even x values).
 *
 * @author Ben O'Neill
 */
public class Board {
    private Piece[][] board;

    public Board(Player p1, Player p2) {
        board = new Piece[8][8];

        /* init player 1's pieces */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j += 2) {
                board[i][j] = new Piece(p1);
            }
        }

        /* init player 2's pieces */
        for (int i = 5; i < 8; i++) {
            for (int j = 1; j < 8; j += 2) {
                board[i][j] = new Piece(p2);
            }
        }
    }

    /**
     * Get the Piece at the given point.
     * @param x x coordinate
     * @param y y coordinate
     * @return piece at (x,y)
     */
    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    /**
     * Checks whether the given square is occupied.
     * @param x x coordinate
     * @param y y coordinate
     * @return true if square is occupied.
     */
    public boolean spaceOccupied(int x, int y) {
        return board[x][y] != null;
    }

    /**
     * Move piece at (sx,sy) to (dx,dy). Return false if illegal move.
     * @param player the player that is moving the piece
     * @param sx start x
     * @param sy start y
     * @param dx destination x
     * @param dy destination y
     * @return true if moved, otherwise false
     */
    public boolean move(Player player, int sx, int sy, int dx, int dy) {
        Piece p = board[sx][sy];
        if (p == null) {
            /* piece doesn't exist */
            return false;
        }

        if (p.getOwner() != player) {
            /* piece does not belong to the player */
            return false;
        }

        /* TODO fix this to work for both sides. specify direction in Player? */
        if (!p.isKing() && dy < sy) {
            return false;
        }

        return true;
    }
}