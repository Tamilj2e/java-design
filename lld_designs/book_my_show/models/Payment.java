package lld_designs.book_my_show.models;

import lld_designs.book_my_show.models.enums.PaymentMode;
import lld_designs.book_my_show.models.enums.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

public class Payment {
    private final String transactionId;
    private final PaymentStatus status;
    private final PaymentMode mode;
    private final BigDecimal totalAmount;

    public Payment(PaymentStatus status, PaymentMode mode, BigDecimal totalAmount) {
        transactionId = UUID.randomUUID().toString();
        this.status = status;
        this.mode = mode;
        this.totalAmount = totalAmount;
    }
}
