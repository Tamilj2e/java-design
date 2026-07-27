package design_patterns.chainofresponsibility;

public class WithoutCOR {
    public static void main(String[] args) {
        String log = "info";
        if(log.equals("info")){
            writeOnConsole(log);
            writeOnFile(log);
        }else if(log.equals("debug")){
            writeOnConsole(log);
        }else if(log.equals("warn")){
            writeOnFile(log);
            writeOnConsole(log);
        }

    }

    private static void writeOnFile(String log) {
    }

    private static void writeOnConsole(String log) {
    }
}


/*

Problems
All rules are in one place.
     Every time a new log type (error, trace, etc.) is added, this method must change.
Violates Open/Closed Principle.
     You're modifying existing code whenever requirements change.
Logic becomes complex.
     Imagine 20 log types and 8 destinations.
 */