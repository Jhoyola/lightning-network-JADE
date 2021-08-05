package util;

public class PriceAPIMock implements PriceAPI{

    public PriceAPIMock() {
    }

    public double getBTCPrice(String currency) {

        //return mock price
        return 10000.0;
    }
}
