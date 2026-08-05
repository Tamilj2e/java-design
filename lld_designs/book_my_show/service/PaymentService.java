package lld_designs.book_my_show.service;

import lld_designs.book_my_show.factory.payment.PaymentFactory;
import lld_designs.book_my_show.models.Payment;
import lld_designs.book_my_show.models.enums.PaymentMode;
import lld_designs.book_my_show.strategy.payment.PaymentStrategy;

import java.math.BigDecimal;

public class PaymentService {


    public Payment pay(String userId, BigDecimal total, PaymentMode mode) {
        PaymentStrategy strategy = PaymentFactory.getStrategy(mode);
        if(strategy!=null)
           return strategy.pay(total,userId);
        return null;
    }
}
