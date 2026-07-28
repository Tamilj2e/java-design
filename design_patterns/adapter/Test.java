package design_patterns.adapter;

interface PaymentGateway{
    void pay();
}

//third party api
class RazarApi{
    void makePayment(){
        System.out.println("you paid through razor");
    }
}

class Adaptor implements PaymentGateway{
    private RazarApi razarApi;
    public Adaptor(RazarApi razarApi){
        this.razarApi = razarApi;
    }
    @Override
    public void pay() {
        razarApi.makePayment();
    }
}
public class Test {
    public static void main(String[] args) {
        PaymentGateway gateway = new Adaptor(new RazarApi());
        gateway.pay();
    }
}



/*



The Adapter Pattern is used when two classes/interfaces are incompatible,
 but you want them to work together without modifying their source code.

Think of it as a translator.

Real-life example

Imagine you have:

Indian socket → 3-pin
US charger → 2-pin

They don't fit.

You use an adapter.
 */