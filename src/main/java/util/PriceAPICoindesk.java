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

public class PriceAPICoindesk implements PriceAPI {

    private static final String apiQueryPath = "https://api.coindesk.com/v1/bpi/currentprice.json";
    private HttpClient client;

    public PriceAPICoindesk() {

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

        //Coindesk deals with uppercase currencies: EUR,USD,GBP
        currency = currency.toUpperCase();
        double returnPrice = 0;

        HttpGet request = new HttpGet(apiQueryPath);

        try {
            HttpResponse response = client.execute(request);

            String jsonResponseString = EntityUtils.toString(response.getEntity());
            JSONObject responseJSONObj = (JSONObject) new JSONParser().parse(jsonResponseString);

            //get the price from the json object
            returnPrice = Double.parseDouble(((JSONObject)((JSONObject)responseJSONObj.get("bpi")).get(currency)).get("rate_float").toString());

        } catch (IOException | ParseException e) {
            //TODO BETTER ERROR HANDLING
            e.printStackTrace();
        }

        return returnPrice;
    }
}
