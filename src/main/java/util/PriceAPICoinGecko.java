package util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class PriceAPICoinGecko implements PriceAPI {

    private static final String apiQueryPath = "https://api.coingecko.com/api/v3/simple/price/";
    private HttpClient client;


    public PriceAPICoinGecko() {
        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }

    public double getBTCPrice(String currency) {

        //coingecko deals with lowercase currencies: eur,usd,...
        currency = currency.toLowerCase();
        double returnPrice = 0;

        try {
            String queryParamsStr = "ids=bitcoin&vs_currencies="+currency;
            URI apiUrl = new URI(apiQueryPath+"?"+queryParamsStr);

            HttpRequest request = HttpRequest.newBuilder(apiUrl)
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request,  HttpResponse.BodyHandlers.ofString());
            String jsonResponseString = response.body();
            //parse to json object
            JSONObject responseJSONObj = (JSONObject) new JSONParser().parse(jsonResponseString);

            //get the price from the json object
            returnPrice = Double.parseDouble(((JSONObject)responseJSONObj.get("bitcoin")).get(currency).toString());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return returnPrice;
    }
}
