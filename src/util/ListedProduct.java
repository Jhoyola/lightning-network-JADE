package util;

import java.util.ArrayList;

//A product that the receiving agent accepts payments for
public class ListedProduct {
    private String prodId;
    private ArrayList<ProductPrice> prices; //accepted prices for the product

    public ListedProduct(String prodId) {
        this.prodId = prodId;
        prices = new ArrayList<ProductPrice>();
    }

    public void addPrice(double price, String currency) {
        //adds a new accepted price for this product
        prices.add(new ProductPrice(price, currency));
    }

    public ArrayList<ProductPrice> getPrices() {
        return prices;
    }

    public String getProdId() {
        return prodId;
    }
}
