import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ExchangeRate {

    // Reemplaza con tu propia clave API
    private static final String API_KEY = "3738619d8d6d18c2de64f758";

    // Método para obtener las tasas de conversión
    public static Map<String, Double> getConversionRates(String baseCurrency) throws Exception {
        // URL para consultar la API de tasas de cambio con la clave y la moneda base
        String apiUrl = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, baseCurrency);

        // Crear conexión HTTP
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Leer la respuesta de la API
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        reader.close();

        // Usar Gson para convertir el JSON a un objeto Java
        Gson gson = new Gson();
        Json response = gson.fromJson(json.toString(), Json.class);

        // Verificar si la respuesta fue exitosa
        if (!"success".equalsIgnoreCase(response.result)) {
            throw new RuntimeException("No se pudo obtener la tasa de cambio.");
        }

        // Retornar el mapa de tasas de conversión
        return response.conversion_rates;
    }
}
