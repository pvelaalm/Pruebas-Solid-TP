package Ejercicio2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Crear el contexto de Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Obtener los beans de las clases de servicios
        OrderManager orderManager = context.getBean(OrderManager.class);
        Authenticator authenticator = context.getBean(Authenticator.class);
        PaymentProcessor paymentProcessor = context.getBean(PaymentProcessor.class);

        // Ejemplo de uso de las clases con las dependencias inyectadas
        String orderId = "123";
        String orderDetails = "Pizza Margarita, tamaño grande";
        orderManager.createOrder(orderDetails);
        orderManager.updateOrder(orderId, "Pizza Margarita, tamaño mediano");
        orderManager.deleteOrder(orderId);

        String username = "usuario";
        String password = "contraseña";
        boolean isAuthenticated = authenticator.authenticate(username, password);

        double amount = 20.50;
        String paymentDetails = "Tarjeta de crédito";
        boolean isPaymentProcessed = paymentProcessor.processPayment(amount, paymentDetails);

        // Cerrar el contexto de Spring
        context.close();
    }
}

