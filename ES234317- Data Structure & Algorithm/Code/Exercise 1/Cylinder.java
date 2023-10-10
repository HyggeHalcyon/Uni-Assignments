public class Cylinder implements GeometricObject{
    private String objectName = "Cylinder";
    private double radius, height;

    Cylinder(double r, double h){
        this.radius = r;
        this.height = h;
    }

    @Override
    public double getVolume(){
        // V = πhr^2
        return Math.PI * (radius * radius) * height;
    }

    @Override
    public double getSurfaceArea(){
        // A = 2πrh + 2πr^2
        return (2 * Math.PI * radius * height) + (2 * Math.PI * (radius * radius));
    }

    @Override
    public String toString(){
        return this.objectName +
                "\nRadius: " + this.radius +
                "\nHeight: " + this.height +
                "\nVolume: " + getVolume() +
                "\nSurface Area: " + getSurfaceArea();
    }
}
