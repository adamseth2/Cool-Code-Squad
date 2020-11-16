public class TestShape {
    public static void main(String[] args) {
        System.out.println();
        Shape s1 = new Shape(false, "white");
        System.out.println("Paramaters shape(false, white)");
        System.out.println("isFilled should be false and is " + s1.isFilled());
        System.out.println("getColor should be white and is " + s1.getColor());
        System.out.println(
                "toString should be A Shape with color of white and not filled and is instead " + s1.toString());
        System.out.println();
        s1.setFilled(true);
        s1.setColor("red");
        // Change instance variables to "true" and "red"
        System.out.println("isFilled should be true and is " + s1.isFilled());
        System.out.println("getColor should be red and is " + s1.getColor());
        System.out.println("toString should be A Shape with color of red and filled and is instead " + s1.toString());
        System.out.println();
        // s2 test case
        Shape s2 = new Shape();

        System.out.println("Paramaters shape()");
        System.out.println("isFilled should be true and is " + s1.isFilled());
        System.out.println("getColor should be green and is " + s1.getColor());
        System.out.println("toString should be A Shape with color of green and filled and is instead " + s1.toString());

    }
}
