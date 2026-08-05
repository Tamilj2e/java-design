package lld_designs.book_my_show.models;

import lld_designs.book_my_show.models.enums.BookingStatus;
import lld_designs.book_my_show.models.enums.SeatStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Booking {
    private final String bookingId;
    private final Movie movie;
    private final List<ShowSeat> seats;
    private  final BigDecimal totalAmount;
    private final User user;
    private  Payment payment;
    private BookingStatus bookingStatus;


    private Booking(Movie movie, List<ShowSeat> seats, BigDecimal totalAmount, User user, BookingStatus bookingStatus) {
        this.bookingId = UUID.randomUUID().toString();
        this.movie = movie;
        this.seats = seats;
        this.totalAmount = totalAmount;
        this.user = user;
        this.bookingStatus = bookingStatus;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public boolean confirmBooking(){
        for(ShowSeat seat:seats){
            if(seat.getStatus()!= SeatStatus.LOCKED) return false;
        }
        seats.forEach(s->s.setStatus(SeatStatus.BOOKED));
        return true;
    }

    public static class Builder{
        private Movie movie;
        private List<ShowSeat> seat;
        private  BigDecimal totalAmount;
        private User user;
        private Payment payment;
        private BookingStatus bookingStatus;
        public Builder(){
        }

        public Builder setMovie(Movie movie) {
            this.movie = movie;
            return this;
        }

        public Builder setSeat(List<ShowSeat> seat) {
            this.seat = seat;
            return this;
        }

        public Builder setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder setBookingStatus(BookingStatus bookingStatus) {
            this.bookingStatus = bookingStatus;
            return this;
        }

        public Booking build(){
            return new Booking(this.movie,this.seat,this.totalAmount,this.user,this.bookingStatus);
        }
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", movie=" + movie +
                ", seats=" + seats +
                ", totalAmount=" + totalAmount +
                ", user=" + user +
                ", payment=" + payment +
                ", bookingStatus=" + bookingStatus +
                '}';
    }
}
