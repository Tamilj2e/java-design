package design_patterns.factory;

public class EmailNotification implements Notification{
    @Override
    public void send() {
        System.out.println("sending email...");
    }
}
