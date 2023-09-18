public class Main {

    public static void main(String[] args) {

        Circle c = new Circle(10);
        System.out.println("Luas lingkaran: " + c.getArea());
        System.out.println("Keliling lingkaran: " + c.getPerimeter());
        System.out.println(c);

        Rectangle r = new Rectangle(10, 20);
        System.out.println("Luas persegi panjang: " + r.getArea());
        System.out.println("Keliling persegi panjang: " + r.getPerimeter());
        System.out.println(r);

        Square s = new Square(10);
        System.out.println("Luas persegi: " + s.getArea());
        System.out.println("Keliling persegi: " + s.getPerimeter());
        System.out.println(s);
    }
}
