/**
 * The main method is where all the other classes are used to create a game
 */

import java.util.Scanner;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PacManMazeTextLogic {

	//Instance Variables

	private Avatar avatar;
	private Ghost ghost1;
	private Ghost ghost2;
	private Ghost ghost3;
	private Ghost ghost4;
	private Wall wall;
	private Pellet pellet;
	private GameWin gameWin;

	private int[][] wallList;
	
	public PacManMazeTextLogic() {

	wall = new Wall();
	wallList = wall.getWalls();
	pellet = new Pellet(this.wallList);	
	
	
	
	
	displayWallsAndPellets();
	
	gameLoop();

	
	
	}
	
	private void gameLoop() {
		String input = promptUserInput();
		System.out.println(input);
			
			
		
		if (input == "e") {
			System.out.println("boop");
			System.exit(0);
		}else if (avatar.checkAndMove(input, wallList)) {
			if (wallList[(int) avatar.getY()][(int) avatar.getX()] == 2) {
				avatar.addScore(10);
				wallList[(int) avatar.getY()][(int) avatar.getX()] = 0;
				
			}
			
			// check if player and ghost collide
			ghost1.overlapsWith(avatar);
			ghost2.overlapsWith(avatar);
			ghost3.overlapsWith(avatar);
			ghost4.overlapsWith(avatar);
			// check if player reaches endpoint
			gameWin.isAtEndPoint(avatar);	

		}
	}
	
	public String promptUserInput() {
		System.out.println("Where to move?");
		Scanner keyboard = new Scanner(System.in);
		return keyboard.nextLine();
	}
	
	
	public void displayWallsAndPellets() {
		// turn wall points into rectangle and add them to pane
		Circle currentCircle = null;
		
		for (int row = 0; row < wallList.length; row++) {
			for (int column = 0; column < wallList[0].length; column++ ) {
				if (wallList[row][column] == 1)
					System.out.print(" #");
				else if (wallList[row][column] == 2) {
					System.out.print(" .");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	

	public static void main(String[] argsv) {
		PacManMazeTextLogic textLogic = new PacManMazeTextLogic();
		textLogic.displayWallsAndPellets();
		
	}


	
	


}
