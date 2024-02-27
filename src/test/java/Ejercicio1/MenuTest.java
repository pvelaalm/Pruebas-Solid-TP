package Ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

        @org.junit.jupiter.api.Test
        void mostrarMenu() {
            int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            Menu menu = new Menu(matriz);
            menu.mostrarMenu();
        }

        @org.junit.jupiter.api.Test
        void main() {
            int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            Menu menu = new Menu(matriz);
            menu.mostrarMenu();
        }

}