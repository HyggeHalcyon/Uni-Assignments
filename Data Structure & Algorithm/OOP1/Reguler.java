public class Reguler extends Nasabah {
    private double limit = 10000000;

    // Constructor
    public Reguler(String nomorRekening, double saldo, String nama) {
        super(nomorRekening, saldo, nama);
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

    // Getter dan setters untuk variabel private limit
    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
