package util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class PriceAPICoindesk implements PriceAPI {

    private static final String apiQueryPath = "https://api.coindesk.com/v1/bpi/currentprice.json";
    private HttpClient client;

    public PriceAPICoindesk() {
        client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }

    public double getBTCPrice(String currency) {

        //Coindesk deals with uppercase currencies: EUR,USD,GBP
        currency = currency.toUpperCase();
        double returnPrice = 0;

        try {
            URI apiUrl = new URI(apiQueryPath);

            HttpRequest request = HttpRequest.newBuilder(apiUrl)
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request,  HttpResponse.BodyHandlers.ofString());
            String jsonResponseString = response.body();
            //parse to json object
            JSONObject responseJSONObj = (JSONObject) new JSONParser().parse(jsonResponseString);

            //get the price from the json object
            returnPrice = Double.parseDouble(((JSONObject)((JSONObject)responseJSONObj.get("bpi")).get(currency)).get("rate_float").toString());

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

