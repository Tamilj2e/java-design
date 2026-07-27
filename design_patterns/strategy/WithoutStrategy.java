package design_patterns.strategy;


class ShoppingCart{
    public void pay(String type,double amount){
        if(type.equals("gpay")){
             System.out.println("payment debited from gpay");
             return;
        }else if(type.equals("card")){
            System.out.println("payment debited from card");
            return;
        }
          throw new IllegalArgumentException("invalid type");
    }
}
public class WithoutStrategy {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.pay("card",100.00);
    }
}

/*
What's the problem?

Suppose you add more states.

        IDLE
        CARD_INSERTED
AUTHENTICATED
        DISPENSE
OUT_OF_SERVICE
        MAINTENANCE
CARD_BLOCKED
        TRANSACTION_CANCELLED

Now every method becomes larger.



 */
