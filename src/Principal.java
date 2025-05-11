import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


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
                    double ars = usd1 * ExchangeRate.tasaARS;
                    System.out.println("Equivalente en ARS: " + ars);
                    break;

                case 2:
                    System.out.print("Ingrese cantidad en ARS: ");
                    double ars2 = scanner.nextDouble();
                    double usd2 = ars2 / ExchangeRate.tasaARS;
                    System.out.println("Equivalente en USD: " + usd2);
                    break;

                case 3:
                    System.out.print("Ingrese cantidad en USD: ");
                    double usd3 = scanner.nextDouble();
                    double brl = usd3 * ExchangeRate.tasaBRL;
                    System.out.println("Equivalente en BRL: " + brl);
                    break;

                case 4:
                    System.out.print("Ingrese cantidad en BRL: ");
                    double brl2 = scanner.nextDouble();
                    double usd4 = brl2 / ExchangeRate.tasaBRL;
                    System.out.println("Equivalente en USD: " + usd4);
                    break;

                case 5:
                    System.out.print("Ingrese cantidad en USD: ");
                    double usd5 = scanner.nextDouble();
                    double cop = usd5 * ExchangeRate.tasaCOP;
                    System.out.println("Equivalente en COP: " + cop);
                    break;

                case 6:
                    System.out.print("Ingrese cantidad en COP: ");
                    double cop2 = scanner.nextDouble();
                    double usd6 = cop2 / ExchangeRate.tasaCOP;
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


