public class Account {

    private double balance;

    public Account(double initialBalance) {
        if (initialBalance >= 0.0) {
            balance = initialBalance;
        } else {
            balance = 0;
            System.out.println("Initial balance must be non-negative.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        if (amount > 0.0) {
            balance += amount;
        } else {
            System.out.println("Credit amount must be greater than 0.0.");
        }
    }

    public void debit(double amount) {
        if (amount > 0.0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Amount has been debited.");
            } else {
                System.out.println("Debit amount exceeded account balance. Transaction cancelled.");
            }
        } else {
            System.out.println("Debit amount must be greater than 0.0.");
        }
    }
}