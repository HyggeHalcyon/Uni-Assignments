public class Cube implements GeometricObject {
    private String objectName = "Cube";
    private double length;

    Cube(double l){
        this.length = l;
    }

    @Override
    public double getVolume(){
        // V = a^3
        return length * length * length;
    }

    @Override
    public double getSurfaceArea(){
        // A = 6a^2
        return 6 * (length * length);
    }

    @Override
    public String toString(){
        return this.objectName +
                "\nLength: " + this.length +
                "\nVolume: " + getVolume() +
                "\nSurface Area: " + getSurfaceArea();
    }
}
