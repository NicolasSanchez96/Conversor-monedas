import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Json {

    public static void filtrarMonedas(String json) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();


        if (!jsonObject.get("result").getAsString().equals("success")) {
            System.out.println("Respuesta de la API no exitosa.");
            return;
        }


        JsonObject tasas = jsonObject.getAsJsonObject("conversion_rates");


        double tasaARS = tasas.get("ARS").getAsDouble();
        double tasaBRL = tasas.get("BRL").getAsDouble();
        double tasaCOP = tasas.get("COP").getAsDouble();


        System.out.println("Tasa de USD a ARS: " + tasaARS);
        System.out.println("Tasa de USD a BRL: " + tasaBRL);
        System.out.println("Tasa de USD a COP: " + tasaCOP);
    }
}
