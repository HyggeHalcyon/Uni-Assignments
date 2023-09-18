public class Tube{

    double radius;
    double height;

    public Tube(double r, double t) {
        radius = r;
        height = t;
    }

    public double baseCircumference() {
        return 2 * Math.PI * radius;
    }

    public double baseArea() {
        return radius * radius * Math.PI;
    }

    public double area() {
        return baseArea() * 2 + baseCircumference() * height;
    }

    public double volume() {
        return baseArea() * height;
    }
}









