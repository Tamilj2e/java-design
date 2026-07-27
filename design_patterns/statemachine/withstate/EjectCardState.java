package design_patterns.statemachine.withstate;

public class EjectCardState implements AtmState{
    @Override
    public String insertCard(AtmMachine machine) {
        return "card already inserted";
    }

    @Override
    public String enterPin(AtmMachine machine, int pin) {
        return "pin already entered";
    }

    @Override
    public String withdraw(AtmMachine machine, int amount) {
        return "money dispensed pls collect";
    }

    @Override
    public String ejectCard(AtmMachine machine) {
        machine.setState(new IdleState());
        return "card ejected";
    }
}
