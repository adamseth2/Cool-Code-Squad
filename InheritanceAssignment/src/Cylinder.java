public class Cylinder extends Circle { // Save as "Cylinder.java"
	private double height; // private variable

	// Constructor with default color, radius and height
	public Cylinder() {
		super();
		height = 1.0;
	}

	// Constructor with default radius, color but given height
	public Cylinder(double height) {
		super();
		this.height = height;
	}

	// Constructor with default color, but given radius, height
	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}

	// A public method for retrieving the height
	public double getHeight() {
		return height;
	}

	public double getArea(){
	    return 2 * Math.PI * getRadius() * getHeight() + 2 * super.getArea();
    }

	// A public method for computing the volume of cylinder
	// use superclass method getArea() to get the base area
	public double getVolume() {
		return super.getArea() * getHeight();
	}

//	TO DO: toString() method to the Cylinder class, which 
//	overrides the toString() inherited from the superclass Circle
    public String toString(){
        return "Cylinder[radius=" + getRadius() + ", color=" + getColor() + ", height=" + getHeight() + "]";
    }
}
