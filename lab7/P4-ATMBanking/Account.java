//P4 ATM Banking Kyle Bush

public class Account {

    private static int count;
    private String name;
    private String pin;
    private int id;
    private double balance;

    public Account(String name, String pin) {
        this.name = name;
        this.pin = pin;
        this.id = count++;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isPin(String attempt) {
        return pin.equals(attempt);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return String.format("Name: " + name +
                ", Account ID: " + id +
                ", Balance: $%.2f", balance);
    }
} 