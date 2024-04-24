import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    String direccion = "https://v6.exchangerate-api.com/v6/ee56f40ea33f0a5e4f66a9e0/latest/USD";
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(direccion))
            .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    String json = response.body();

    public API() throws IOException, InterruptedException {
    }

    public double consumeApiARS() throws IOException, InterruptedException {

        JSONArray jsonArrayARS = new JSONArray("[" + json + "]");
        JSONObject primerObjetoARS = jsonArrayARS.getJSONObject(0);
        JSONObject segundoObjetoARS = primerObjetoARS.getJSONObject("conversion_rates");
        BigDecimal dolarARS = segundoObjetoARS.getBigDecimal("ARS");

        double divisaArsDouble = dolarARS.doubleValue();
            return divisaArsDouble;
    }

    public double consumeApiBRL(){
        JSONArray jsonArrayBRL = new JSONArray("[" + json + "]");
        //System.out.println(jsonArray);
        JSONObject primerObjetoBRL = jsonArrayBRL.getJSONObject(0);
        JSONObject segundoObjetoBRL = primerObjetoBRL.getJSONObject("conversion_rates");
        BigDecimal dolarBras = segundoObjetoBRL.getBigDecimal("BRL");

        double divisaBrlDouble = dolarBras.doubleValue();
            return divisaBrlDouble;
    }

    public double consumeApiCOP() {
        JSONArray jsonArrayCOP = new JSONArray("[" + json + "]");
        //System.out.println(jsonArray);
        JSONObject primerObjetoCOP = jsonArrayCOP.getJSONObject(0);
        JSONObject segundoObjetoCOP = primerObjetoCOP.getJSONObject("conversion_rates");
        BigDecimal dolarCol = segundoObjetoCOP.getBigDecimal("COP");

        double divisaCopDouble = dolarCol.doubleValue();
            return divisaCopDouble;
    }
}


