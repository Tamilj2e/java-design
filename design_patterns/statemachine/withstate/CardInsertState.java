package design_patterns.statemachine.withstate;

public class CardInsertState implements AtmState{
    @Override
    public String insertCard(AtmMachine machine) {
        return "card already has been inserted";
    }

    @Override
    public String enterPin(AtmMachine machine, int pin) {
        if(pin==1234) {
            machine.setState(new Withdrawstate());
            return "pin is correct, authenticated successfully";
        }
        else return "incorrect pin";
    }

    @Override
    public String withdraw(AtmMachine machine, int amount) {
        return "";
    }

    @Override
    public String ejectCard(AtmMachine machine) {
        return "";
    }
}
