package lld_designs.book_my_show.strategy.payment;

import lld_designs.book_my_show.models.Payment;
import lld_designs.book_my_show.models.enums.PaymentMode;
import lld_designs.book_my_show.models.enums.PaymentStatus;

import java.math.BigDecimal;

public class UPIPaymentStrategy implements PaymentStrategy{



    @Override
    public Payment pay(BigDecimal amount, String userId) {
        System.out.println(userId +" user paid amount "+amount);
        return new Payment(PaymentStatus.SUCCESS,PaymentMode.UPI,amount);
    }
}
