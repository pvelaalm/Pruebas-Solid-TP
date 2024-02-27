package Ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

public class PaymentProcessorTest {
    private PaymentProcessor paymentProcessor;

    @BeforeEach
    void setUp() {
        paymentProcessor = new BasicPaymentProcessor();
    }

    @Test
    void testProcessPaymentSuccess() {
        assertTrue(paymentProcessor.processPayment(100.0, "credit_card"));
    }

    @Test
    void testProcessPaymentFailure() {
        assertFalse(paymentProcessor.processPayment(0.0, "credit_card"));
    }
}
