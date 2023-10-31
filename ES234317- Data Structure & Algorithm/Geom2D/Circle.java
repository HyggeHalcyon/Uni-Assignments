class Circle implements Geom2D {

    String objectName = "Circle";
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {

        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {

        return Math.PI * 2 * radius;
    }

//    public String toString() {
//        return objectName +
//                "\nRadius   : " + radius +
//                "\nArea     : " + getArea() +
//                "\nPerimeter: " + getPerimeter();
//    }
}
