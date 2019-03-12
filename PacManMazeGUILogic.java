import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle; 
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.Node;
import java.util.Scanner;
import javafx.geometry.Pos;
import java.awt.Point;
import java.util.ArrayList;


public class PacManMazeGUILogic extends Application{

	/***
	 * Instance variables
	 */
	private Avatar avatar;
	private Wall wall;	
	private Pellet pellet;

	private int[][] wallList;
	private ArrayList<Point> pelletList;
	private Circle[][] pelletCircleList; //keeps the IDs of the pellets
	Rectangle avatarRectangle;
	
	private Pane layout;

	/**
	 * Start method that creates the GUI
	 */
	@Override
	public void start(Stage primaryStage) {
		int playerXLocation = 1;
		int playerYLocation = 1;
		
		int gameWidth = 30;
		int gameHeight = 50;

		// initialize all the variables and create helper variables
		avatar = new Avatar();
		wall = new Wall(gameWidth, gameHeight);
		wallList = wall.getWalls();
		pellet = new Pellet(this.wallList);	
		pelletList = pellet.getLocation();
		pelletCircleList = new Circle[gameWidth][gameHeight];

		// set title  and create pane layout
		primaryStage.setTitle("PacManMaze");
		layout = new Pane();


		createAvatar();
		
		displayWallsAndPellets();
		



		//Create new scene, add the pane to scene, add the scene to stage
		Scene scene = new Scene(layout, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();		

		// show the stage
		primaryStage.show();
		
		// handle keyboard input
		scene.setOnKeyPressed(event -> {
			// get the key entered
			String input = event.getText();	
			
				
			if (avatar.checkAndMove(input, wallList)) {
				avatarRectangle.setX(avatar.getX() * 10);
				avatarRectangle.setY(avatar.getY() * 10);
				if (wallList[(int) avatar.getY()][(int) avatar.getX()] == 2) {
					layout.getChildren().remove(pelletCircleList[(int) avatar.getY()][(int) avatar.getX()]);
				}
			}
			
				
		
		});
	
		
		
	}
	

	public void displayWallsAndPellets() {
		// turn wall points into rectangle and add them to pane
		int scale = 10;
		int width_rectangle = 10;
		int height_rectangle = 10;
		Circle currentCircle = null;
		
		for (int row = 0; row < wallList.length; row++) {
			for (int column = 0; column < wallList[0].length; column++ ) {
				if (wallList[row][column] == 1)
					layout.getChildren().add(new Rectangle(column*scale, row*scale, width_rectangle, height_rectangle));
				else if (wallList[row][column] == 2) {
					currentCircle = new Circle(column*scale + 5, row*scale +  5, 1, Color.GREEN);
					layout.getChildren().add(currentCircle);
					pelletCircleList[row][column] = currentCircle;
				}
			}
		}
	}
	
	
	public void createAvatar() {
		this.avatarRectangle = new Rectangle(avatar.getY() * 10, avatar.getX() * 10, 10, 10);
		avatarRectangle.setFill(Color.RED);
		layout.getChildren().add(avatarRectangle);
	}
	














}
