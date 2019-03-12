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


public class GUI2 extends Application{


	
	// variables
	Avatar avatar;
	Wall wall;	
	Pellet pellet;

	ArrayList<Point> wallList;
	ArrayList<Point> pelletList;
	ArrayList<Circle> pelletCircleList;
	
	private int x;
	private int y;	

	

	// main method
	public static void main(String[] args) {
	launch(args);
	}


	
	// start method
	@Override
	public void start(Stage primaryStage) {

		// System.out.print("What would you like your width to be");
		// System.out.println("Output will be width * 5 - 2");
		// Scanner in = new Scanner(System.in);
		// int x = in.nextInt();
		// System.out.print("What would you like your height to be");
		// System.out.println("Output will be height * 5 - 2");
		// int y = in.nextInt();
	


		// initialize all the variables and create helper variables
		avatar = new Avatar();	
		wall = new Wall(50, 50);
		wallList = wall.getLocation();
		pellet = new Pellet(50, 50);	
		pelletList = pellet.getLocation();
		pelletCircleList = new ArrayList<Circle>();


		// set title  and create pane layout
		primaryStage.setTitle("title of window");
		Pane layout = new Pane();

		// create avatar rectangle, add that to pane
		Rectangle avatarRectangle = new Rectangle(avatar.getX() * 10, avatar.getY() * 10, 10, 10);
		avatarRectangle.setFill(Color.RED);
		layout.getChildren().add(avatarRectangle);

		
		// turn wall points into rectangle and add them to pane
		for (Point eachPoint : wallList) {
			layout.getChildren().add(new Rectangle( (eachPoint.getX() * 10), (eachPoint.getY() * 10), 10, 10));
        	}
		
		
		// turn pellet points into circles and add them to pane
		for (Point eachPoint : pelletList) {
			Circle c = new Circle(((eachPoint.getX() * 10) + 5), ((eachPoint.getY() * 10) +  5), 1, Color.GREEN);
			
			// add pellet circle to pelletCircleList
			pelletCircleList.add(c);
			
			// add circle to pane
			layout.getChildren().add(c);
		}



		// create new scene, add the pane to scene, add the scene to stage
		Scene scene = new Scene(layout, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();		

		// show the stage
		primaryStage.show();
		
		// handle keyboard input
		scene.setOnKeyPressed(event -> {
			
			// get the key entered
			String input = event.getText();			
			
			// create test avatar, move that avatar
			Avatar testAvatar = new Avatar(avatar.getLocation());
			testAvatar.move(input);

			// if no wall overlaps with test avatar, move the real avaar
			if (!wall.overlapsWith(testAvatar)) {
				avatar.move(input);	
				avatarRectangle.setX(avatar.getX() * 10);
				avatarRectangle.setY(avatar.getY() * 10);
			} 		
		
		
			// check if avatar location overlaps with a pellet location, the remove pellet	
			if (pellet.overlapsWith(avatar)) {
				pellet.removePellet(avatar.getLocation());
				pelletList = pellet.getLocation();
				
				for (Circle eachPelletCircle : pelletCircleList) {
				
					if ((((eachPelletCircle.getCenterX() - 5) / 10) == avatar.getX()) && (((eachPelletCircle.getCenterY() - 5) / 10) == avatar.getY())) {
						System.out.println((eachPelletCircle.getCenterX() - 5) + "  " + (eachPelletCircle.getCenterY() - 5));
						layout.getChildren().remove(eachPelletCircle);

					} 
				}
			}
		});
	
	}
	



















}
