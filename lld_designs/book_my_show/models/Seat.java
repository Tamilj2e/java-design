package lld_designs.book_my_show.models;


import lld_designs.book_my_show.models.enums.SeatType;

public class Seat {
    private final int rowNo;
    private final int seatNo;
    private final SeatType seatType;

    public Seat(int rowNo, int seatNo, SeatType seatType) {
        this.rowNo = rowNo;
        this.seatNo = seatNo;
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "rowNo=" + rowNo +
                ", seatNo=" + seatNo +
                '}';
    }
}
