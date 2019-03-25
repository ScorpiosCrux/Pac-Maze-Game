/**
 * The main method is where all the other classes are used to create a game
 */

import java.util.Scanner;

public class PacManMazeTextLogic {

	//Instance Variables
	private Avatar avatar;
	private Pellet pellet;
	private Wall wall;
	private int[][] gameBoard;

	private static final int HEIGHT = 50;
	private static final int WIDTH = 50;

	/**
	 * Creates new objects of type Avatar, Pellet and Wall for the avatar, pellet, and wall variables
	 * Prompts the user for the dimensions of the level, then uses that to generate the walls and pellets
	 * Notifies the user about the controls
	 * Prints out the initial location and point of the avatar
	 */
	public void initialize() {
		this.avatar = new Avatar();
		this.wall = new Wall(HEIGHT, WIDTH);
		this.gameBoard = wall.getWalls();
		this.pellet = new Pellet(wall.getWalls());
		this.gameBoard = pellet.generatePellet(gameBoard);

		// notifies the user about the controls
		System.out.println("\nGame controls:");
		System.out.println("w --> move up, s --> move down, a --> move left, d --> move right");
		System.out.println("e --> exit the game");
		
		// display the initial score and location
		System.out.println("\nAvatar location: " + avatar.getLocation().getX() + "," + avatar.getLocation().getY());
                System.out.println("Points: " + avatar.getScore());
	}

	/** 
	 * Takes user input and avatar is moved to specified location. 
	 * If there is wall in new location, the move is reversed.
	 */
	public void getInputAndMove() {
		System.out.println("Where to move?");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		
		
		Avatar testAvatar = new Avatar(avatar.getLocation());
		testAvatar.checkAndMove(input, gameBoard);
		
		
		
	}

	/**
	 * Checks if the avatar location overlaps with a pellet location, then updates point and gets rid of that pellet
	 */
	public void updateScore() {
		if (pellet.overlapsWith(avatar)) {
			avatar.addScore(1);
			pellet.removePellet(avatar.getLocation());
			System.out.println("collected pellet");
		}
	}

	/** 
	 * Displays the avatar location and score.
	 */ 
	public void printCurrentState() {
		//getX() and getY() are methods from the Point class
		System.out.println("Avatar location: " + avatar.getLocation().getX() + "," + avatar.getLocation().getY());
		System.out.println("Points: " + avatar.getScore());
	}






}
