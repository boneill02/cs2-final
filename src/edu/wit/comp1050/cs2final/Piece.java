package edu.wit.comp1050.cs2final;

import com.sun.prism.paint.Color;

/**
 * This class represents a Checkers piece.
 *
 * @author Ben O'Neill
 */
public class Piece {
    private Player owner;
    private boolean king;

    public Piece(Player owner) {
        this.owner = owner;
    }

    /**
     * Make the piece a King piece.
     */
    public void king() {
        king = true;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isKing() {
        return king;
    }


}
