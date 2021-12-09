package edu.wit.comp1050.cs2final;

/**
 * Base representation of a checkers player.
 *
 * @author Ben O'Neill
 */
public abstract class Player {
	protected Direction direction;

	/**
	 * Default constructor, choose Direction
	 * 
	 * @param direction
	 */
	public Player(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Get the current direction of the player
	 * 
	 * @return direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Do player turn
	 */
	public abstract void doTurn();
}
