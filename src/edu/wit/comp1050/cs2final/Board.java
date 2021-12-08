package edu.wit.comp1050.cs2final;

import com.sun.prism.paint.Color;

/**
 * This class represents a checker's board. When initialized, it puts pieces in
 * the default starting positions.
 *
 * Player 1 will be on black squares (odd x values) and player 2 will be on red
 * white squares (even x values).
 *
 * @author Ben O'Neill, Yogi Patel
 */
public class Board {
    private Piece[][] board;

    public Board(Player p1, Player p2) {
        board = new Piece[8][8];

        /* init player 1's pieces */
        for (int i = 5; i < 8; i++) {
            for (int j = (i % 2 == 1) ? 0 : 1; j < 8; j += 2) {
                board[i][j] = new Piece(p1);
               
            }
        }

        /* init player 2's pieces */
        for (int i = 0; i < 3; i++) {
            for (int j = (i % 2 == 1) ? 0 : 1; j < 8; j += 2) {
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
            System.out.printf("illegal move: piece doesn't exist%n");
            return false;
        } else if (dy == sy || dx == sx || Math.abs(dy - sy) != Math.abs(dx - sx)) {
            /* moving straight up or straight down */
            System.out.printf("illegal move: not moving diagonally%n");
            return false;
        } else if (p.getOwner() != player) {
            /* piece does not belong to the player */
            System.out.printf("illegal move: piece doesn't belong to player%n");
            return false;
        } else if (spaceOccupied(dx, dy)) {
            /* space is occupied */
            System.out.printf("illegal move: destination cell is occupied%n");
            return false;
        } else if (!p.isKing() && p.getOwner().getDirection() == Direction.UP && dx > sx) {
            /* wrong direction */
            System.out.printf("illegal move: wrong direction%n");
            return false;
        } else if (!p.isKing() && p.getOwner().getDirection() == Direction.DOWN && dx < sx) {
            /* wrong direction */
            System.out.printf("illegal move: wrong direction%n");
            return false;
        }
       
        else if (!spaceOccupied(dx, dy) && Math.abs(dx-sx) == 1) {	
        board[dx][dy] = p;
        board[sx][sy] = null;
        System.out.printf("legal move%n");
        return true;
        
        }
        
        
        // Remove piece taken
        
        else if (!spaceOccupied(dx,dy) && Math.abs(dx-sx) == 2) {
        	 int tempX;
             int tempY;
             
             if (dx > sx) {
             	
             	tempX = sx +1 ; 
             }
             else {
             	tempX = sx - 1 ;
             }
             
             if ( dy > sy ) {
             	tempY = sy + 1 ; 
             	
             }
             
             else {
             	tempY = sy - 1 ;
             }
             board[dx][dy] = p ;
             take(sx, sy );
             take(tempX, tempY);
             System.out.printf("legal take%n");
             return true; 
        }
        return false;
    }

    /**
     * Capture a piece (piece is just removed from the board for now).
     * @param x x-coordinate of piece on the board
     * @param y y-coordinate of piece on the board
     */
    public void take(int x, int y) {
        board[x][y] = null;
    }
}
