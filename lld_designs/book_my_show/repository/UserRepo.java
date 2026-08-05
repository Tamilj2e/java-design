package lld_designs.book_my_show.repository;

import lld_designs.book_my_show.models.User;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepo {
    private final ConcurrentHashMap<String, User> map = new ConcurrentHashMap<>();

    public void add(User user){
        map.put(user.getName(),user);
    }

    public Optional<User> findByName(String name){
        return Optional.ofNullable(map.get(name));
    }
}
