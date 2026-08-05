package lld_designs.book_my_show.models;

import java.util.List;

public class Theater {

    private final List<Screen> screenList;
    private final String name;
    private final String city;


    public Theater(List<Screen> screenList, String name,String city) {
        this.screenList = screenList;
        this.name = name;
        this.city = city;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
