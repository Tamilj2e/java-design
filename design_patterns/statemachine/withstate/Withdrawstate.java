package design_patterns.statemachine.withstate;

public class Withdrawstate implements AtmState{
    @Override
    public String insertCard(AtmMachine machine) {
        return "Transaction in progress";
    }

    @Override
    public String enterPin(AtmMachine machine, int pin) {
        return "Transaction in progress";
    }

    @Override
    public String withdraw(AtmMachine machine, int amount) {
        if(machine.getBalance()<amount) return "insufficient funds";
        machine.setBalance(machine.getBalance()-amount);
        machine.setState(new EjectCardState());
        return "please collect your amount and eject your card";
    }

    @Override
    public String ejectCard(AtmMachine machine) {
        machine.setState(new IdleState());
        return "please collect card";
    }
}
