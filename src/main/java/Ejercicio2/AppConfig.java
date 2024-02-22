package Ejercicio2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public DataBaseManager dataBaseManager() {
        return new DataBaseManager();
    }

    @Bean
    public Authenticator authenticator() {
        return new Authenticator();
    }

    @Bean
    public OrderManager orderManager(DataBaseManager dataBaseManager) {
        return new OrderManager(dataBaseManager);
    }

    @Bean
    public PaymentProcessor paymentProcessor() {
        return new PaymentProcessor();
    }
}

