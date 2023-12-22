import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StockAccount {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<CompanyShares> companySharesList;

    public StockAccount() {
        companySharesList = new ArrayList<>();
    }

    private int findStock(String stockSymbol) {
        for (int i = 0; i < companySharesList.size(); i++) {
            if (companySharesList.get(i).getStockSymbol().equals(stockSymbol))
                return i;
        }

        return -1;
    }

    public void buy(String stockSymbol, int numberOfShares) {

        Date transactionDateTime = new Date();

        int index = findStock(stockSymbol);

        if (index != -1) {
            companySharesList.get(index)
                    .setNumberOfShares(companySharesList.get(index).getNumberOfShares() + numberOfShares);
            companySharesList.get(index).setTransactionDateTime(transactionDateTime);
        } else {
            CompanyShares newShares = new CompanyShares(stockSymbol, numberOfShares, transactionDateTime);
            companySharesList.add(newShares);
        }

        System.out.println(numberOfShares + " shares of " + stockSymbol + " bought successfully.");
    }

    public void sell(String stockSymbol, int numberOfShares) {

        int index = findStock(stockSymbol);

        if (index == -1) {
            System.out.println("Stock doesn't exist");
            return;
        }

        int sharesAvailable = companySharesList.get(index).getNumberOfShares();
        if (sharesAvailable < numberOfShares) {
            System.out.println("You can not sell more than " + sharesAvailable);
            return;
        }

        companySharesList.get(index).setNumberOfShares(sharesAvailable - numberOfShares);

        if (companySharesList.get(index).getNumberOfShares() == 0) {
            companySharesList.remove(index);
        }

        System.out.println(numberOfShares + " shares of " + stockSymbol + " sold successfully.");
    }

    public void displayCompanyShares() {
        System.out.println("Company Shares:");

        for (CompanyShares shares : companySharesList) {
            System.out.println("Stock Symbol: " + shares.getStockSymbol());
            System.out.println("Number of Shares: " + shares.getNumberOfShares());
            System.out.println("Transaction Date and Time: " + shares.getTransactionDateTime());
            System.out.println();
        }
    }

    public static void main(String[] args) {

        StockAccount stockAccount = new StockAccount();

        int option;

        do {
            System.out.println("Enter 1 to buy or 2 to sell stock or 3 to display the account book or 0 to exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter name of stock to buy");
                    String name = scanner.next();
                    System.out.print("Enter amount of shares to buy: ");
                    int shares = scanner.nextInt();
                    stockAccount.buy(name, shares);
                    break;

                case 2:
                    System.out.print("Enter name of stock to sell:");
                    String name1 = scanner.next();
                    System.out.print("Enter amount of shares to buy: ");
                    int shares1 = scanner.nextInt();
                    stockAccount.sell(name1, shares1);
                    break;

                case 3:
                    stockAccount.displayCompanyShares();
                    break;
                default:
                    break;
            }
        } while (option != 0);
        stockAccount.buy("AAPL", 10);
        stockAccount.sell("AAPL", 5);

        stockAccount.displayCompanyShares();
    }
}