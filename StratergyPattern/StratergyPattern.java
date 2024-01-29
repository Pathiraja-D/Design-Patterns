package StratergyPattern;

// Strategy interface
interface PaymentStrategy {
    void processPayment(double amount);
}

// Concrete strategy classes
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount +
                " with card number " + cardNumber +
                " and expiry date " + expiryDate);
        // Implementation of credit card payment processing
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount +
                " with email " + email);
        // Implementation of PayPal payment processing
    }
}

// Context class
class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}

public class StratergyPattern {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.setPaymentStrategy(new CreditCardPayment("dsd","12/12"));
        paymentProcessor.processPayment(100);

        paymentProcessor.setPaymentStrategy(new PayPalPayment(""));
        paymentProcessor.processPayment(200);
    }
}
