package util;

import java.util.ArrayList;

public class ProductCatalog {
    private ArrayList<ListedProduct> listedProducts;

    public ProductCatalog() {
        listedProducts = new ArrayList<ListedProduct>();
    }

    public ArrayList<ListedProduct> getListedProducts() {
        return listedProducts;
    }

    public ListedProduct getProduct(String prodId) {

        for (int i = 0; i < listedProducts.size(); i++) {
            if (listedProducts.get(i).getProdId().equals(prodId)) {
                return listedProducts.get(i);
            }
        }

        return null;
    }

    public void addProduct(ListedProduct prod) {
        //prod id:s have to be unique
        if (!hasProductId(prod.getProdId())) {
            //is unique: can add
            listedProducts.add(prod);
        } else {
            for (int i = 0; i < listedProducts.size(); i++) {
                if (listedProducts.get(i).getProdId().equals(prod.getProdId())) {

                    ArrayList<ProductPrice> pricesToAdd = prod.getPrices();
                    for (int j = 0; j < pricesToAdd.size(); j++) {
                        listedProducts.get(i).addPrice(pricesToAdd.get(j).getPrice(), pricesToAdd.get(j).getCurrency());
                    }
                    return;
                }
            }
        }

    }

    public boolean hasProductWithPrice(String prodId, double price, String currency) {

        //currencies in lowercase
        currency = currency.toLowerCase();

        for (int i = 0; i < listedProducts.size(); i++) {
            if (listedProducts.get(i).getProdId().equals(prodId)) {
                ArrayList<ProductPrice> prices =  listedProducts.get(i).getPrices();
                for (int j = 0; j < prices.size(); j++) {
                    ProductPrice p = prices.get(j);
                    if (p.getPrice() == price && p.getCurrency().equals(currency)) {
                        //found a product with correct price and currency
                        return true;
                    }
                }
            }
        }

        //product not found
        return false;
    }

    private boolean hasProductId(String prodId) {
        for (int i = 0; i < listedProducts.size(); i++) {
            if (listedProducts.get(i).getProdId().equals(prodId)) {
                return true;
            }
        }

        return false;
    }
}
