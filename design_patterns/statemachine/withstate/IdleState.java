package design_patterns.statemachine.withstate;

public class IdleState implements AtmState{
    @Override
    public String insertCard(AtmMachine machine) {
        machine.setState(new CardInsertState());
        return "card has inserted successfully";
    }

    @Override
    public String enterPin(AtmMachine machine, int pin) {
        return "insert card first";
    }

    @Override
    public String withdraw(AtmMachine machine, int amount) {
        return "insert card first";
    }

    @Override
    public String ejectCard(AtmMachine machine) {
        return "card not inserted";
    }
}
