public class Sphere implements GeometricObject{
    private String objectName = "Sphere";
    private double radius;

    Sphere(double r){
        this.radius = r;
    }

    @Override
    public double getVolume(){
        // V = (4/3) πr^3
        return (4 * Math.PI * (radius * radius * radius)) / 3;
    }

    @Override
    public double getSurfaceArea(){
        // A = 4πr^2
        return 4 * Math.PI * (radius * radius);
    }

    @Override
    public String toString(){
        return this.objectName +
                "\nRadius: " + this.radius +
                "\nVolume: " + getVolume() +
                "\nSurface Area: " + getSurfaceArea();
    }
}
