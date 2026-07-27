package design_patterns.factory;

public class SmsNotification implements Notification{
    @Override
    public void send() {
        System.out.println("sending sms...");
    }
}
