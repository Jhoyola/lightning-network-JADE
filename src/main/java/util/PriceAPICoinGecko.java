package util;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;

public class PriceAPICoinGecko implements PriceAPI {

    private static final String apiQueryPath = "https://api.coingecko.com/api/v3/simple/price/";
    private HttpClient client = null;

    public PriceAPICoinGecko() {

        try {
            //trust all certs
            client = HttpClients
                    .custom()
                    .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
                    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getBTCPrice(String currency) {

        //coingecko deals with lowercase currencies: eur,usd,...
        currency = currency.toLowerCase();
        double returnPrice = 0;

        String queryParamsStr = "ids=bitcoin&vs_currencies="+currency;
        HttpGet request = new HttpGet(apiQueryPath+"?"+queryParamsStr);

        try {
            HttpResponse response = client.execute(request);

            String jsonResponseString = EntityUtils.toString(response.getEntity());
            JSONObject responseJSONObj = (JSONObject) new JSONParser().parse(jsonResponseString);

            //get the price from the json object
            returnPrice = Double.parseDouble(((JSONObject)responseJSONObj.get("bitcoin")).get(currency).toString());

        } catch (IOException | ParseException e) {
            //TODO BETTER ERROR HANDLING
            e.printStackTrace();
        }
        
        return returnPrice;
    }
}
