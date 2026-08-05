package lld_designs.book_my_show.models;


import lld_designs.book_my_show.models.enums.SeatStatus;

import java.time.LocalDateTime;

public class ShowSeat {
    private final Seat seat;
    private  SeatStatus status;
    private final LocalDateTime dateTime;

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public ShowSeat(Seat seat, LocalDateTime dateTime) {
        this.seat = seat;
        this.dateTime = dateTime;
    }

    public Seat getSeat() {
        return seat;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
