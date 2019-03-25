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

	private Player avatar;
	private GameBoard gameBoardGenerator;
	private int gameLevelNumber = 1;
	private int[][] wallList;
	
	public PacManMazeTextLogic() {

	this.avatar = new Player();
	this.gameBoardGenerator = new GameBoard(gameLevelNumber);  
	this.wallList = gameBoardGenerator.getCompleteGameBoard();
	wallList[1][1] = 3;
	
	
	
	
	displayGameBoard();
	
	gameLoop();

	
	
	}
	
	private void gameLoop() {
		char input = promptUserInput();
		System.out.println(input);
			
			
		
		while (input != 'e') {
			wallList = avatar.checkAndMove(input, wallList);
			
			
			
			displayGameBoard();
			System.out.println("Current Score: " + avatar.getScore());
			input = promptUserInput();
		}
	}
	
	public char promptUserInput() {
		System.out.println("Where to move?");
		Scanner keyboard = new Scanner(System.in);
		return keyboard.next().charAt(0);
	}
	
	
	public void displayGameBoard() {
		// turn wall points into rectangle and add them to pane
		Circle currentCircle = null;
		
		for (int row = 0; row < wallList.length; row++) {
			for (int column = 0; column < wallList[0].length; column++ ) {
				if (wallList[row][column] == 1)
					System.out.print(" #");
				else if (wallList[row][column] == 2) {
					System.out.print(" .");
				}
				else if (wallList[row][column] == 0){
					System.out.print("  ");
				}
				else if (wallList[row][column] == 3) {
					System.out.print(" C");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	

	public static void main(String[] argsv) {
		PacManMazeTextLogic textLogic = new PacManMazeTextLogic();
		
	}
	
	


	
	


}
