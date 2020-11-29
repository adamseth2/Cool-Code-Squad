package polymorphism;

public class MovablePoint implements Movable { // saved as "MovablePoint.java"
	// instance variables
	int x, y, xSpeed, ySpeed; // package access

	// Constructor
	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		// ......
	}
	// ......

	// Implement abstract methods declared in the interface Movable
	@Override
	public void moveUp() {
		y -= ySpeed; // y-axis pointing down for 2D graphics
	}

	@Override
	public void moveDown() {
		y += ySpeed;
	}

	// ! Not sure if this is correct
	@Override
	public void moveLeft() {
		x -= xSpeed;
	}

	@Override
	public void moveRight() {
		x += xSpeed;
	}

	public String toString() {
		return "This is a Movable Point with 
		\n x: " + this.x +
		"\n y: " + this.y +
		"\n xSpeed: " + this.xSpeed +
		"\n ySpeed: " + this.ySpeed; 
	}
}