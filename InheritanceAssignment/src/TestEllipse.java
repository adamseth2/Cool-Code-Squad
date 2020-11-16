
public class TestEllipse {
  public static void main(String args[]) {
    System.out.println();
    Ellipse e1 = new Ellipse(1, 2);
    System.out.println("Paramaters Ellipse(1,2)");
    System.out.println("getRadius1 should be 1.0 and is " + e1.getRadius1());
    System.out.println("getRadius2 should be 2.0 and is " + e1.getRadius2());
    System.out.println("getArea should be ~6.28 and is " + e1.getArea());
    System.out.println("getPerimeter should be ~8.89 and is " + e1.getPerimeter());
    System.out.println(
        "toString should be An Ellipse with radii of 1.0 and 2.0, which is a subclass of and A Shape with color green and filled"
            + e1.toString());
    System.out.println();

    System.out.println();
    e1.setRadius1(2);
    e1.setRadius2(1);
    // Change instance variables radius1 to 2 and radius2 to 1
    System.out.println("Changed params to radius 1 to 2 and radius 2 to 1");
    System.out.println("getRadius1 should be 2.0 and is " + e1.getRadius1());
    System.out.println("getRadius2 should be 1.0 and is " + e1.getRadius2());
    System.out.println("getArea should be ~6.28 and is " + e1.getArea());
    System.out.println("getPerimeter should be ~8.89 and is " + e1.getPerimeter());
    System.out.println(
        "toString should be An Ellipse with radii of 2.0 and 1.0, which is a subclass of and A Shape with color green and filled"
            + e1.toString());
    System.out.println();

    // Test if there are no params
    Ellipse e2 = new Ellipse();
    System.out.println("Paramaters Ellipse()");
    System.out.println("getRadius1 should be 1.0 and is " + e2.getRadius1());
    System.out.println("getRadius2 should be 1.0 and is " + e2.getRadius2());
    System.out.println("getArea should be 3.14 and is " + e2.getArea());
    System.out.println("getPerimeter should be ~4.44 and is " + e2.getPerimeter());
    System.out.println(
        "toString should be An Ellipse with radii of 1.0 and 1.0, which is a subclass of and A Shape with color green and filled"
            + e2.toString());

  }

}
