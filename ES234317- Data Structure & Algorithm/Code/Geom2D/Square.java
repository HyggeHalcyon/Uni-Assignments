public class Square extends Rectangle {
    String objectName = "Square";
    double side;

    Square(double side) {
        super(side, side);
        this.side = side;
    }

    public String toString() {
        return objectName +
                "\nSide     : " + side +
                "\nArea     : " + getArea() +
                "\nPerimeter: " + getPerimeter();
    }
}
