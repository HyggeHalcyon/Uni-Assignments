public class Week02 {
    public static void main() {
        //Variable Declaration
        String nameOfFirstProduct = "Chitato Lite";
        int quantityOfFirstProduct = 5;
        int priceOfFirstProduct = 10000;
        int totalOfFirstProduct = quantityOfFirstProduct * priceOfFirstProduct;

        //Output
        System.out.println("--------------------------------------");
        System.out.println("Nama Barang\tQTY\tHarga\tTotal");
        System.out.println("--------------------------------------");
        System.out.println(nameOfFirstProduct + "\t" + quantityOfFirstProduct + "\t" + priceOfFirstProduct + "\t" + totalOfFirstProduct);
    }
}
