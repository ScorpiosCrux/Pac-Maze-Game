/**
 * The Avatar class contains the variables and methods of the avatar
 */
import java.awt.Point;

public class Avatar {
	
	/**
	 * The class contains two variables: location and score
	 */
	private Point location;     
	private int score;

	/**
	 * Default constructor for Avatar, no parameters.
	 */
	public Avatar() {
		location = new Point(1, 1); 	// the location of the avatar will start at point(1, 1) by default		
		score = 0;						// Remember that the grid starts at (0, 0) at the top right corner
			
	}

	/**
	 * Constructor for Avatar, given a starting location
	 * @param Point initialPoint
	 */
	public Avatar(Point initialPoint) {
		location = new Point(initialPoint);
		score = 0;
	}

	
	public boolean checkAndMove(char direction, int[][] wallList) {
		boolean nextMoveValid = false;
		// move up
		if (direction == 'w' && (wallList[location.y - 1][location.x] != 1) ) {
			wallList[location.y][location.x] = 0;
			wallList[location.y - 1][location.x] = 3;
			nextMoveValid = true;
			location.translate(0, -1);
		}
		// move down
		
		else if (direction == 's'  && (wallList[location.y + 1][location.x] != 1)) {
			wallList[location.y][location.x] = 0;
			wallList[location.y + 1][location.x] = 3;
			nextMoveValid = true;
			location.translate(0, 1);
		}
		// move left
		else if (direction == 'a' && (wallList[location.y][location.x - 1] != 1)) {
			wallList[location.y][location.x] = 0;
			wallList[location.y][location.x - 1] = 3;
			nextMoveValid = true;
			location.translate(-1, 0);
		}
		// move right
		else if (direction == 'd' && (wallList[location.y][location.x + 1] != 1)) {
			wallList[location.y][location.x] = 0;
			wallList[location.y][location.x + 1] = 3;
			nextMoveValid = true;
			location.translate(1, 0);
		}
		
		return nextMoveValid;
	}

	/**
	 * Adds the specified integer to score
	 * @param n the integer that the method will add to the score. n will only be added if it is bigger than 0
	 */
	public void addScore(int n) {
		if (n > 0)
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

	/**
	 * Returns the x-value of the point.
	 * @return the x-value of the point as a double.
	 */
	public double getX() {
		return location.getX();
	}
	
	/**
	 * Returns the y-value of the point.
	 * @return the y-value of the point as a double.
	 */
	public double getY() {
		return location.getY();
	}












}
