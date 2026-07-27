package design_patterns.factory;

public class NotificationFactory {

    public static Notification create(String type){
        if(type.equals("sms")){
            return new SmsNotification();
        }else if(type.equals("email")){
            return new EmailNotification();
        }
        throw  new IllegalArgumentException("invalid type");
    }

}
