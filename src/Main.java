import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        double dolarBras;
        double dolarArg;
        double dolarCol;
        int opcion = 0;
        double ValorConvertir = 0;

        String moneda;

        String menu = """
                \n*** Sea bienvenido(a) al conversor de moneda ***
                1 - Dólar =>> Peso argentino
                2 - Peso argentino =>> Dólar
                3 - Dólar =>> Real brasileño
                4 - Real brasileño =>> Dólar
                5 - Dólar =>> Peso colombiano
                6 - Peso colombiano =>> Dólar
                7 - Salir
                """;

        Scanner teclado = new Scanner(System.in);

        while (opcion != 7) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    API monedaUSDARS = new API();
                        dolarArg = monedaUSDARS.consumeApiARS();
                    System.out.println("Ingrese el valor en dólares: ");
                    ValorConvertir = teclado.nextDouble();
                    System.out.printf("Su valor en pesos argentinos es: %.2f", (ValorConvertir * dolarArg));
                    break;
                case 2:
                    API monedaARSUSD = new API();
                        dolarArg = monedaARSUSD.consumeApiARS();
                    System.out.println("Ingrese el valor en pesos argentinos: ");
                    ValorConvertir = teclado.nextDouble();
                    System.out.printf("Su valor en dólares es: %.2f", (ValorConvertir / dolarArg));
                    break;
                case 3:
                    API monedaUSDBRL = new API();
                        dolarBras = monedaUSDBRL.consumeApiBRL();
                    System.out.println("Ingrese el valor en dólares: ");
                    ValorConvertir = teclado.nextDouble();
                    System.out.printf("Su valor en reales brasileños es: %.2f", ValorConvertir * dolarBras);
                    break;
                case 4:
                    API monedaBRLUSD = new API();
                        dolarBras = monedaBRLUSD.consumeApiBRL();
                    System.out.println("Ingrese el valor en reales brasileños: ");
                    ValorConvertir = teclado.nextDouble();
                    System.out.printf("Su valor en dólares es: %.2f", (ValorConvertir / dolarBras));
                    break;
                case 5:
                    API monedaUSDCOP = new API();
                        dolarCol = monedaUSDCOP.consumeApiCOP();
                    System.out.println("Ingrese el valor en dólares: ");
                    ValorConvertir = teclado.nextDouble();
                    System.out.printf("Su valor en pesos colombianos es: %.2f", (ValorConvertir * dolarCol));
                    break;
                case 6:
                    API monedaCOPUSD = new API();
                        dolarCol = monedaCOPUSD.consumeApiCOP();
                    System.out.println("Ingrese el valor en pesos colombianos: ");
                    ValorConvertir = teclado.nextDouble();
                    System.out.printf("Su valor en dólares es: %.2f", (ValorConvertir / dolarCol));
                    break;
                case 7:
                    System.out.println("Saliendo del conversor. Gracias por preferirnos");
                    break;
                default:
                    System.out.println("Opción inválida. Digite un número del 1 al 7");
                    break;
            }
        }
    }
}
