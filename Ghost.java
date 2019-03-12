/**
 * The Avatar class contains the variables and methods of the avatar
 */
import java.awt.Point;

public class Ghost extends Avatar{
	
	public Ghost() {
		super(new Point(20, 20));
	}
	
	public boolean collisionWithPlayer(Avatar player) {
		boolean collision = false;
		
		if (super.getX() == player.getX() && super.getY() == player.getY()) {
			collision = true;
			System.out.println("GAME OVER!");
		}
			
		return collision;
		
	}












}
