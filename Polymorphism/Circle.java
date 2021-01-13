///**
// * The Circle class models a circle with a radius and color.
// */
//public class Circle extends Shape { // Save as "Circle.java"
//	// private instance variable, not accessible from outside this class
//	private double radius;
//	public void setRadius(double radius) {
//		this.radius = radius;
//	}
//
//	// Constructors (overloaded)
//	/** Constructs a Circle instance with default value for radius and color */
//	public Circle() { // 1st (default) constructor
//	    super();
//		radius = 1.0;
//	}
//
//	/** Constructs a Circle instance with the given radius and default color */
//	public Circle(double r) { // 2nd constructor
//	    super();
//		radius = r;
//	}
//
//	public Circle(double r, String c, boolean f){
//		super(f,c);
//		radius = r;
//	}
//
//	/** Returns the radius */
//	public double getRadius() {
//		return radius;
//	}
//
//	// Returns the perimeter of th this circle instance
//	public double getPerimeter(){
//		return radius * 2 * Math.PI;
//	}
//
//	/** Returns the area of this Circle instance */
//	public double getArea() {
//		return radius * radius * Math.PI;
//	}
//
//	public String toString(){
//		return "A Circle with radius=" + getRadius() + ", which is a subclass of " + super.toString();
//	}
//}