/**
 * The Wall class contains the variable and methods of Wall objects
 */

import java.awt.Point;
import java.util.ArrayList;

public class Wall {

	// instance variables
	private ArrayList<Point> location = new ArrayList<Point>();

	// constructor
	public Wall(int height, int width) {
		this.generateWall(height, width);
	}


	/**
	 * Checks if an Avatar object location is the same as one of the points in the location ArrayList
	 * @param avatar the object of type Avatar whose location is checked
	 * @return a boolean that indicates whether there is overlapping of locations or not
	 */
	public boolean overlapsWith(Avatar avatar) {
		for (Point eachPoint : location) {
			if (eachPoint.equals(avatar.getLocation())) {
				return true;
            }
        }
        return false;
	}

	/**
	 * Adds all the outer coordinates of the level into the instance variable location
	 * Requires the height and width of the level
	 * @param height the height of the level
	 * @param width the width of the level
	 */
	public void generateWall(int height, int width) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++ ) {
				if (((i == 0) || (i == width-1)) || ((j == 0) || (j == height-1))) {
					location.add(new Point(i, j));
				}
			}
		}
	}

	
	/**
	 * Getter for the point's location
	 * @return Arraylist of type Point
	 */
	public ArrayList<Point> getLocation() {
		return this.location;
	}




















}
