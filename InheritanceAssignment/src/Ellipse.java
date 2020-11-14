public class Ellipse extends Shape{
    private double radius1;
    private double radius2;

    public double getRadius1() {
        return radius1;
    }

    public void setRadius1(double radius1) {
        this.radius1 = radius1;
    }

    public double getRadius2() {
        return radius2;
    }

    public void setRadius2(double radius2) {
        this.radius2 = radius2;
    }

    public Ellipse(){
        super();
        this.radius1 = 1.0;
        this.radius2 = 1.0;
    }

    public Ellipse(double radius1, double radius2){
        super();
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    public Ellipse(double radius1, double radius2, String c, boolean f){
        super(f,c);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    public double getArea(){
        return radius1 * radius2 * Math.PI;
    }

    public double getPerimeter(){
        return 2 * Math.PI * Math.sqrt((radius1 * radius1 * radius2 * radius2)/2);
    }

    public String toString() {
        return "An Ellipse with radii of " + this.radius1 + " and " + this.radius2 + ", which is a subclass of " + super.toString();
    }
}
