package Ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class BasicPaymentProcessorTest {

    @Test
    void testProcessPaymentSuccess() {
        // Prepare test data
        double amount = 100.0;
        String paymentMethod = "Tarjeta de crédito";

        // Create BasicPaymentProcessor instance
        BasicPaymentProcessor paymentProcessor = new BasicPaymentProcessor();

        // Perform payment processing
        boolean result = paymentProcessor.processPayment(amount, paymentMethod);

        // Assertion
        assertTrue(result, "Payment processing should succeed");
    }

    @Test
    void testProcessPaymentFailure() {
        // Prepare test data
        double amount = 100.0;
        String invalidPaymentMethod = "Invalid payment method";

        // Create BasicPaymentProcessor instance
        BasicPaymentProcessor paymentProcessor = new BasicPaymentProcessor();

        // Perform payment processing with invalid payment method
        boolean result = paymentProcessor.processPayment(amount, invalidPaymentMethod);

        // Assertion
        assertFalse(result, "Payment processing should fail with invalid payment method");
    }

    @Test
    void testNegativeAmount() {
        // Prepare test data
        double negativeAmount = -50.0;
        String paymentMethod = "Tarjeta de crédito";

        // Create BasicPaymentProcessor instance
        BasicPaymentProcessor paymentProcessor = new BasicPaymentProcessor();

        // Perform payment processing with negative amount
        boolean result = paymentProcessor.processPayment(negativeAmount, paymentMethod);

        // Assertion
        assertFalse(result, "Payment processing should fail with negative amount");
    }
}
