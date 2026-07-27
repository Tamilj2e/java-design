package design_patterns.practice;

interface AtmState{

    String insertCard(AtmMachine atmMachine);

    String enterPin(AtmMachine atmMachine, int pin);

    String withdraw(AtmMachine atmMachine, int amount);

    String ejectCard(AtmMachine atmMachine);
}

class AtmMachine{
    AtmState state;
    int balance;
    public AtmMachine(int balance){
        this.balance = balance;
        this.state = new IdleStates();
    }

    public AtmState getState() {
        return state;
    }

    public void setState(AtmState state) {
        this.state = state;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String insertCard(){
        return state.insertCard(this);
    }
    public String enterPin(int pin){
        return state.enterPin(this,pin);
    }
    public String withdraw(int amount){
        return state.withdraw(this,amount);
    }
    public String ejectCard(){
        return state.ejectCard(this);
    }
}

class IdleStates implements AtmState{

    @Override
    public String insertCard(AtmMachine atmMachine) {
        atmMachine.setState(new InsertCardState());
        return "card inserted successfully";
    }

    @Override
    public String enterPin(AtmMachine atmMachine, int pin) {
        return "insert card first";
    }

    @Override
    public String withdraw(AtmMachine atmMachine, int amount) {
        return "insert card first";
    }

    @Override
    public String ejectCard(AtmMachine atmMachine) {
        return "invalid operation";
    }
}

class InsertCardState implements AtmState{

    @Override
    public String insertCard(AtmMachine atmMachine) {
        return "card already inserted";
    }

    @Override
    public String enterPin(AtmMachine atmMachine, int pin) {
        if(pin!=1234) return "invalid pin";
        atmMachine.setState(new WithdrawState());
        return "pin correct, authenticated";
    }

    @Override
    public String withdraw(AtmMachine atmMachine, int amount) {
        return "enter pin first";
    }

    @Override
    public String ejectCard(AtmMachine atmMachine) {
        atmMachine.setState(new IdleStates());
        return "please collect card";
    }
}

class WithdrawState implements AtmState{

    @Override
    public String insertCard(AtmMachine atmMachine) {
        return "Transaction in progress";
    }

    @Override
    public String enterPin(AtmMachine atmMachine, int pin) {
        return "Transaction in progress";
    }

    @Override
    public String withdraw(AtmMachine atmMachine, int amount) {
        if(atmMachine.getBalance()<amount) return "insufficient balance";
        atmMachine.setBalance(atmMachine.getBalance()-amount);
        atmMachine.setState(new EjectCardState());
        return "Cash dispensing";
    }

    @Override
    public String ejectCard(AtmMachine atmMachine) {
        atmMachine.setState(new IdleStates());
        return "pls collect card";
    }
}

class EjectCardState implements AtmState{

    @Override
    public String insertCard(AtmMachine atmMachine) {
        return "transaction in progress";
    }

    @Override
    public String enterPin(AtmMachine atmMachine, int pin) {
        return  "transaction in progress";
    }

    @Override
    public String withdraw(AtmMachine atmMachine, int amount) {
        return  "transaction in progress";
    }

    @Override
    public String ejectCard(AtmMachine atmMachine) {
        atmMachine.setState(new IdleStates());
        return "please colelct card and cash";
    }
}
public class Main {
    public static void main(String[] args) {
        AtmMachine machine = new AtmMachine(1000);
        System.out.println(machine.insertCard());
        System.out.println(machine.enterPin(1234));
        System.out.println(machine.withdraw(100));
        System.out.println(machine.withdraw(100));
        System.out.println(machine.withdraw(100));
    }
}
