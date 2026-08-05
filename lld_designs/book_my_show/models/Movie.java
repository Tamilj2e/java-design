package lld_designs.book_my_show.models;

import java.time.Duration;

public class Movie {
    private final String name;
    private final Duration duration;

    public Movie(String name, Duration duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public Duration getDuration() {
        return duration;
    }
}
