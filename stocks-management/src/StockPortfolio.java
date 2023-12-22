import java.util.ArrayList;

public class StockPortfolio {
    ArrayList<Stock> stocks;

    public StockPortfolio() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double calculateTotalPortfolioValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.calculateStockValue();
        }
        return totalValue;
    }

    public void printStockReport() {
        System.out.println("Stock Report:");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Stock Name", "Shares", "Share Price", "Stock Value");
        System.out.println("-----------------------------------------------------------");
        for (Stock stock : stocks) {
            System.out.printf("%-15s %-15d %-15.2f %-15.2f\n",
                    stock.stockName, stock.numberOfShares, stock.sharePrice, stock.calculateStockValue());
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Total Portfolio Value: " + calculateTotalPortfolioValue());
        System.out.println("-----------------------------------------------------------");
    }
}