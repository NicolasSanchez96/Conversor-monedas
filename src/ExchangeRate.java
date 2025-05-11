import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.time.Duration;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRate {

    private static final String API_KEY = "3738619d8d6d18c2de64f758";


    public static double tasaARS;
    public static double tasaBRL;
    public static double tasaCOP;

    public static void getExchangeRates() {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .header("Accept", "application/json")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("== RESPUESTA DE LA API ==");
            System.out.println("Código de estado: " + response.statusCode());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");


                tasaARS = rates.get("ARS").getAsDouble();
                tasaBRL = rates.get("BRL").getAsDouble();
                tasaCOP = rates.get("COP").getAsDouble();


                System.out.println("\nTasas de cambio importantes:");
                System.out.println("1 USD = " + tasaARS + " ARS");
                System.out.println("1 USD = " + tasaBRL + " BRL");
                System.out.println("1 USD = " + tasaCOP + " COP");

            } else {
                System.out.println("Error al procesar la respuesta de la API.");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al conectar con la API:");
            e.printStackTrace();
        }
    }
}
