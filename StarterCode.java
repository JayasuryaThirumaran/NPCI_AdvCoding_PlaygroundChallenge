public class Main {
    public static void main(String[] args) {
        // Test Case 1: Stock Analysis
        StockPortfolio stock = new StockPortfolio("AAPL", 10, 150.0);
        stock.updatePrice(160.0);
        System.out.println(stock.calculateProfit());
        System.out.println(stock.getCurrentValue());
    }
}

class StockPortfolio {
    private String symbol;
    private int quantity;
    private double buyingPrice;
    private double currentPrice;
    private double highestPrice;

    public StockPortfolio(String symbol, int quantity, double buyingPrice) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.currentPrice = buyingPrice;
        this.highestPrice = buyingPrice;
    }

    public void updatePrice(double newPrice) {
        if (newPrice > 0) {
            this.currentPrice = newPrice;
            if (newPrice > this.highestPrice) {
                this.highestPrice = newPrice;
            }
        }
    }

    public double calculateProfit() {
        return (currentPrice - buyingPrice) * quantity;
    }

    public double getCurrentValue() {
        return currentPrice * quantity;
    }
}
