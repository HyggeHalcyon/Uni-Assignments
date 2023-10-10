public class Cone implements GeometricObject{
    private String objectName = "Cone";
    private double height, radius;

    Cone(double r, double h){
        this.radius = r;
        this.height = h;
    }

    @Override
    public double getVolume(){
        // V = π r^2 (h/3)
        return Math.PI * (radius * radius) * (height / 3);
    }

    @Override
    public double getSurfaceArea(){
        // A = π r(r + sqrt(h^2 + r^2))
        return Math.PI * radius * (radius + Math.sqrt((height * height) + (radius * radius)));
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
