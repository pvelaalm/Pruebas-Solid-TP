package Ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

class MatrizPrinterTest {
    @org.junit.jupiter.api.Test
    void imprimir() {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrizPrinter matrizPrinter = new MatrizPrinter();
        matrizPrinter.imprimir(matriz);
    }

}