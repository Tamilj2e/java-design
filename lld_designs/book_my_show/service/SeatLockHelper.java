package lld_designs.book_my_show.service;


import lld_designs.book_my_show.models.Show;
import lld_designs.book_my_show.models.ShowSeat;
import lld_designs.book_my_show.models.enums.SeatStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SeatLockHelper {
    private final ConcurrentHashMap<Show, Map<String, List<ShowSeat>>> map = new ConcurrentHashMap<>();
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public boolean lock(Show show, List<ShowSeat> seatList,String userId){
        synchronized (show){

            for(ShowSeat seat:seatList){
                if(seat.getStatus()!= SeatStatus.AVAILABLE){
                    System.out.println("seat is already booked, seat: \n"+seat.getSeat());
                    return false;
                }
            }

            for(ShowSeat seat:seatList){
                seat.setStatus(SeatStatus.LOCKED);
                map.computeIfAbsent(show,v->new HashMap<>());
                var seatmap = map.get(show);
                seatmap.computeIfAbsent(userId,v->new ArrayList<>()).add(seat);
                System.out.println("user id trying booking \n"+seat.getSeat());
            }
            executorService.schedule(()->unlock(show,userId),1, TimeUnit.MINUTES);
            return true;
        }
    }

    public void unlock(Show show,String userId){
        if(!map.containsKey(show)) {
            System.out.println("incorrect show");
            return;
        }
        var seatList = map.get(show).get(userId);
        for(ShowSeat seat:seatList){
            if(seat.getStatus()==SeatStatus.LOCKED){
                System.out.println("seat lock removed for seat"+ seat);
                seat.setStatus(SeatStatus.AVAILABLE);
            }
        }
        seatList.clear();
        if(map.get(show).get(userId).isEmpty()){
            map.get(show).remove(userId);
        }
        if(map.get(show).isEmpty()){
            map.remove(show);
        }
    }

}
