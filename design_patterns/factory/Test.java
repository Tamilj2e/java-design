package design_patterns.factory;

public class Test {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.create("sms");
        notification.send();
    }
}
