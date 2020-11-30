public class ResizableCircle extends Circle implements Resizable{
    public ResizableCircle(double radius) {
        super(radius);
    }

    public ResizableCircle() {
        super.radius = 1.0;
    }

    public void resize(int percent){
        super.radius = super.radius * (percent / 100.0);
    }
}
