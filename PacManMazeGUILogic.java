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

import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Animation;


public class PacManMazeGUILogic extends Application{

	/***
	 * Instance variables
	 */
	
	private final int rectangleScale = 20;
	
	
	private Avatar avatar;
	private Ghost ghost1;
	private Ghost ghost2;
	private Ghost ghost3;
	private Ghost ghost4;
	private Wall wall;
	private Pellet pellet;
	private GameWin gameWin;

	private int[][] wallList;
	private Circle[][] pelletCircleList; //keeps the IDs of the pellets
	private Circle avatarCircle;
	private Rectangle ghost1Rectangle;
	private Rectangle ghost2Rectangle;
	private Rectangle ghost3Rectangle;
	private Rectangle ghost4Rectangle;
	private Rectangle gameWinRectangle;
	
	private Pane layout;

	/**
	 * Start method that creates the GUI
	 */
	@Override
	public void start(Stage primaryStage) {
		int gameWidth = 32;
		int gameHeight = 32;

		// initialize all the variables and create helper variables


		wall = new Wall(gameWidth, gameHeight);
		wallList = wall.getWalls();
		pellet = new Pellet(this.wallList);	
		pelletCircleList = new Circle[wallList.length][wallList[0].length];

		// set title  and create pane layout
		primaryStage.setTitle("PacManMaze");
		layout = new Pane();
		
		displayWallsAndPellets();
		createAvatar();
		createGhost1();		
		createGhost2();
		createGhost3();
		createGhost4();		
		createGameWin();
				
		
		
		Label scoreCounterlbl = new Label("Score: " + avatar.getScore());
		scoreCounterlbl.setTextFill(Color.WHITE);
		scoreCounterlbl.setLayoutX(avatar.getX());
		scoreCounterlbl.setLayoutY(avatar.getY());
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
			
			if (avatar.checkAndMove(input, wallList)) {
				avatarCircle.setCenterX((avatar.getX() * rectangleScale) + (rectangleScale/2));
				avatarCircle.setCenterY((avatar.getY() * rectangleScale) + (rectangleScale/2));
				if (wallList[(int) avatar.getY()][(int) avatar.getX()] == 2) {
					avatar.addScore(10);
					wallList[(int) avatar.getY()][(int) avatar.getX()] = 0;
					layout.getChildren().remove(pelletCircleList[(int) avatar.getY()][(int) avatar.getX()]);
					scoreCounterlbl.setText("Score: " + avatar.getScore());
				}
				// check if player and ghost collide
				ghost1.overlapsWith(avatar);
				ghost2.overlapsWith(avatar);
				ghost3.overlapsWith(avatar);
				ghost4.overlapsWith(avatar);
				// check if player reaches endpoint
				gameWin.isAtEndPoint(avatar);	

			}
			
		});



		// implement the ghost animation

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), event -> {
			// make the ghost move
                        ghost1.move(ghost1.pickMove(this.wallList, this.avatar));
                        ghost1Rectangle.setX(ghost1.getX() * rectangleScale);
                        ghost1Rectangle.setY(ghost1.getY() * rectangleScale);
                        // check again if player and ghost collides
                        ghost1.overlapsWith(avatar);
			
			ghost2.move(ghost2.pickMove(this.wallList, this.avatar));
                        ghost2Rectangle.setX(ghost2.getX() * rectangleScale);
                        ghost2Rectangle.setY(ghost2.getY() * rectangleScale);
                        // check again if player and ghost collides
                        ghost2.overlapsWith(avatar);


			ghost3.move(ghost3.pickMove(this.wallList, this.avatar));
                        ghost3Rectangle.setX(ghost3.getX() * rectangleScale);
                        ghost3Rectangle.setY(ghost3.getY() * rectangleScale);
                        // check again if player and ghost collides
                        ghost3.overlapsWith(avatar);

			ghost4.move(ghost4.pickMove(this.wallList, this.avatar));
                        ghost4Rectangle.setX(ghost4.getX() * rectangleScale);
                        ghost4Rectangle.setY(ghost4.getY() * rectangleScale);
                        // check again if player and ghost collides
                        ghost4.overlapsWith(avatar);



			
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
		

	}
	

	public void displayWallsAndPellets() {
		// turn wall points into rectangle and add them to pane
		int scale = rectangleScale;
		Circle currentCircle = null;
		
		for (int row = 0; row < wallList.length; row++) {
			for (int column = 0; column < wallList[0].length; column++ ) {
				if (wallList[row][column] == 1)
					layout.getChildren().add(new Rectangle(column*scale, row*scale, scale, scale));
				else if (wallList[row][column] == 2) {
					currentCircle = new Circle(column*scale + scale / 2, row*scale +  scale/ 2, scale/10, Color.GREEN);
					layout.getChildren().add(currentCircle);
					pelletCircleList[row][column] = currentCircle;
				}
			}
		}
	}
	
	
	public void createAvatar() {
		int scale = rectangleScale;
		this.avatar = new Avatar();
		this.avatarCircle = new Circle(avatar.getX()*scale + scale/2, avatar.getY()*scale + scale/2, scale/2, Color.GOLD);
		layout.getChildren().add(avatarCircle);
	}
	
	public void createGhost1() {
		this.ghost1 = new Ghost(wallList);
		this.ghost1Rectangle = new Rectangle(ghost1.getY() * rectangleScale, ghost1.getX() * rectangleScale, rectangleScale, rectangleScale);
		ghost1Rectangle.setFill(Color.RED);
		layout.getChildren().add(ghost1Rectangle);
	}

	public void createGhost2() {
                this.ghost2 = new Ghost(wallList);
                this.ghost2Rectangle = new Rectangle(ghost2.getY() * rectangleScale, ghost2.getX() * rectangleScale, rectangleScale, rectangleScale);
                ghost2Rectangle.setFill(Color.HOTPINK);
                layout.getChildren().add(ghost2Rectangle);
        }

	public void createGhost3() {
                this.ghost3 = new Ghost(wallList);
                this.ghost3Rectangle = new Rectangle(ghost3.getY() * rectangleScale, ghost3.getX() * rectangleScale, rectangleScale, rectangleScale);
                ghost3Rectangle.setFill(Color.DARKORANGE);
                layout.getChildren().add(ghost3Rectangle);
        }

	public void createGhost4() {
                this.ghost4 = new Ghost(wallList);
                this.ghost4Rectangle = new Rectangle(ghost4.getY() * rectangleScale, ghost4.getX() * rectangleScale, rectangleScale, rectangleScale);
                ghost4Rectangle.setFill(Color.CYAN);
                layout.getChildren().add(ghost4Rectangle);
        }



	
	
	public void createGameWin() {
		this.gameWin = new GameWin();
		this.gameWinRectangle = new Rectangle(gameWin.getY() * rectangleScale, gameWin.getX() * rectangleScale, rectangleScale, rectangleScale);
		gameWinRectangle.setFill(Color.CRIMSON);
		layout.getChildren().add(gameWinRectangle);
		gameWinRectangle.setX(gameWin.getX() * rectangleScale);
		gameWinRectangle.setY(gameWin.getY() * rectangleScale);

	}














}
