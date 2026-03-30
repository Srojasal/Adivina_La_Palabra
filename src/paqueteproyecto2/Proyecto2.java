package paqueteproyecto2;

import java.util.Random;
import java.util.Scanner;

public class Proyecto2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        System.out.println("Bienvenido a Palabreando.");
        System.out.println("Indica el proceso a realizar");

        while (opcion != 2) {
            System.out.println("1. Iniciar partida");
            System.out.println("2. Salir de la partida");

            if (!entrada.hasNextInt()) {
                System.out.println("Debes ingresar un numero valido.");
                entrada.nextLine();
                continue;
            }

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    iniciarPartida(entrada);
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    System.out.println("Gracias por jugar PALABREANDO");
                    System.out.println("Hasta la proxima");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }

        entrada.close();
    }

    public static void iniciarPartida(Scanner entrada) {
        String[] palabras = bancoPalabras();
        Random random = new Random();
        String palabraSecreta = palabras[random.nextInt(palabras.length)];
        FilasyColumnas tablero = new FilasyColumnas();
        tablero.crearTablero();

        System.out.println("Adivina la palabra de 5 letras.");

        for (int intento = 0; intento < 7; intento++) {
            tablero.imprimirTablero();
            System.out.print("Intento " + (intento + 1) + ": ");
            if (!entrada.hasNextLine()) {
                System.out.println("Entrada finalizada. Se cancela la partida.");
                return;
            }
            String palabraIngresada = entrada.nextLine().trim().toLowerCase();

            if (palabraIngresada.length() != 5) {
                System.out.println("La palabra debe tener exactamente 5 letras.");
                intento--;
                continue;
            }

            tablero.modificarFila(intento, palabraIngresada);

            if (palabraIngresada.equals(palabraSecreta)) {
                tablero.imprimirTablero();
                System.out.println("Adivinaste la palabra.");
                return;
            }
        }

        tablero.imprimirTablero();
        System.out.println("No adivinaste. La palabra era: " + palabraSecreta);
    }

    public static String[] bancoPalabras() {
        return new String[] {
            "arcos", "aleta", "campo", "hogar", "verde",
            "actor", "agudo", "fallo", "brazo", "carro",
            "queda", "datos", "dulce", "altar", "finca",
            "error", "fresa", "huevo", "juego", "cable",
            "mango", "arena", "bicho", "bizco", "busca",
            "calma", "cerca", "chile", "denso", "china"
        };
    }
}
