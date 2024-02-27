package Ejercicio2;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Inicializar scanner para entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Inicializar mapa de usuarios (puedes inicializarlo con tus usuarios y contraseñas)
        Map<String, String> users = new HashMap<>();
        users.put("usuario1", "password1");
        users.put("usuario2", "password2");

        // Inicializar el almacenamiento de usuarios con el mapa de usuarios
        UserStorage userStorage = new HashMapUserStorage(users);

        // Inicializar autenticador con el almacenamiento de usuarios
        Authenticator authenticator = new Authenticator(userStorage);

        // Inicializar objetos necesarios para gestión de pedidos
        DataBaseManager dataBaseManager = null;
        OrderManager orderManager = null;
        PaymentProcessor paymentProcessor = new BasicPaymentProcessor();

        String username = "";
        // Menú de opciones
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear pedido");
            System.out.println("3. Actualizar pedido");
            System.out.println("4. Eliminar pedido");
            System.out.println("5. Procesar pago");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Iniciar sesión
                    System.out.print("Ingrese su nombre de usuario: ");
                    username = scanner.next();
                    System.out.print("Ingrese su contraseña: ");
                    String password = scanner.next();
                    if (authenticator.authenticate(username, password)) {
                        System.out.println("Inicio de sesión exitoso.");
                        // Inicializar objetos después de la autenticación
                        try {
                            dataBaseManager = new DataBaseManager("url", "username", "password");
                            orderManager = new OrderManager(dataBaseManager, authenticator);
                        } catch (SQLException e) {
                            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Inicio de sesión fallido. Usuario o contraseña incorrectos.");
                    }
                    break;
                case 2:
                    // Crear pedido
                    if (orderManager != null) {
                        System.out.print("Ingrese la dirección de entrega: ");
                        String direccion = scanner.next();
                        System.out.print("Ingrese el tipo de pizza: ");
                        String pizza = scanner.next();
                        System.out.print("Ingrese la cantidad: ");
                        int cantidad = scanner.nextInt();
                        orderManager.createOrder(username, direccion, pizza, cantidad);
                    } else {
                        System.out.println("Debe iniciar sesión primero.");
                    }
                    break;
                case 3:
                    // Actualizar pedido
                    if (orderManager != null) {
                        System.out.print("Ingrese el ID del pedido a actualizar: ");
                        int orderId = scanner.nextInt();
                        System.out.print("Ingrese la nueva dirección de entrega: ");
                        String nuevaDireccion = scanner.next();
                        System.out.print("Ingrese el nuevo tipo de pizza: ");
                        String nuevaPizza = scanner.next();
                        System.out.print("Ingrese la nueva cantidad: ");
                        int nuevaCantidad = scanner.nextInt();
                        orderManager.updateOrder(orderId, nuevaDireccion, nuevaPizza, nuevaCantidad);
                    } else {
                        System.out.println("Debe iniciar sesión primero.");
                    }
                    break;
                case 4:
                    // Eliminar pedido
                    if (orderManager != null) {
                        System.out.print("Ingrese el ID del pedido a eliminar: ");
                        int orderId = scanner.nextInt();
                        orderManager.deleteOrder(orderId);
                    } else {
                        System.out.println("Debe iniciar sesión primero.");
                    }
                    break;
                case 5:
                    // Procesar pago
                    if (orderManager != null) {
                        System.out.print("Ingrese el monto a pagar: ");
                        double amount = scanner.nextDouble();
                        System.out.print("Ingrese el método de pago: ");
                        String paymentMethod = scanner.next();
                        if (paymentProcessor.processPayment(amount, paymentMethod)) {
                            System.out.println("Pago procesado exitosamente.");
                        } else {
                            System.out.println("Error al procesar el pago.");
                        }
                    } else {
                        System.out.println("Debe iniciar sesión primero.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 6);

        // Cerrar scanner
        scanner.close();
    }
}