public class Cuboid implements GeometricObject{
    private String objectName = "Cuboid";
    private double length, width, height;

    Cuboid(double l, double w, double h){
        this.length = l;
        this.width = w;
        this.height = h;
    }

    @Override
    public double getVolume(){
        // V = whl
        return length * width * height;
    }

    @Override
    public double getSurfaceArea(){
        // A = 2 (lw+wh+lh)
        return 2 * ((length * width) + (width * height) + (length * height));
    }

    @Override
    public String toString(){
        return this.objectName +
                "\nLength: " + this.length +
                "\nWidth: " + this.width +
                "\nHeight: " + this.height +
                "\nVolume: " + getVolume() +
                "\nSurface Area: " + getSurfaceArea();
    }
}
