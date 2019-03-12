import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Point;

public class AvatarTest{
	
	// test constructors for valid values
	@Test
	public void test_creation(){
		Point p = new Point(1,1);
		Avatar a = new Avatar();
		assertEquals("Expected inital score to be 0", 0, a.getScore(), 0.000001);
		assertEquals("Expected inital x to be 1", 1, a.getX(), 0.000001);
		assertEquals("Expected inital y to be 1", 1, a.getY(), 0.000001);
	}	
	@Test
	public void test_constructorWithPoint(){
		Point p = new Point(2,1);
		Avatar a = new Avatar(p);
		assertEquals("Expected inital score to be 0", 0, a.getScore(), 0.000001);
		assertEquals("Expected X coordinate to be point provided", 2, a.getX(), 0.000001);
		assertEquals("Expected Y coordinate to be point provided", 1, a.getY(), 0.000001); 
	}
	// test methods 
	@Test
	public void test_addScore(){
		Avatar a = new Avatar();
		a.addScore(21);
		assertEquals("Added score of 21", 21, a.getScore(), 0.000001);
	}
	@Test
	public void test_addScore_negativeScore(){
		Avatar a = new Avatar();
		a.addScore(-1);
		assertEquals("Tried to add negative score, score should remain unchanged.", 0, a.getScore(), 0.000001);
	}
	
	// test movement of the avatar
	@Test
	public void test_moveUp(){
		Avatar a = new Avatar();
		a.move("w");
		assertEquals("Y coordinate should decrease by 1 unit", 0, a.getY(), 0.000001);
	}
	@Test
	public void test_moveDown(){
		Avatar a = new Avatar();
		a.move("s");
		assertEquals("Y coordinate should increase by 1 unit", 2, a.getY(), 0.000001);
	}
	public void test_moveLeft(){
		Avatar a = new Avatar();
		a.move("a");
		assertEquals("X coordinate should decrease by 1 unit", 0, a.getX(), 0.000001);
	}
	public void test_moveRight(){
		Avatar a = new Avatar();
		a.move("d");
		assertEquals("X coordinate should increase by 1 unit", 2, a.getX(), 0.000001);
	}
		
}