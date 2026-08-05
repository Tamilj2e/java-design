package design_patterns.factory;

public class Test {
    //note this is called simple factory pattern
    public static void main(String[] args) {
        Notification notification = NotificationFactory.create("sms");
        notification.send();
    }
}
