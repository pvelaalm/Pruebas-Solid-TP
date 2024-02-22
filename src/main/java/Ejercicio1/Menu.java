package Ejercicio1;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Imprimir matriz original");
        System.out.println("2. Calcular matriz transpuesta");
        System.out.println("3. Salir");
    }

    public int obtenerOpcion() {
        System.out.print("Seleccione una opción: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Opción inválida. Intente de nuevo.");
            System.out.print("Seleccione una opción: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void ejecutarOpcion(int opcion, Matriz matriz, MatrizPrinter printer) {
        switch (opcion) {
            case 1:
                System.out.println("\nMatriz original:");
                matriz.imprimir(printer);
                break;
            case 2:
                System.out.println("\nMatriz transpuesta:");
                int[][] transpuesta = matriz.calcularTranspuesta();
                printer.imprimir(transpuesta);
                break;
            case 3:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    public void cerrarScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        int[][] datos = {{1, 2}, {3, 4}};
        Matriz matriz = new Matriz(datos);
        MatrizPrinter printer = new MatrizPrinter();
        Menu menu = new Menu();

        int opcion;
        do {
            menu.mostrarMenu();
            opcion = menu.obtenerOpcion();
            menu.ejecutarOpcion(opcion, matriz, printer);
        } while (opcion != 3);

        menu.cerrarScanner();
    }
}

