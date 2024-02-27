package Ejercicio1;

import java.util.Scanner;

public class Menu {
    private Matriz matriz;
    private MatrizPrinter matrizPrinter;
    private MatrizTraspuesta matrizTraspuesta;

    public Menu(int[][] matriz) {
        this.matriz = new Matriz(matriz);
        this.matrizPrinter = new MatrizPrinter();
        this.matrizTraspuesta = new MatrizTraspuesta();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===== Menú =====");
            System.out.println("1. Imprimir Matriz");
            System.out.println("2. Calcular Matriz Transpuesta");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Matriz:");
                    matrizPrinter.imprimir(matriz.getMatriz());
                    break;
                case 2:
                    System.out.println("Matriz Transpuesta:");
                    int[][] transpuesta = matrizTraspuesta.calcularTranspuesta(matriz.getMatriz());
                    matrizPrinter.imprimir(transpuesta);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Menu menu = new Menu(matriz);
        menu.mostrarMenu();
    }
}


