import java.awt.Point;

public class GameWin extends Avatar {

	private Point winLocation;


	public GameWin() {
		winLocation = new Point(31, 2);
	}

	public GameWin(Point endPoint) {
		winLocation = new Point(endPoint);
	}

	public boolean isAtEndPoint(Avatar player) {
		boolean win = false;
		
		if (winLocation.getX() == player.getX() && winLocation.getY() == player.getY()) {
			win = true;
			System.out.println("WINNER");
			System.exit(0);
		}
		return win;
	}

	public double getX() {
                return winLocation.getX();
	}

	public double getY() {
                return winLocation.getY();
	}
}


