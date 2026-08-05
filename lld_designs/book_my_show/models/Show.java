package lld_designs.book_my_show.models;

import java.time.LocalDateTime;
import java.util.List;

public class Show {
    private final Movie movie;
    private final Screen screen;
    private final LocalDateTime start;
    private final List<ShowSeat> seatList;
    private final double basePrice;

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public List<ShowSeat> getSeatList() {
        return seatList;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Show(Movie movie, Screen screen, LocalDateTime start, List<ShowSeat> seatList, double basePrice) {
        this.movie = movie;
        this.screen = screen;
        this.start = start;
        this.seatList = seatList;
        this.basePrice = basePrice;
    }
}
