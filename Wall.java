/**
 * The Wall class contains the variable and methods of Wall objects
 */

import java.awt.Point;
import java.util.ArrayList;

public class Wall {

	// instance variables
	private int[][] walls;

	// constructor
	public Wall(int rows, int columns) {
		this.walls = new int[rows][columns];
		this.generateBorder(rows, columns);
		this.generateTestLevel();
	}


	/**
	 * Adds all the outer coordinates of the level into the instance variable location
	 * Requires the height and width of the level
	 * @param height the height of the level
	 * @param width the width of the level
	 */
	public void generateBorder(int rows, int columns) {
		walls[0][3] = 4;
		System.out.println(walls[0].toString());
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++ ) {
				if (((row == 0) || (row == rows-1)) || ((column == 0) || (column == columns-1))) {
					walls[row][column] = 1;
				}
			}
		}
	}

	public void generateTestLevel() {
		this.walls[0][1] = 0;
	}
	
	
	/**
	 * Getter for the point's location
	 * @return Arraylist of type Point
	 */
	public int[][] getWalls() {
		return this.walls;
	}













}
