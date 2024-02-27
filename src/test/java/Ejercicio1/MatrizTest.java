package Ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

class MatrizTest {
    @org.junit.jupiter.api.Test
    void getMatriz() {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matriz matriz1 = new Matriz(matriz);
        assertArrayEquals(matriz, matriz1.getMatriz());
    }

}