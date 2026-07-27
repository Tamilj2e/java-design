package design_patterns.chainofresponsibility;

/*
In the classic Chain of Responsibility pattern,
 each handler decides whether to handle the request OR pass it on.
 */
abstract class LogHandler{
    protected LogHandler next;

    public void setNext(LogHandler next){
        this.next = next;
    }

    abstract void handle(String log);
}

class ConsoleHandler extends LogHandler{

    @Override
    void handle(String log) {
        if(log.equals("debug"))
           System.out.println("wring in the console");
        else if(this.next!=null){
            next.handle(log);
        }

    }
}

class FileHandler extends LogHandler{

    @Override
    void handle(String log) {
        if(log.equals("info") || log.equals("warn")){
            System.out.println("writing in the file");
        }
        else if(this.next!=null){
            this.next.handle(log);
        }
    }
}

class EmailHandler extends LogHandler{

    @Override
    void handle(String log) {
        if(log.equals("fatal"))
           System.out.println("sending email..");
        else if(this.next!=null) this.next.handle(log);
    }
}

public class WithCOR {
    public static void main(String[] args) {
        LogHandler console = new ConsoleHandler();
        LogHandler file = new FileHandler();
        LogHandler stream = new EmailHandler();
        console.setNext(file);
        file.setNext(stream);

        console.handle("fatal");
    }
}
