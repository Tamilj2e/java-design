package design_patterns.proxy;

//consider this as rest Controller
public class Controller {

    private PaymentServiceProxy proxy;
    public Controller(PaymentServiceProxy proxy){
        this.proxy = proxy;
    }

    public void pay(){
        proxy.pay();
    }

    public static void main(String[] args) {
        Controller controller = new Controller(new PaymentServiceProxy(new PaymentService()));
        controller.pay();

    }


}
