public abstract class Shape {
    protected boolean filled;
    protected String color;

    // Constructors
    public Shape() {
        this.filled = true;
        this.color = "green";
    }

    public Shape(boolean filled, String color) {
        this.filled = filled;
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        String result = "A Shape with color of " + getColor() + " and ";
        if (filled) {
            result += "filled";
        } else {
            result += "not filled";
        }
        return result;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
