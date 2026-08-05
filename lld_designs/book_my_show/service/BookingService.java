package lld_designs.book_my_show.service;

import lld_designs.book_my_show.models.*;
import lld_designs.book_my_show.models.enums.BookingStatus;
import lld_designs.book_my_show.models.enums.PaymentMode;
import lld_designs.book_my_show.models.enums.SeatStatus;
import lld_designs.book_my_show.strategy.amount.AmountStrategy;
import lld_designs.book_my_show.strategy.amount.WeekDaysStrategy;
import lld_designs.book_my_show.strategy.amount.WeekendStrategy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BookingService {
    private SeatLockHelper lockHelper = new SeatLockHelper();
    private static final Object lock = new Object();
    private static BookingService instance;

    private PaymentService paymentService;

    private BookingService(){
        paymentService = new PaymentService();
    }
    public static BookingService getInstance() {
        if(instance==null){
            synchronized (lock){
                if(instance==null){
                    instance = new BookingService();

                }
            }
        }
        return instance;
    }

    public Optional<Booking> bookShow(Show show, List<ShowSeat> seatList, PaymentMode mode,User user,boolean weekend){
        boolean lockStatus = lockHelper.lock(show,seatList,user.getUserId());

        if(!lockStatus){
            System.out.println("seat not available");
            return Optional.empty();
        }
        AmountStrategy amountStrategy = weekend? new WeekendStrategy():new WeekDaysStrategy();
        BigDecimal total = amountStrategy.calcAmount(show,seatList);
        Booking booking = new Booking.Builder().setUser(user).setMovie(show.getMovie()).setSeat(seatList)
                .setTotalAmount(total).build();
        Payment payment = paymentService.pay(user.getUserId(),total,mode);
        lockHelper.unlock(show,user.getUserId());

        if(Objects.isNull(payment)) {
            booking.setBookingStatus(BookingStatus.FAILED);
            return Optional.of(booking);
        }
        booking.setPayment(payment);
        booking.setBookingStatus(BookingStatus.COMPLETED);
        return Optional.of(booking);
    }

    private void refund() {
        System.out.println("money refunded");
    }
}
