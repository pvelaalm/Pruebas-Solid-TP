package Ejercicio2;

public class BasicPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount, String paymentMethod) {
        // Lógica de procesamiento de pagos básica
        System.out.println("Pago de " + amount + " procesado exitosamente mediante " + paymentMethod);
        return true;
    }
}
