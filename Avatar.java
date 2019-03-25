/**
 * The Avatar class contains the variables and methods of the avatar
 */
import java.awt.Point;

public class Player {
	
	/**
	 * The class contains two variables: location and score
	 */
	private Point location;     
	private int score;

	/**
	 * Default constructor for Avatar, no parameters.
	 */
	public Player() {
		location = new Point(1, 1); 	// the location of the avatar will start at point(1, 1) by default		
		score = 0;						// Remember that the grid starts at (0, 0) at the top right corner
			
	}

	/**
	 * Constructor for Avatar, given a starting location
	 * @param Point initialPoint
	 */
	public Player(Point initialPoint) {
		location = new Point(initialPoint);
		score = 0;
	}

	
	public int[][] checkAndMove(char direction, int[][] wallList) {
		// move up
		if (direction == 'w' && (wallList[location.y - 1][location.x] != 1) ) { //checks the future move
			wallList = checkAndPickPellet(wallList, location.y - 1, location.x);
			location.translate(0, -1);
		}
		// move down
		else if (direction == 's'  && (wallList[location.y + 1][location.x] != 1)) {
			wallList = checkAndPickPellet(wallList, location.y + 1, location.x);
			location.translate(0, 1);
		}
		// move left
		else if (direction == 'a' && (wallList[location.y][location.x - 1] != 1)) {
			checkAndPickPellet(wallList, location.y, location.x - 1);
			location.translate(-1, 0);
		}
		// move right
		else if (direction == 'd' && (wallList[location.y][location.x + 1] != 1)) {
			checkAndPickPellet(wallList, location.y, location.x + 1);
			location.translate(1, 0);
		}
		return wallList;
	}

	
	public int[][] checkAndPickPellet(int[][] wallList, int y, int x) {
		if (wallList[y][x] == 2) {
			this.addScore(10);
		}
		wallList[y][x] = 0;
		return wallList;
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
	public int getX() {
		return (int)location.getX();
	}
	
	/**
	 * Returns the y-value of the point.
	 * @return the y-value of the point as a double.
	 */
	public int getY() {
		return (int)location.getY();
	}












}
