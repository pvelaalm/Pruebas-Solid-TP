package Ejercicio2;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<String> orders; // Lista para almacenar los pedidos
    private DataBaseManager dataBaseManager; // Gestor de base de datos
    private Authenticator authenticator; // Autenticador de usuarios

    public OrderManager(DataBaseManager dataBaseManager, Authenticator authenticator) {
        this.orders = new ArrayList<>();
        this.dataBaseManager = dataBaseManager;
        this.authenticator = authenticator;
    }

    // Método para crear un nuevo pedido
    public void createOrder(String username, String direccion, String pizza, int cantidad) {
        // Verificar la autenticación del usuario
        if (!authenticator.authenticate(username, direccion)) {
            System.out.println("Autenticación fallida. Usuario o contraseña incorrectos.");
            return;
        }

        // Validar datos del pedido
        if (!isValidOrder(username, direccion, pizza, cantidad)) {
            System.out.println("Pedido no válido. Verifique los datos ingresados.");
            return;
        }

        String newOrder = "Usuario: " + username + ", Dirección: " + direccion + ", Pizza: " + pizza + ", Cantidad: " + cantidad;
        orders.add(newOrder);

        // Insertar pedido en la base de datos
        try {
            dataBaseManager.insertPedido(username, direccion, pizza, cantidad);
        } catch (SQLException e) {
            System.err.println("Error al insertar el pedido en la base de datos: " + e.getMessage());
        }
    }

    // Método para actualizar un pedido existente
    public void updateOrder(int orderId, String nuevaDireccion, String nuevaPizza, int nuevaCantidad) {
        // Verificar si el pedido existe
        if (orderId < 0 || orderId >= orders.size()) {
            System.out.println("Pedido no encontrado");
            return;
        }

        // Obtener datos del pedido
        String order = orders.get(orderId);
        String[] parts = order.split(", ");
        String username = parts[0].split(": ")[1];

        // Verificar la autenticación del usuario
        if (!authenticator.authenticate(username, nuevaDireccion)) {
            System.out.println("Autenticación fallida. Usuario o contraseña incorrectos.");
            return;
        }

        // Actualizar datos del pedido
        orders.set(orderId, "Usuario: " + username + ", Dirección: " + nuevaDireccion + ", Pizza: " + nuevaPizza + ", Cantidad: " + nuevaCantidad);

        // Actualizar pedido en la base de datos
        try {
            dataBaseManager.updatePedido(orderId, nuevaDireccion);
        } catch (SQLException e) {
            System.err.println("Error al actualizar el pedido en la base de datos: " + e.getMessage());
        }
    }

    // Método para eliminar un pedido existente
    public void deleteOrder(int orderId) {
        // Verificar si el pedido existe
        if (orderId < 0 || orderId >= orders.size()) {
            System.out.println("Pedido no encontrado");
            return;
        }

        // Obtener datos del pedido
        String order = orders.remove(orderId);
        String[] parts = order.split(", ");
        String username = parts[0].split(": ")[1];
        String direccion = parts[1].split(": ")[1];

        // Verificar la autenticación del usuario
        if (!authenticator.authenticate(username, direccion)) {
            System.out.println("Autenticación fallida. Usuario o contraseña incorrectos.");
            return;
        }

        // Eliminar pedido de la base de datos
        try {
            dataBaseManager.deletePedido(orderId);
        } catch (SQLException e) {
            System.err.println("Error al eliminar el pedido de la base de datos: " + e.getMessage());
        }
    }

    // Método para imprimir todos los pedidos
    public void printAllOrders() {
        for (String order : orders) {
            System.out.println(order);
        }
    }

    // Método para validar los datos de un nuevo pedido
    private boolean isValidOrder(String username, String direccion, String pizza, int cantidad) {
        return username != null && !username.isEmpty() &&
                direccion != null && !direccion.isEmpty() &&
                pizza != null && !pizza.isEmpty() &&
                cantidad > 0;
    }
}
