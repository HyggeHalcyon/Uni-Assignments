public class Main {
    public static void main(String[] args){
        Cube cube = new Cube(13);
        System.out.printf("%s\n", cube);
        System.out.printf("=================================\n");

        Cuboid cuboid = new Cuboid(13, 33 ,37);
        System.out.printf("%s\n", cuboid);
        System.out.printf("=================================\n");

        Cylinder cylinder = new Cylinder(13, 37);
        System.out.printf("%s\n", cylinder);
        System.out.printf("=================================\n");

        Prism prism = new Prism(7, 13, 37, 65, 53, 7);
        System.out.printf("%s\n", prism);
        System.out.printf("=================================\n");

        Cone cone = new Cone(13, 37);
        System.out.printf("%s\n", cone);
        System.out.printf("=================================\n");

        Sphere sphere = new Sphere(37);
        System.out.printf("%s\n", sphere);
        System.out.printf("=================================\n");

        Pyramid pyramid = new Pyramid(13, 33, 37);
        System.out.printf("%s\n", pyramid);
    }
}