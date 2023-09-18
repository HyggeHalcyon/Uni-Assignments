public class Prioritas extends Nasabah {// Atribut khusus Prioritas
    private double credit;
    private double limit = 100000000;

    // Constructor
    public Prioritas(String nomorRekening, double saldo, String nama, double credit) {
        super(nomorRekening, saldo, nama);
        this.credit = credit;
    }

    // Method untuk penarikan dengan limit default
    // Ini sekaligus merupakan contoh overriding
    public void withdraw(double amount) {
        this.withdrawLimit(amount, this.limit);
    }

    // Method untuk penarikan dengan batas (limit) yang dapat diubah (non-default)
    public void withdrawLimit(double amount, double limit) {
        if (amount <= getSaldo() && amount <= limit) {
            super.withdraw(amount);
        } else {
            System.out.println("Saldo tidak mencukupi atau melebihi batas limit.");
        }
    }

    // Method untuk deposit dengan limit default
    // Ini sekaligus merupakan contoh overriding
    public void deposit(double amount) {
        this.depositLimit(amount, this.limit);
    }

    // Method untuk deposit dengan batas (limit) yang dapat diubah (non-default)
    public void depositLimit(double amount, double limit) {
        if (amount <= limit) {
            super.deposit(amount);
        } else {
            System.out.println("Melebihi batas limit deposit.");
        }
    }

    // Method untuk mengambil kredit
    public void kredit(double amount) {
        if (amount <= getCredit()) {
            credit -= amount;
            setSaldo(getSaldo() + amount);
            System.out.println("Pengambilan kredit berhasil. Saldo sekarang: " + getSaldo());
        } else {
            System.out.println("Kredit tidak mencukupi.");
        }
    }

    // Method untuk membayar kredit
    public void bayarKredit(double amount) {
        if (amount <= getSaldo()) {
            setSaldo(getSaldo() - amount);
            setCredit(getCredit() + amount);
            System.out.println("Pembayaran kredit berhasil. Sisa kredit: " + getCredit());
        } else {
            System.out.println("Saldo tidak mencukupi untuk membayar kredit.");
        }
    }

    // Method untuk menambahkan 0.1% saldo sebagai gift
    public void gift() {
        double giftAmount = getSaldo() * 0.001;
        setSaldo(getSaldo() + giftAmount);
        System.out.println("Gift 0.1% saldo berhasil. Saldo sekarang: " + getSaldo());
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
