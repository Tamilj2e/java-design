package design_patterns.facade;

class OrderFacade {

    private InventoryService inventory = new InventoryService();
    private PaymentService payment = new PaymentService();
    private ShippingService shipping = new ShippingService();
    private NotificationService notification = new NotificationService();

    public void placeOrder() {

        inventory.reserveItem();
        payment.pay();
        shipping.ship();
        notification.notifyCustomer();
    }
}

public class WithFacade {
    public static void main(String[] args) {

        OrderFacade facade = new OrderFacade();

        facade.placeOrder();
    }
}
