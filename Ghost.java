import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


public class Ghost {
	// 2 instance variables: location and previous move
	private Point location;
	private String previousMove;


	// constructors
	public Ghost() {
		this.location = new Point(13, 14);
		previousMove = " ";
	
	}


	// get location coordinates
	public double getX() {
                return location.getX();
        }


	public double getY() {
                return location.getY();
        }

	

	// returns direction of where to move
	public String pickMove(int[][] wallList, Avatar avatar) {
		
		/////// first, chase the avatar if it is in the ghost's line of sight	//////	
		
		int avatarX = (int) avatar.getX();
		int avatarY = (int) avatar.getY();

		int ghostX = location.x;
		int ghostY = location.y;
	
		// check if avatar is directly to the left of the ghost which no walls in between
		// if that is true, then return "a" 
		
		if ( (avatarY == ghostY) && (avatarX < ghostX) ) {
			// check if there are no walls between avatar and ghost
			boolean noWalls = true;
			for (int i = avatarX; i < ghostX; i++) {
				if (wallList[avatarY][i] == 1) {
					noWalls = false;
				}
			}
			if (noWalls == true) {
				return "a";
			}
		}

		
		// check if avatar is directly to the right of the ghost with no walls in between
		// if that is true, then return "d"
		if ( (avatarY == ghostY) && (avatarX > ghostX) ) {
			//check if there are no walls in between
			boolean noWalls = true;
			for (int i = ghostX; i < avatarX; i++) {
				if (wallList[avatarY][i] == 1) {
					noWalls = false;
				}
			}
			if (noWalls == true) {
				return "d";
			}
		}		
	
			
		// check if avatar is directly on top of the ghost with no walls in between
		// if that is true, return "w"

		if ( (avatarX == ghostX) && (avatarY < ghostY) ) {
			// check if there are no walls in between
			boolean noWalls = true;
			for (int i = avatarY; i < ghostY; i++) {
				if (wallList[i][avatarX] == 1) {
					noWalls = false;
				}
			}
			if (noWalls == true) {
				return "w";
			}
		}


		// check if avatar is directly below the ghost with no walls in between
		// if that is true, return "d"

		if ( (avatarX == ghostX) && (avatarY > ghostY) ) {
			// check if there are no walls in between 
			boolean noWalls = true;
			for (int i = ghostY; i < ghostX; i++) {
				if (wallList[i][avatarX] == 1) {
					noWalls = false;
				}
			}
			if (noWalls == true) {
				return "s";
			}
		
		}



		////// if avatar is not in line of sight, then pick random move //////

		// first clreate a list that contains all potential moves
		ArrayList<String> potentialMoves = new ArrayList<String>();
		potentialMoves.add("w");
		potentialMoves.add("s");
		potentialMoves.add("a");
		potentialMoves.add("d");

		//if a wall is preventing a move, remove that move from potentialMoves
		if (wallList[location.y - 1][location.x] == 1) {
			potentialMoves.remove("w");
		}
		if (wallList[location.y + 1][location.x] == 1) {
                        potentialMoves.remove("s");
                }
		if (wallList[location.y][location.x - 1] == 1) {
			potentialMoves.remove("a");
		}
		if (wallList[location.y][location.x + 1] == 1) {
			potentialMoves.remove("d");
		}

		
		// see if the only option remaining is to do the previous move
		if ((potentialMoves.size() == 1) && (potentialMoves.get(0) == this.previousMove)) {
			return previousMove;
		}

		//
		else {
			potentialMoves.remove(previousMove);
			Random r = new Random();
			int randomIndex = r.nextInt(potentialMoves.size());
			return potentialMoves.get(randomIndex);
		}


	}


	
	public void move(String direction) {
		if (direction == "w") {
			location.translate(0, -1);
			this.previousMove = "s";	
		}
		if (direction == "s") {
                        location.translate(0, 1);
                        this.previousMove = "w";
                }
		if (direction == "a") {
                        location.translate(-1, 0);
                        this.previousMove = "d";
                }
		if (direction == "d") {
                        location.translate(1, 0);
                        this.previousMove = "a";
                }
	}


	public boolean overlapsWith(Avatar player) {
                boolean collision = false;

                if (location.getX() == player.getX() && location.getY() == player.getY()) {
                        collision = true;
                        System.out.println("GAME OVER!");
                        System.exit(0);

                }
                return collision;
        }








}
