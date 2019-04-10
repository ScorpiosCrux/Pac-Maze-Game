import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle; 
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import java.util.Scanner;
import javafx.scene.control.TextField;
import java.awt.Point;
import javafx.geometry.Pos;
import java.util.ArrayList;

/**
 * This is the class through which we launch our GUI application
 * This class opens a window with 2 buttons
 * One button if clicked contains the game instructions
 * The other button if clicked launches the game
 */
public class StartScreen extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * the start method of this javafx class
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("PACMAZE");
		
		VBox root = new VBox();

		Label label = new Label("PACMAZE");
		
		// create a button that starts the game
		Button button = new Button("Start Game");
		button.setOnAction( new EventHandler<ActionEvent>() {	
		@Override
			public void handle(ActionEvent event) {
				Stage menuStage = new Stage();
				PacManMazeGUILogic menu = new PacManMazeGUILogic();
				menu.start(menuStage);
				menuStage.show();
				primaryStage.close();
			

			
			}

		
		}
		);


		// create a button that displays the instructions
		Button button2 = new Button("Instructions");
		button2.setOnAction( new EventHandler<ActionEvent>() {	
		@Override
			public void handle(ActionEvent event) {
				Stage menuStage = new Stage();
				InstructionsScreen menu = new InstructionsScreen();
				menu.start(menuStage);
				menuStage.show();
			}

		}
		);


		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(label, button, button2);

		Scene scene = new Scene(root, 350, 350);
		
		primaryStage.setScene(scene);
		primaryStage.show();			
	}
}
	











