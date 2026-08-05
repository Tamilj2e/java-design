package lld_designs.book_my_show.repository;

import lld_designs.book_my_show.models.Theater;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TheaterRepository {
    ConcurrentHashMap<String,Theater> theaterList = new ConcurrentHashMap<>();

    public List<Theater> findAll(){
        return theaterList.values().stream().toList();
    }

    public void add(Theater theater){
        theaterList.put(theater.getName(),theater);
    }
}
