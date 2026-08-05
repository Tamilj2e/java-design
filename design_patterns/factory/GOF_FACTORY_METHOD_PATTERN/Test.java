package design_patterns.factory.GOF_FACTORY_METHOD_PATTERN;

interface Notification{
    void send(String message);
}
class EmailNotification implements Notification{

    @Override
    public void send(String message) {
        System.out.println("Email sent successfully "+message);
    }
}

class SmsNotification implements Notification{

    @Override
    public void send(String message) {
        System.out.println("SMS sent successfully "+message);
    }
}

abstract class NotificationFactory{
    public  abstract Notification createNotification();

    public void sendMessage(String message){
        System.out.println("creating notification object");
        Notification notification = createNotification();
        notification.send(message);
    }
}


class EmailFactory extends NotificationFactory{

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        System.out.println("from child class");
        return new SmsNotification();
    }
}

public class Test {
    public static void main(String[] args) {
        NotificationFactory factory = new SMSFactory();
        factory.sendMessage("tamil");
    }
}
