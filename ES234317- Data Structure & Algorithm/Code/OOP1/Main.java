public class Main {
    public static void main(String[] args) {
        // Membuat objek Nasabah Reguler
        Reguler regulerNasabah = new Reguler("12345", 5000.0, "Alice");

        // Melakukan penarikan
        regulerNasabah.withdraw(1000.0);

        // Melakukan deposit
        regulerNasabah.deposit(2000.0);

        // Membuat objek Nasabah Prioritas
        Prioritas prioritasNasabah = new Prioritas("67890", 10000.0, "Bob", 500.0);

        // Melakukan pengambilan kredit
        prioritasNasabah.kredit(300.0);

        // Melakukan pembayaran kredit
        prioritasNasabah.bayarKredit(200.0);

        // Memberikan gift
        prioritasNasabah.gift();
    }
}