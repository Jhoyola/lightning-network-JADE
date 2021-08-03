package util;

public class ProductPrice {
    private double price; //price in currency
    private String currency; //currency of the price

    public ProductPrice(double price, String currency) {
        setPrice(price, currency);
    }

    public void setPrice(double price, String currency) {
        this.price = price;
        this.currency = currency.toLowerCase();
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
