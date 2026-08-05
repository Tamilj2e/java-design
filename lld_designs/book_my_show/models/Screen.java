package lld_designs.book_my_show.models;

import java.util.List;

public class Screen {
    private final int screenNo;
    private  List<Show> showList;
    private final List<Seat> seatList;
    private final String name; // can be screentype

    public Screen(int screenNo, List<Seat> seatList, String name) {
        this.screenNo = screenNo;
        this.seatList = seatList;
        this.name = name;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    public int getScreenNo() {
        return screenNo;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public String getName() {
        return name;
    }
}
