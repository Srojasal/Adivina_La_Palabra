package paqueteproyecto2;

public class FilasyColumnas {
    private char[][] tablero;

    public void crearTablero() {
        tablero = new char[7][5];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = '_';
            }
        }
    }

    public void modificarFila(int fila, String palabraIngresada) {
        if (palabraIngresada.length() != 5) {
            System.out.println("La palabra debe tener 5 letras.");
            return;
        }

        char[] caracteresArray = palabraIngresada.toCharArray();
        for (int i = 0; i < 5; i++) {
            tablero[fila][i] = caracteresArray[i];
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
