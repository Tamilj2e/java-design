package design_patterns.facade;

class InventoryService {
    public void reserveItem() {
        System.out.println("Inventory reserved");
    }
}
class PaymentService {
    public void pay() {
        System.out.println("Payment successful");
    }
}
class ShippingService {
    public void ship() {
        System.out.println("Order shipped");
    }
}
class NotificationService {
    public void notifyCustomer() {
        System.out.println("Customer notified");
    }
}
public class WithoutFacade {
    public static void main(String[] args) {

        InventoryService inventory = new InventoryService();
        PaymentService payment = new PaymentService();
        ShippingService shipping = new ShippingService();
        NotificationService notification = new NotificationService();

        inventory.reserveItem();
        payment.pay();
        shipping.ship();
        notification.notifyCustomer();
    }
}
