package design_patterns.statemachine.withstate;

import design_patterns.statemachine.withstate.AtmMachine;

public interface AtmState {
    String insertCard(AtmMachine machine);
    String enterPin(AtmMachine machine, int pin);
    String withdraw(AtmMachine machine,int amount);
    String ejectCard(AtmMachine machine);

}
