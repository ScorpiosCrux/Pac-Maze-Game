import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	
	private final int rectangleScale = 10;
	
	
	private Avatar avatar;
	private Ghost ghost1;
	private Wall wall;	
	private Pellet pellet;

	private int[][] wallList;
	private Circle[][] pelletCircleList; //keeps the IDs of the pellets
	private Rectangle avatarRectangle;
	private Rectangle ghostRectangle;
	
	private Pane layout;

	/**
	 * Start method that creates the GUI
	 */
	@Override
	public void start(Stage primaryStage) {
		int gameWidth = 30;
		int gameHeight = 50;

		// initialize all the variables and create helper variables

		
		wall = new Wall(gameWidth, gameHeight);
		wallList = wall.getWalls();
		pellet = new Pellet(this.wallList);	
		pelletCircleList = new Circle[wallList.length][wallList[0].length];

		// set title  and create pane layout
		primaryStage.setTitle("PacManMaze");
		layout = new Pane();
		
		
		


		createAvatar();
		createGhost();
		
		displayWallsAndPellets();
		
		Label scoreCounterlbl = new Label("Score: " + avatar.getScore());
		scoreCounterlbl.setLayoutX(350);
		scoreCounterlbl.setLayoutY(350);
		layout.getChildren().add(scoreCounterlbl);
		



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
			
			if (event.getCode() == KeyCode.ESCAPE) {
				System.exit(0);
			}
			
			if (ghost1.collisionWithPlayer(avatar) == false)	{
				if (avatar.checkAndMove(input, wallList)) {
					avatarRectangle.setX(avatar.getX() * 10);
					avatarRectangle.setY(avatar.getY() * 10);
					if (wallList[(int) avatar.getY()][(int) avatar.getX()] == 2) {
						avatar.addScore(10);
						wallList[(int) avatar.getY()][(int) avatar.getX()] = 0;
						layout.getChildren().remove(pelletCircleList[(int) avatar.getY()][(int) avatar.getX()]);
						scoreCounterlbl.setText("Score: " + avatar.getScore());
					}
				}
			}
				
		
		});
	
		
		
	}
	

	public void displayWallsAndPellets() {
		// turn wall points into rectangle and add them to pane
		int scale = rectangleScale;
		int width_rectangle = rectangleScale;
		int height_rectangle = rectangleScale;
		Circle currentCircle = null;
		
		for (int row = 0; row < wallList.length; row++) {
			for (int column = 0; column < wallList[0].length; column++ ) {
				if (wallList[row][column] == 1)
					layout.getChildren().add(new Rectangle(column*scale, row*scale, width_rectangle, height_rectangle));
				else if (wallList[row][column] == 2) {
					currentCircle = new Circle(column*scale + rectangleScale / 2, row*scale +  rectangleScale/ 2, rectangleScale/10, Color.GREEN);
					layout.getChildren().add(currentCircle);
					pelletCircleList[row][column] = currentCircle;
				}
			}
		}
	}
	
	
	public void createAvatar() {
		this.avatar = new Avatar();
		this.avatarRectangle = new Rectangle(avatar.getY() * rectangleScale, avatar.getX() * rectangleScale, rectangleScale, rectangleScale);
		avatarRectangle.setFill(Color.RED);
		layout.getChildren().add(avatarRectangle);
	}
	
	public void createGhost() {
		this.ghost1 = new Ghost();
		this.ghostRectangle = new Rectangle(ghost1.getY() * rectangleScale, ghost1.getX() * rectangleScale, rectangleScale, rectangleScale);
		ghostRectangle.setFill(Color.ORANGE);
		layout.getChildren().add(ghostRectangle);
	}
	














}
