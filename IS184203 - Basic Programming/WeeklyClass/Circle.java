public class Circle {
    private double radius;
    public Circle(double r){
        this.radius = r;
    }

    public double area(){
        return Math.PI * radius * radius;
    }

    public double circumference(){
        return 2 * radius * Math.PI;
    }

    public double getRadius(){
        return radius;
    }

    public String toString(){
        return "Circle{radius=" + radius + "}";
    }
}
