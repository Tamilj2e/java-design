package lld_designs.book_my_show.strategy.payment;

import lld_designs.book_my_show.models.Payment;
import lld_designs.book_my_show.models.enums.PaymentMode;
import lld_designs.book_my_show.models.enums.PaymentStatus;

import java.math.BigDecimal;

public interface PaymentStrategy {
    Payment pay(BigDecimal amount,String userId);
}
