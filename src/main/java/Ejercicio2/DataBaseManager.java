package Ejercicio2;


// Clase para manejar la conexión con la base de datos y realizar operaciones CRUD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseManager {
    private Connection connection;

    public DataBaseManager(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public DataBaseManager(Connection mockConnection) {
        this.connection = mockConnection;
    }

    // Método para insertar un nuevo pedido en la base de datos
    public void insertPedido(String nombreCliente, String direccion, String pizza, int cantidad) throws SQLException {
        String sql = "INSERT INTO pedidos (nombre_cliente, direccion, pizza, cantidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombreCliente);
            statement.setString(2, direccion);
            statement.setString(3, pizza);
            statement.setInt(4, cantidad);
            statement.executeUpdate();
        }
    }

    // Método para obtener todos los pedidos de la base de datos
    public ResultSet getAllPedidos() throws SQLException {
        String sql = "SELECT * FROM pedidos";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            return statement.executeQuery();
        }
    }

    // Método para actualizar un pedido en la base de datos
    public void updatePedido(int id, String nuevaDireccion) throws SQLException {
        String sql = "UPDATE pedidos SET direccion = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevaDireccion);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

    // Método para eliminar un pedido de la base de datos
    public void deletePedido(int id) throws SQLException {
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Método para cerrar la conexión con la base de datos
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}


