# Stock Portfolio Analysis System

## Problem Statement
The **Stock Portfolio Analysis System** is a Java-based tool that helps manage stock investments by providing insights into:
- Stock details, including symbol, quantity, and prices.
- Profit/loss based on buying and current prices.
- Current total value of holdings.
- Monitoring the highest stock price reached.

## Features
The `StockPortfolio` class includes the following functionalities:
1. **Track Stock Details**
   - Symbol (e.g., "AAPL").
   - Quantity of shares.
   - Buying price and current price.

2. **Update Current Market Price**
   - Adjusts the stock's current price.
   - Monitors the highest price reached.

3. **Profit/Loss Calculation**
   - Computes the profit/loss as:  
     \[(\text{Current Price} - \text{Buying Price}) \times \text{Quantity}\]

4. **Portfolio Value Calculation**
   - Calculates the total value of holdings as:  
     \[\text{Current Price} \times \text{Quantity}\]

## Implementation Details

### Class Fields
- `symbol`: Identifier for the stock (e.g., "AAPL").
- `quantity`: Number of shares owned.
- `buyingPrice`: Price at which the shares were purchased.
- `currentPrice`: Current market price of the stock.
- `highestPrice`: Highest price the stock has reached.

### Methods
#### 1. Constructor
Initializes stock details and sets:
- Initial `currentPrice` and `highestPrice` to `buyingPrice`.

#### 2. `updatePrice(double newPrice)`
- Updates the `currentPrice`.
- Updates the `highestPrice` if `newPrice` exceeds it.
- Ensures `newPrice` is positive.

#### 3. `calculateProfit()`
- Computes total profit/loss:  
  \[(\text{Current Price} - \text{Buying Price}) \times \text{Quantity}\]
- Returns a positive value for profit and a negative value for loss.

#### 4. `getCurrentValue()`
- Computes total value of holdings:  
  \[\text{Current Price} \times \text{Quantity}\]

### Starter Code
```java
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
