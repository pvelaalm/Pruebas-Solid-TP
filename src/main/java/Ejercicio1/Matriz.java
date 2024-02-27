package Ejercicio1;

public class Matriz {
    private int[][] matriz;

    // Constructor que recibe una instancia de MatrizPrinter para imprimir la matriz
    public Matriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
