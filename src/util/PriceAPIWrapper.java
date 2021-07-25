package util;

public class PriceAPIWrapper {

    private PriceAPI priceAPI;

    public PriceAPIWrapper(PriceAPI priceAPIObject) {

        priceAPI = priceAPIObject;
    }

    //Get the amount of satoshis corresponding to the amount in given traditional currency
    //currency: 'eur', 'usd', etc.
    //Return satoshi value as int, since satoshi is a very small unit.
    public int getSatsValue(double currVal, String currency) {

        //get btc price from the api
        double btcPrice = priceAPI.getBTCPrice(currency);

        //100 million satoshis/bitcoin
        double satsPrice = btcPrice/(Math.pow(10,8));

        //for example: (xxx €)/(yyy €/sat) = zzz sat
        return (int)Math.round(currVal/satsPrice);
    }
}
