 /**
 * The Avatar class contains the variables and methods of the avatar
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Ghost extends Avatar{
	
	private static ArrayList<String> randomMove = new ArrayList<String>();
	static{
	
	randomMove.add("w");
	randomMove.add("a");
	randomMove.add("s");
	randomMove.add("d");
	}
	
	
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
	
	public static String pickMove(ArrayList<String> randomMove){
		Random r = new Random();
		//System.out.println(r);
		int randomNum = r.nextInt((3-0) + 1);
		return(randomMove.get(randomNum));	
	}
	
	
	public static void main(String[] args){

		
;
	}












}
