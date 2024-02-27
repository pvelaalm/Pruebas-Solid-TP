package Ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DataBaseManagerTest {
    private DataBaseManager dataBaseManager;
    private Connection mockConnection;
    private PreparedStatement mockStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        mockStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Simulate connection creation
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockStatement);

        dataBaseManager = new DataBaseManager(mockConnection);
    }

    @Test
    void testInsertPedido() throws SQLException {
        // Simulate insertion
        assertDoesNotThrow(() -> dataBaseManager.insertPedido("Cliente1", "Dirección1", "Pizza1", 2));
    }

    @Test
    void testGetAllPedidos() throws SQLException {
        // Simulate retrieval
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        assertDoesNotThrow(() -> dataBaseManager.getAllPedidos());
    }

    @Test
    void testUpdatePedido() throws SQLException {
        // Simulate updating
        assertDoesNotThrow(() -> dataBaseManager.updatePedido(1, "Nueva Dirección"));
    }

    @Test
    void testDeletePedido() throws SQLException {
        // Simulate deletion
        assertDoesNotThrow(() -> dataBaseManager.deletePedido(1));
    }
}


