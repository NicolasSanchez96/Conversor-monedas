import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        // Mostrar el menú de opciones
        do {
            System.out.println("Bienvenido al conversor de monedas:");
            System.out.println("1) Dólar ==> Peso Argentino");
            System.out.println("2) Peso Argentino ==> Dólar");
            System.out.println("3) Dólar ==> Real Brasileño");
            System.out.println("4) Real Brasileño ==> Dólar");
            System.out.println("5) Dólar ==> Peso Colombiano");
            System.out.println("6) Peso Colombiano ==> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");
            option = scanner.nextInt();

            // Ejecutar según la opción seleccionada
            switch (option) {
                case 1:
                    convertirMoneda("USD", "ARS", scanner); // Dólar a Peso Argentino
                    break;
                case 2:
                    convertirMoneda("ARS", "USD", scanner); // Peso Argentino a Dólar
                    break;
                case 3:
                    convertirMoneda("USD", "BRL", scanner); // Dólar a Real Brasileño
                    break;
                case 4:
                    convertirMoneda("BRL", "USD", scanner); // Real Brasileño a Dólar
                    break;
                case 5:
                    convertirMoneda("USD", "COP", scanner); // Dólar a Peso Colombiano
                    break;
                case 6:
                    convertirMoneda("COP", "USD", scanner); // Peso Colombiano a Dólar
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (option != 7);
    }

    // Método para convertir monedas
    private static void convertirMoneda(String fromCurrency, String toCurrency, Scanner scanner) {
        System.out.print("Ingrese la cantidad a convertir de " + fromCurrency + " a " + toCurrency + ": ");
        double amount = scanner.nextDouble();

        try {
            // Llamamos al servicio para obtener las tasas de conversión
            Map<String, Double> rates = ExchangeRate.getConversionRates(fromCurrency);

            if (rates.containsKey(toCurrency)) {
                double rate = rates.get(toCurrency);
                double converted = amount * rate;
                System.out.printf("Resultado: %.2f %s\n", converted, toCurrency);
            } else {
                System.out.println("Moneda de destino no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error en la conversión: " + e.getMessage());
        }
    }
}
