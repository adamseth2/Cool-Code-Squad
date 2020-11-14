public class Rectangle extends Shape{
    //instance variables
    private double width;
    private double length;


    //getter and setter methods
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    //constructors
    public Rectangle(){
        super();
        this.width = 1.0;
        this.length = 1.0;
    }

    public Rectangle(double w, double l){
        super();
        this.width = w;
        this.length = l;
    }

    public Rectangle(double w, double l, String c, boolean f){
        super(f,c);
        this.width = w;
        this.length = l;
    }



    public double getArea(){
        return this.width * this.length;
    }

    public double getPerimeter(){
        return this.width * 2 + this.length * 2;
    }

    public String toString(){
        return "A Rectangle with width=" + this.width + " and length=" + this.length + ", which is a subclass of " + super.toString();
    }

}
