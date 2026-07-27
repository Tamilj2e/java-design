package design_patterns.statemachine;

import design_patterns.statemachine.withstate.AtmMachine;

public class Test {
    public static void main(String[] args) {
        AtmMachine atm = new AtmMachine(1000);
        System.out.println(atm.withdraw(900));
//        System.out.println(atm.insertCard());
//        System.out.println(atm.enterPin(1234));
//        System.out.println(atm.withdraw(100));
//        System.out.println(atm.ejectCard());

    }
}
