/**
 * The Pellet class contains the variables and methods of Pellet objects
 * By pellet, we mean the white dots that pacman collects in the original game. 
 */

import java.util.ArrayList;
import java.awt.Point;

public class Pellet {


	// instance variables
	private ArrayList<Point> location = new ArrayList<Point>();

	
	// constructors
	public Pellet(int height, int width) {
		this.generatePellet(height, width);			
	}

	

	/**
	 * Checks if one of the Pellet locations overlaps with Avatar location
	 * @param avatar the Avatar object whose location will be checked for overlapping
	 * @return a boolean that states whether there is overlapping or not
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
	 * Adds all the the non-wall and non-avatar coordinates of the level into the location ArrayList.
	 * Requires the height and width of the level. 
	 * @param height the height of the level
	 * @param width the width of the level
	 */
	public void generatePellet(int height, int width) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++ ) {
				if (((i != 0) && (i != width-1)) && ((j != 0) && (j != height-1))) {
					location.add(new Point(i, j));
				}
			}
		}
		// removes the pellet from avatar's starting point at (1, 1)
		location.remove(new Point(1, 1));
	}



	/** 
	 * Removes a single pellet from the location ArrayList
	 * @param p the point that will be removed from the location ArrayList
	 */
	public void removePellet(Point p) {
		this.location.remove(p);
	}



	public ArrayList<Point> getLocation() {
		return this.location;
	} 









}
