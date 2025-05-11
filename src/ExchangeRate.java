import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.time.Duration;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ExchangeRate {

    private static final String API_KEY = "TU_API_KEY";

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

            System.out.println("\nEncabezados:");
            response.headers().map().forEach((k, v) -> System.out.println(k + ": " + v));

            System.out.println("\nCuerpo (JSON plano):");
            System.out.println(response.body());


            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");

                System.out.println("\nTasas de cambio importantes:");
                System.out.println("1 USD = " + rates.get("ARS").getAsDouble() + " ARS");
                System.out.println("1 USD = " + rates.get("BRL").getAsDouble() + " BRL");
                System.out.println("1 USD = " + rates.get("COP").getAsDouble() + " COP");
            } else {
                System.out.println("Error al procesar la respuesta de la API.");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al conectar con la API:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getExchangeRates();
    }
}
