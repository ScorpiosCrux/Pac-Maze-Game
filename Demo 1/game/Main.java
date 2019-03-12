import java.util.Scanner;
public class Main {

	// instance variables
	private Avatar avatar;
	private Pellet pellet;
	private Wall wall;

	public void initialize() {
		this.avatar = new Avatar();
		this.pellet = new Pellet();
		this.wall = new Wall();

		// generate walls and pellets
		// lets try a 12x12 world (measurement includes the walls)
		wall.generateWall(12, 12);
		pellet.generatePellet(12, 12);
	}

	// Takes user input and avatar is moved to specified location. If there is wall in new location, the
	// move is reversed
	public void getInputAndMove() {
		System.out.println("Where to move?");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		avatar.move(input);

		// check if avatar and wall location overlaps. If there is overlap, the move is reversed
		if (wall.overlapsWith(avatar)) {
			avatar.reverseMove(input);
			System.out.println("You have hit a wall");
		}
		else {
			System.out.println("You have moved");
		}
	}

	// checks if avatar location overlaps with a pellet location, then updates point and gets rid of that pellet
	public void updateScore() {
		if (pellet.overlapsWith(avatar)) {
			avatar.addScore(1);
			pellet.removePellet(avatar.getLocation());
			System.out.println("collected pellet");
		}
	}

	// displays the avatars location and score. getX() and getY() are methods from the Point class
	public void printCurrentState() {
		System.out.println("Location: " + avatar.getLocation().getX() + "," + avatar.getLocation().getY());
		System.out.println("Points: " + avatar.getScore());
	}


	// main method
	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
		while (true) {
			main.getInputAndMove();
			main.updateScore();
			main.printCurrentState();
		}
	}





}
