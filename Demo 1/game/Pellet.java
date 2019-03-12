import java.util.ArrayList;
import java.awt.Point;
public class Pellet {


	// instance variables

	private ArrayList<Point> location = new ArrayList<Point>();


	// remove pellet
	public void removePellet(Point p) {
		this.location.remove(p);
	}

	// check if overlaps with avatar
	public boolean overlapsWith(Avatar avatar) {
		for (Point eachPoint : location) {
			if (eachPoint.equals(avatar.getLocation())) {
				return true;
			}
		}
		return false;
	}

	// will fill in level with pellets. Enter the dimensions of the level (including walls) first
	public void generatePellet(int h, int w) {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++ ) {
				if (((i != 0) && (i != w-1)) && ((j != 0) && (j != h-1))) {
					location.add(new Point(i, j));
				}
			}
		}
		// removes the pellet from avatar's starting point at (1, 1)
		location.remove(new Point(1, 1));
	}

















}
