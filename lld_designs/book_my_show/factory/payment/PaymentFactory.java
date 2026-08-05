package lld_designs.book_my_show.factory.payment;

import lld_designs.book_my_show.models.Payment;
import lld_designs.book_my_show.models.enums.PaymentMode;
import lld_designs.book_my_show.strategy.payment.CrediCardPayment;
import lld_designs.book_my_show.strategy.payment.DebitCardPayment;
import lld_designs.book_my_show.strategy.payment.PaymentStrategy;
import lld_designs.book_my_show.strategy.payment.UPIPaymentStrategy;

public class PaymentFactory {
    public static PaymentStrategy getStrategy(PaymentMode mode){
        if(mode==PaymentMode.UPI){
            return new UPIPaymentStrategy();
        }else if(mode == PaymentMode.CREDIT_CARD){
            return new CrediCardPayment();
        }else if(mode == PaymentMode.DEBIT_CARD){
            return new DebitCardPayment();
        }else{
            return null;
        }
    }
}
