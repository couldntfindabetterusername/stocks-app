import java.util.Date;

public class CompanyShares {
    private String stockSymbol;
    private int numberOfShares;
    private Date transactionDateTime;

    public CompanyShares(String stockSymbol, int numberOfShares, Date transactionDateTime) {
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.transactionDateTime = transactionDateTime;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public Date getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setNumberOfShares(int number) {
        this.numberOfShares = number;
    }

    public void setTransactionDateTime(Date transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }
}