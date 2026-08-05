package lld_designs.book_my_show.strategy.amount;

import lld_designs.book_my_show.models.Show;
import lld_designs.book_my_show.models.ShowSeat;

import java.math.BigDecimal;
import java.util.List;

public interface AmountStrategy {
    BigDecimal calcAmount(Show show, List<ShowSeat> seatList);
}
