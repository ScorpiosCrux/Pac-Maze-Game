/**
 * The Avatar class contains the variables and methods of the avatar
 */
import java.awt.Point;
import java.util.Random;


public class Ghost extends Avatar {

	private Point ghostLocation;
	private int xLoc;
	private int yLoc;

	
	public Ghost() {
		Random rand = new Random();
		xLoc = rand.nextInt(30);
		yLoc = rand.nextInt(30);
		ghostLocation = new Point(xLoc, yLoc);
	}

	public Ghost(Point startPoint) {
		ghostLocation = new Point(startPoint);
	}
	
	public boolean collisionWithPlayer(Avatar player) {
		boolean collision = false;
		
		if (ghostLocation.getX() == player.getX() && ghostLocation.getY() == player.getY()) {				collision = true;
			System.out.println("GAME OVER!");
			System.exit(0);
		
		}
		return collision;
	}
	

	public boolean checkAndMove(String direction) {
		boolean nextMove = true;
		if (direction.equalsIgnoreCase("w")) {
			ghostLocation.translate(0, 2);
		}
		if (direction.equalsIgnoreCase("d")) {
			ghostLocation.translate(-2, 0);
		}
		if (direction.equalsIgnoreCase("s")) {
			ghostLocation.translate(0, -2);
		}
		if (direction.equalsIgnoreCase("a")) {
			ghostLocation.translate(2, 0);
		}
		return nextMove;

	}
	
	public Point getLocation() {
		return this.ghostLocation;
	}

	public double getX() {
		return ghostLocation.getX();
	}

	public double getY() {
		return ghostLocation.getY();
	}









}
