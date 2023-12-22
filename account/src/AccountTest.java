import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial account balance: ");
        double initialBalance = scanner.nextDouble();

        Account account1 = new Account(initialBalance);

        System.out.println("Account balance before debit: Rs." + account1.getBalance());

        int option;
        do {
            System.out.println("Enter 1 to debit or 0 to exit");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Account balance before debit: " + account1.getBalance());
                    System.out.print("Enter amount to be debited: ");
                    double debitAmount = scanner.nextDouble();
                    account1.debit(debitAmount);
                    System.out.println("Account balance after debit: " + account1.getBalance());
                    break;

                default:
                    break;
            }
        } while (option != 0);

        scanner.close();
    }
}