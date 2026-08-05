package lld_designs.book_my_show.repository;

import lld_designs.book_my_show.models.Movie;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MovieRepository {
    ConcurrentHashMap<String, Movie> movieList = new ConcurrentHashMap<>();

    public List<Movie> movieList(){
        return movieList.values().stream().toList();
    }

    public Optional<Movie> findMovie(String name){
        return Optional.of(movieList.get(name));
    }

    public void add(Movie movie){
        movieList.put(movie.getName(),movie);
    }
}
