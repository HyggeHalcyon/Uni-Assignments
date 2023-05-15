public class OpoAccount {
    private String phoneNumber;
    private String name;
    private double balance=0;
    private int transactions=0;
    private String transactionText = "";
    private int points=0;

    public OpoAccount(String phoneNumber, String name, double balance) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getTransactionCount() {
        return this.transactions;
    }

    public String getTransactions() {
        return this.transactionText;
    }

    public int getPoints(){
        return this.points;
    }

    public void topUp(double amount) {
        if (amount >= 100) {
            this.points += (amount - (amount % 100)) / 10;
        }
        this.balance += amount;
        this.transactions++;
        this.transactionText += "top up of $" + amount + "\n";
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        this.transactions++;
        this.transactionText += "withdrawal of $" + amount + "\n";
    }

    public void transfer(OpoAccount account, double amount) {
        if(this.balance >= amount + 5){
            this.transactions++;
            this.balance -= (amount + 5);
            account.balance += amount;
            this.transactionText += "transfer of $" + amount + " to " + account.getPhoneNumber() + "\n";
            account.transactionText += "transfer of $" + amount + " from " + account.getPhoneNumber() + "\n";
            if(amount >= 100){
                this.points += (amount - (amount % 100)) / 10;
            }

        } else if(this.balance > 5) {
            this.transactions++;
            this.balance -= 5;
            account.balance += this.balance;
            this.balance = 0;
            this.transactionText += "transfer of $" + amount + " to " + account.getPhoneNumber() + "\n";
            account.transactionText += "transfer of $" + amount + " from " + account.getPhoneNumber() + "\n";
        }
    }
}