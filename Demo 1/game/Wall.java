import java.awt.Point;
import java.util.ArrayList;
public class Wall {

	private ArrayList<Point> location = new ArrayList<Point>();


	public boolean overlapsWith(Avatar avatar) {
		for (Point eachPoint : location) {
                        if (eachPoint.equals(avatar.getLocation())) {
                                return true;
                        }
                }
                return false;
	}


	public void generateWall(int h, int w) {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++ ) {
				if (((i == 0) || (i == w-1)) || ((j == 0) || (j == h-1))) {
					location.add(new Point(i, j));
				}
			}
		}
	}























}
