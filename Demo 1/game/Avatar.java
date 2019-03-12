import java.awt.Point;
/**
 * Using the Point class
 * Methods used so far:
 * translate
 */
public class Avatar {

	// instance variables

	private Point location = new Point(1, 1);         // the avatar will start at point(1, 1) by deafault
	private int score = 0;


	// methods
	// Remember that the grid starts at (0, 0) at the top right corner

	public void move(String direction) {

		// move up
		if (direction.equals("w")) {
			location.translate(0, -1);
		}
		// move down
		else if (direction.equals("s")) {
			location.translate(0, 1);
		}
		// move left
		else if (direction.equals("a")) {
			location.translate(-1, 0);
		}
		// move right
		else if (direction.equals("d")) {
			location.translate(1, 0);
		}
		else {
			System.out.println("invalid input");
		}
	}

	// add to score by specified number

	public void addScore(int n) {
		score += n;
	}


	// return location as coordinates
	public Point getLocation() {
		return this.location;
	}


	// return score as int
	public int getScore() {
		return this.score;
	}

	// Will undo a single move
	// Remember that the grid starts at (0, 0) at the top right corner
	public void reverseMove(String direction) {

		if (direction.equals("w")) {
			location.translate(0, 1);
		}

		else if (direction.equals("s")) {
			location.translate(0, -1);
		}

		else if (direction.equals("a")) {
			location.translate(1, 0);
		}

		else if (direction.equals("d")) {
			location.translate(-1, 0);
		}
	}














}
