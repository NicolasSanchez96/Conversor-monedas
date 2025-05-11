import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class ExchangeRate {


    private static final String API_KEY = "3738619d8d6d18c2de64f758";


    public static void getExchangeRates() {

        HttpClient client = HttpClient.newHttpClient();


        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .build();

        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            if (response.statusCode() == 200) {

                System.out.println("Respuesta de la API: " + response.body());


                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);


                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");


                System.out.println("Tasas de cambio:");
                System.out.println("1 USD = " + conversionRates.get("ARS").getAsDouble() + " Peso Argentino");
                System.out.println("1 USD = " + conversionRates.get("BRL").getAsDouble() + " Real Brasileño");
                System.out.println("1 USD = " + conversionRates.get("COP").getAsDouble() + " Peso Colombiano");
            } else {
                System.out.println("Error al obtener datos. Código de estado: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        getExchangeRates();
    }
}

