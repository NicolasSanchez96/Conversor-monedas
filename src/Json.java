import java.util.Map;

public class Json {
    String result;  // Resultado de la solicitud (success o error)
    String base_code;  // Moneda base (USD, EUR, etc.)
    Map<String, Double> conversion_rates;  // Mapa con las tasas de cambio
}
