public class Rectangle implements Geom2D {
    String objectName = "Rectangle";
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {

        return length * width;
    }

    @Override
    public double getPerimeter() {

        return 2 * (length + width);
    }

    public String toString() {
        return objectName +
                "\nLength   : " + length +
                "\nWidth    : " + width +
                "\nArea     : " + getArea() +
                "\nPerimeter: " + getPerimeter();
    }
}
