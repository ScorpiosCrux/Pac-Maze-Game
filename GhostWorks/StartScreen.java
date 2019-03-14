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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import java.util.Scanner;
import javafx.scene.control.TextField;
import java.awt.Point;
import javafx.geometry.Pos;
import java.util.ArrayList;


public class StartScreen extends Application{
	public static void main(String[] args) {
	launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("PACMAZE");
		
		VBox root = new VBox();

		Button button = new Button("Start Game");

		root.setAlignment(Pos.CENTER);
		root.getChildren().add(button);

		Scene scene = new Scene(root, 150, 150);

		
		primaryStage.setScene(scene);
		primaryStage.show();

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
	}
}
	





