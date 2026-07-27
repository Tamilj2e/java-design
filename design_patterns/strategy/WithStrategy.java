package design_patterns.strategy;

interface PaymentStrategy{
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("paid amount "+amount);
    }
}

class Cart{

    void processAmount(PaymentStrategy strategy, double amount){
        strategy.pay(amount);
    }
}
public class WithStrategy {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.processAmount(new CreditCardPayment(),100);
    }
}
