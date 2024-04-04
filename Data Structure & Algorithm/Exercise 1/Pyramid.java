public class Pyramid implements GeometricObject{
    private String objectName = "Pyramid";
    private double length, width, height;

    Pyramid(double l, double w, double h){
        this.length = l;
        this.width = w;
        this.height = h;
    }

    @Override
    public double getVolume(){
        // V = (lwh) / 3
        return (length * width * height) / 3;
    }

    @Override
    public double getSurfaceArea(){
        // A = lw+l sqrt((w/2)^2 + h^2) + w sqrt((l/2)^2 + h^2)
        return (length * width) +
                Math.sqrt((width / 2) * (width / 2) + (height * height)) +
                width +
                Math.sqrt((length / 2) * (length / 2) + (height * height));
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
