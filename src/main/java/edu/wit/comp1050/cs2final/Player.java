package edu.wit.comp1050.cs2final;

/**
 * Base representation of a checkers player.
 *
 * @author Ben O'Neill
 */
public abstract class Player {
    protected Direction direction;

    public Player(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * Do player turn
     */
    public abstract void doTurn();
}
