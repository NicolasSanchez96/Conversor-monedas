import java.util.Scanner;

public class Principal {


    public static double convertirUSDtoARS(double montoUSD) {
        return montoUSD * ExchangeRate.tasaARS;
    }

    public static double convertirARStoUSD(double montoARS) {
        return montoARS / ExchangeRate.tasaARS;
    }

    public static double convertirUSDtoBRL(double montoUSD) {
        return montoUSD * ExchangeRate.tasaBRL;
    }

    public static double convertirBRLtoUSD(double montoBRL) {
        return montoBRL / ExchangeRate.tasaBRL;
    }

    public static double convertirUSDtoCOP(double montoUSD) {
        return montoUSD * ExchangeRate.tasaCOP;
    }

    public static double convertirCOPtoUSD(double montoCOP) {
        return montoCOP / ExchangeRate.tasaCOP;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cargar tasas desde la API
        ExchangeRate.getExchangeRates();

        int opcion;

        do {
            System.out.println("\nBienvenido al conversor de monedas:");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese cantidad en USD: ");
                    double usd1 = scanner.nextDouble();
                    double ars = convertirUSDtoARS(usd1);
                    System.out.println("Equivalente en ARS: " + ars);
                    break;

                case 2:
                    System.out.print("Ingrese cantidad en ARS: ");
                    double ars2 = scanner.nextDouble();
                    double usd2 = convertirARStoUSD(ars2);
                    System.out.println("Equivalente en USD: " + usd2);
                    break;

                case 3:
                    System.out.print("Ingrese cantidad en USD: ");
                    double usd3 = scanner.nextDouble();
                    double brl = convertirUSDtoBRL(usd3);
                    System.out.println("Equivalente en BRL: " + brl);
                    break;

                case 4:
                    System.out.print("Ingrese cantidad en BRL: ");
                    double brl2 = scanner.nextDouble();
                    double usd4 = convertirBRLtoUSD(brl2);
                    System.out.println("Equivalente en USD: " + usd4);
                    break;

                case 5:
                    System.out.print("Ingrese cantidad en USD: ");
                    double usd5 = scanner.nextDouble();
                    double cop = convertirUSDtoCOP(usd5);
                    System.out.println("Equivalente en COP: " + cop);
                    break;

                case 6:
                    System.out.print("Ingrese cantidad en COP: ");
                    double cop2 = scanner.nextDouble();
                    double usd6 = convertirCOPtoUSD(cop2);
                    System.out.println("Equivalente en USD: " + usd6);
                    break;

                case 7:
                    System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 7);

        scanner.close();
    }
}


