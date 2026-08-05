package design_patterns.proxy;

import lld_designs.book_my_show.models.Payment;
import lld_designs.book_my_show.models.enums.PaymentMode;

import java.math.BigDecimal;

public class PaymentService {

    public void pay(){
        System.out.println("paid by payment service");
    }

}
