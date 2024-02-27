package Ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

public class OrderManagerTest {
    private OrderManager orderManager;
    private DataBaseManager mockDataBaseManager;
    private Authenticator mockAuthenticator;

    @BeforeEach
    void setUp() {
        mockDataBaseManager = mock(DataBaseManager.class);
        mockAuthenticator = mock(Authenticator.class);
        orderManager = new OrderManager(mockDataBaseManager, mockAuthenticator);
    }

    @Test
    void testCreateOrder() throws SQLException {
        // Configurar el autenticador para que devuelva true (autenticación exitosa)
        when(mockAuthenticator.authenticate(anyString(), anyString())).thenReturn(true);

        // Ejecutar el método createOrder()
        orderManager.createOrder("usuario1", "direccion1", "pizza1", 2);

        // Verificar que se llamó al método insertPedido del mock de DataBaseManager
        verify(mockDataBaseManager, times(1)).insertPedido(anyString(), anyString(), anyString(), anyInt());
    }

    @Test
    void testUpdateOrder() throws SQLException {
        // Configurar el autenticador para que devuelva true (autenticación exitosa)
        when(mockAuthenticator.authenticate(anyString(), anyString())).thenReturn(true);

        // Configurar el tamaño de la lista de pedidos simulados en el OrderManager
        orderManager.createOrder("usuario1", "direccion1", "pizza1", 2);

        // Ejecutar el método updateOrder()
        orderManager.updateOrder(0, "nuevaDireccion", "nuevaPizza", 3);

        // Verificar que se llamó al método updatePedido del mock de DataBaseManager
        verify(mockDataBaseManager, times(1)).updatePedido(anyInt(), anyString());
    }

    @Test
    void testDeleteOrder() throws SQLException {
        // Configurar el autenticador para que devuelva true (autenticación exitosa)
        when(mockAuthenticator.authenticate(anyString(), anyString())).thenReturn(true);

        // Configurar el tamaño de la lista de pedidos simulados en el OrderManager
        orderManager.createOrder("usuario1", "direccion1", "pizza1", 2);

        // Ejecutar el método deleteOrder()
        orderManager.deleteOrder(0);

        // Verificar que se llamó al método deletePedido del mock de DataBaseManager
        verify(mockDataBaseManager, times(1)).deletePedido(anyInt());
    }
}
