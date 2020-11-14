

/**
 * A Test Driver for the Circle class
 */
public class TestCircle { // Save as "TestCircle.java"
	public static void main(String[] args) {
		// Declare an instance of Circle class called c1.
		// Construct the instance c1 by invoking the "default" constructor
		// which sets its radius and color to their default value.
		Circle c1 = new Circle();
		// Invoke public methods on instance c1, via dot operator.
		System.out.println("The circle has radius of " + c1.getRadius() + " and area of " + c1.getArea());
		// The circle has radius of 1.0 and area of 3.141592653589793

		// Declare an instance of class circle called c2.
		// Construct the instance c2 by invoking the second constructor
		// with the given radius and default color.
		Circle c2 = new Circle(2.0);
		// Invoke public methods on instance c2, via dot operator.
		System.out.println("The circle has radius of " + c2.getRadius() + " and area of " + c2.getArea());
		// The circle has radius of 2.0 and area of 12.566370614359172
		System.out.println(c1);
		System.out.println(c2);
	}
}
