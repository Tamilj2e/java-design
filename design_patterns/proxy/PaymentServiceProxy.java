package design_patterns.proxy;

public class PaymentServiceProxy {
    private PaymentService realTarget;

    public PaymentServiceProxy(PaymentService service){
        this.realTarget = service;
    }

    public void pay(){
        System.out.println("request came to proxy, calling real target");
        realTarget.pay();
    }
}
