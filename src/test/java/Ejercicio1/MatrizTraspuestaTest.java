package Ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

class MatrizTraspuestaTest {
    @org.junit.jupiter.api.Test
    void calcularTranspuesta() {
        MatrizTraspuesta matrizTraspuesta = new MatrizTraspuesta();
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transpuesta = matrizTraspuesta.calcularTranspuesta(matriz);
        int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(expected, transpuesta);
    }

}