import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void getInput(int n, StockPortfolio stockPortfolio) {
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Stock " + (i + 1) + ":");
            System.out.print("Enter Stock Name: ");
            String stockName = scanner.next();
            System.out.print("Enter Number of Shares: ");
            int numberOfShares = scanner.nextInt();
            System.out.print("Enter Share Price: ");
            double sharePrice = scanner.nextDouble();

            Stock stock = new Stock(stockName, numberOfShares, sharePrice);
            stockPortfolio.addStock(stock);
        }
    }

    public static void main(String[] args) {
        StockPortfolio stockPortfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int n = scanner.nextInt();

        getInput(n, stockPortfolio);

        stockPortfolio.printStockReport();

        scanner.close();
    }
}