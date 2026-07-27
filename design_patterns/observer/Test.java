package design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

//Step 1:  Observers
interface Observer{
    void notifyUser(String message);
}

//Step 2: Concrete Observers
class ConcreteObserver implements Observer{
    private String name;

    public ConcreteObserver(String name){
        this.name=name;
    }
    @Override
    public void notifyUser(String message) {
        System.out.println(message+" to user"+name);
    }
}
//Step 3: Subject
class SubscribeProduct{
    List<Observer> subscribers = new ArrayList<>();

    public void subscribe(Observer observer){
        subscribers.add(observer);
    }

    public void unsubscribe(Observer observer){
        subscribers.remove(observer);
    }

    public void addProduct(String productTitle){
        String message = "New product launched "+productTitle;
        System.out.println(message+ " notifying subscribers");
        for(Observer observer:subscribers){
            observer.notifyUser(message);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        SubscribeProduct subscribeProduct = new SubscribeProduct();

        subscribeProduct.subscribe(new ConcreteObserver("Tamil"));
        subscribeProduct.subscribe(new ConcreteObserver("Selvan"));
        subscribeProduct.subscribe(new ConcreteObserver("Aaruran"));
        subscribeProduct.subscribe(new ConcreteObserver("Aathiran"));

        subscribeProduct.addProduct("iphone 18");
    }
}


/*

Role	Description
Subject	Maintains a list of observers and provides methods to add/remove/notify them
Observer	Interface for all objects that want to be notified of subject changes
Concrete Subject	A real object being observed (e.g., product launch notifier)
Concrete Observer	Objects that subscribe to changes and react accordingly

 */