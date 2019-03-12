
public class PacManMazeTextManager {
	public static void main(String[] args) {
		PacManMazeTextLogic main = new PacManMazeTextLogic();
		main.initialize();
		while (true) {
			main.getInputAndMove();
			main.updateScore();
			main.printCurrentState();
		}
	}
}
