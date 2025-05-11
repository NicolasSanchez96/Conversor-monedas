import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Bienvenido al conversor de monedas:");
            System.out.println("1) Dólar ==> Peso Argentino");
            System.out.println("2) Peso Argentino ==> Dólar");
            System.out.println("3) Dólar ==> Real Brasileño");
            System.out.println("4) Real Brasileño ==> Dólar");
            System.out.println("5) Dólar ==> Peso Colombiano");
            System.out.println("6) Peso Colombiano ==> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");


            int opcion = scanner.nextInt();


            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto en dólares: ");
                    double montoDolar1 = scanner.nextDouble();
                    double resultado1 = montoDolar1 * 84.63;
                    System.out.println("$ " + montoDolar1 + " USD = " + resultado1 + " ARS");
                    break;

                case 2:
                    System.out.print("Ingrese el monto en pesos argentinos: ");
                    double montoPeso1 = scanner.nextDouble();
                    double resultado2 = montoPeso1 / 84.63;
                    System.out.println("$ " + montoPeso1 + " ARS = " + resultado2 + " USD");
                    break;

                case 3:
                    System.out.print("Ingrese el monto en dólares: ");
                    double montoDolar2 = scanner.nextDouble();
                    double resultado3 = montoDolar2 * 5.43;
                    System.out.println("$ " + montoDolar2 + " USD = " + resultado3 + " BRL");
                    break;

                case 4:
                    System.out.print("Ingrese el monto en reales brasileños: ");
                    double montoReal = scanner.nextDouble();
                    double resultado4 = montoReal / 5.43;
                    System.out.println("$ " + montoReal + " BRL = " + resultado4 + " USD");
                    break;

                case 5:
                    System.out.print("Ingrese el monto en dólares: ");
                    double montoDolar3 = scanner.nextDouble();
                    double resultado5 = montoDolar3 * 3600.50;
                    System.out.println("$ " + montoDolar3 + " USD = " + resultado5 + " COP");
                    break;

                case 6:
                    System.out.print("Ingrese el monto en pesos colombianos: ");
                    double montoPeso2 = scanner.nextDouble();
                    double resultado6 = montoPeso2 / 3600.50;
                    System.out.println("$ " + montoPeso2 + " COP = " + resultado6 + " USD");
                    break;

                case 7:
                    System.out.println("¡Gracias por usar el conversor de monedas! Adiós.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, elija una opción entre 1 y 7.");
            }
        }
    }
}
