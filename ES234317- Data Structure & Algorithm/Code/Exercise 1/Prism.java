public class Prism implements GeometricObject{
    private String objectName = "Prism";
    private double base, apothem, slant, height, length = 0;
    private int sides;

    Prism(int s, double b, double a,  double c, double l, double h){
        this.base = b;
        this.apothem = a;
        this.slant = c;
        this.length = l;
        this.height = h;
        if(s < 4 || s > 8){
            throw new IllegalArgumentException("Invalid sides");
        }
        this.sides = s;
    }

    @Override
    public double getVolume(){
        // https://mathmonks.com/prism/volume-of-a-prism
        double volume = 0;
        switch (this.sides){
            case 4:
                volume = (this.apothem + this.height) * this.height * this.length / 2;
                break;
            case 5:
                volume = (5 * this.apothem * this.base * this.height) / 2;
                break;
            case 6:
                volume = 3 * this.apothem * this.base * this.height;
                break;
            case 7:
                double cotagen = 1.0 / Math.tan(Math.PI / 7);
                volume = (7 * (this.apothem * this.apothem) * cotagen * this.height) / 4;
                break;
            case 8:
                volume = 2 * (1 + Math.sqrt(2)) * (this.apothem * this.apothem) * this.height;
                break;
        }
        return volume;
    }

    @Override
    public double getSurfaceArea(){
        // https://mathmonks.com/prism/surface-area-of-a-prism
        double volume = 0;
        switch (this.sides){
            case 4:
                volume = (this.apothem + this.base) * this.height +
                        (this.apothem + this.base + this.slant + this.height) * this.length;
                break;
            case 5:
                volume = 5 * (this.apothem * this.base) +
                        5 * (this.base * this.height);
                break;
            case 6:
                volume = 6 * (this.apothem * this.base) +
                        6 * (this.base * this.height);
                break;
            case 7:
                double cotagen = 1.0 / Math.tan(Math.PI / 7);
                volume = (7 * (this.apothem * this.apothem) * cotagen) / 2 +
                        7 * (this.apothem * this.height);
                break;
            case 8:
                volume = 4 * (1 + Math.sqrt(2) * (this.apothem * this.apothem)) +
                        8 * (this.apothem * this.height);
                break;
        }
        return volume;
    }

    @Override
    public String toString(){
        return objectName +
                "\nBase: " + this.base +
                "\nApothem: " + this.apothem +
                "\nSlant: " + this.slant +
                "\nHeight: " + this.height +
                "\nLength: " + this.length +
                "\nVolume: " + getVolume() +
                "\nSurface Area: " + getSurfaceArea();
    }
}
