/**
 * The Avatar class contains the variables and methods of the avatar
 */

import java.awt.Point;

public class Avatar {
	
	/**
	 * The class contains two variables: location and score
	 */
	private Point location;         // the avatar will start at point(1, 1) by deafault
	private int score;

	// Remember that the grid starts at (0, 0) at the top right corner

	
	// constructor
	public Avatar() {
		location = new Point(1, 1);
		score = 0;	
			
	}

	public Avatar(Point p) {
		location = new Point(p);
		score = 0;
	}

	
	/**
	 * This method sees which key the user pressed, and will change the avatar location accordingly. 
	 * If an invalid key is pressed, the user will be notified.
	 * @param direction the key (in string form) that the user entered
	 */
	public void move(String direction) {
		// move up
		if (direction.equalsIgnoreCase("w")) {
			location.translate(0, -1);
		}
		// move down
		else if (direction.equalsIgnoreCase("s")) {
			location.translate(0, 1);
		}
		// move left
		else if (direction.equalsIgnoreCase("a")) {
			location.translate(-1, 0);
		}
		// move right
		else if (direction.equalsIgnoreCase("d")) {
			location.translate(1, 0);
		}
		// exit the program
		else if (direction.equalsIgnoreCase("e")) {
			System.exit(0);
		}
		// user entered invalid input
		else {
			System.out.println("invalid input");
		}
	}

	/**
	 * Adds the specified integer to score
	 * @param n the integer that the method will add to the score
	 */

	public void addScore(int n) {
		score += n;
	}


	/** 
	 * Returns location as coordinate in Point form
	 * @return the location of the Avatar object
	 */ 
	public Point getLocation() {
		return this.location;
	}


	/**
	 * Return score of Avatar object as int
	 * @return the score of the Avatar object as int
	 */
	public int getScore() {
		return this.score;
	}

	public double getX() {
		return location.getX();
	}

	public double getY() {
		return location.getY();
	}












}
