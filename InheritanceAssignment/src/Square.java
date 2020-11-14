public class Square extends Rectangle {
    public Square(double side){
        super(side,side);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        setLength(width);
    }

    public String toString(){
        return "A Square with side=" + getWidth() + ", which is a subclass of " + super.toString();
    }
}
