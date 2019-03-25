/**
 * The Pellet class contains the variables and methods of Pellet objects
 * By pellet, we mean the white dots that pacman collects in the original game. 
 */

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

import java.awt.Point;

public class Pellet {
	// instance variables
	private ArrayList<Point> location = new ArrayList<Point>();

	/**
	 * Generates the pellets
	 * @param height of the map
	 * @param width of the map
	 */
	public Pellet(int[][] gameBoard) {
		this.generatePellet(gameBoard);			
	}

	/**
	 * Checks if one of the Pellet locations overlaps with Avatar location
	 * @param avatar the Avatar object whose location will be checked for overlapping
	 * @return a boolean that states whether there is overlapping or not
	 */
	public boolean overlapsWith(Player avatar) {
		for (Point eachPoint : location) {
			if (eachPoint.equals(avatar.getLocation())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds all the the non-wall and non-avatar coordinates of the level into the location ArrayList.
	 * Requires the height and width of the level. 
	 * @param height the height of the level
	 * @param width the width of the level
	 */
	public int[][] generatePellet(int[][] gameBoard) {
		for (int row = 0; row < gameBoard.length; row++) {
			for (int column = 0; column < gameBoard[0].length; column++ ) {
				if (gameBoard[row][column] != 1)
					gameBoard[row][column] = 2;
			}
		}
		return gameBoard;
	}



	/** 
	 * Removes a single pellet from the location ArrayList
	 * @param p the point that will be removed from the location ArrayList
	 */
	public void removePellet(Point p) {
		this.location.remove(p);
	}












}
