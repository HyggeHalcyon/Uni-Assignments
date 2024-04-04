public class Nasabah {
    // Atribut
    private String nomorRekening;
    private double saldo;
    private String nama;

    // Constructor
    public Nasabah(String nomorRekening, double saldo, String nama) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.nama = nama;
    }

    // Method untuk mengecek saldo
    public double cekSaldo() {
        return saldo;
    }

    // Method untuk melakukan penarikan
    public void withdraw(double amount) {
        if (amount <= saldo) {
            saldo -= amount;
            System.out.println("Penarikan berhasil. Sisa saldo: " + saldo);
        } else {
            System.out.println("Saldo tidak mencukupi.");
        }
    }

    // Method untuk melakukan deposit
    public void deposit(double amount) {
        saldo += amount;
        System.out.println("Deposit berhasil. Saldo sekarang: " + saldo);
    }

    // Getter dan setter. Dipergunakan untuk menjaga prinsip enkapsulasi
    // dan mengatur bagaimana data bisa diakses.
    // Seharusnya ada mekanisme seperti siapa yang bisa mengakses,
    // bagaimana bisa diubah, dst.
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getNama() {
        return nama;
    }
}
