package lld_designs.book_my_show.strategy.amount;

import lld_designs.book_my_show.models.Show;
import lld_designs.book_my_show.models.ShowSeat;

import java.math.BigDecimal;
import java.util.List;

public class WeekendStrategy implements AmountStrategy{
    private final double SURCHARGE = 1.2;
    @Override
    public BigDecimal calcAmount(Show show, List<ShowSeat> seatList) {
        BigDecimal base = BigDecimal.valueOf(show.getBasePrice());
        BigDecimal total = new BigDecimal("0.0");
        for(var seat:seatList){
            total.add(base.multiply(BigDecimal.valueOf(SURCHARGE)));
        }
        return total;
    }
}
