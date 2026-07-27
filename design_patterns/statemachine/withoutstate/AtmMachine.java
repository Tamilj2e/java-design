package design_patterns.statemachine.withoutstate;

import design_patterns.statemachine.State;


public class AtmMachine{
    State state; //IDLE, CARD INSERTED, AUTHENTICATED, DISPENSE
    int balance;

    public AtmMachine(int balance){
        this.balance=balance;
        state = State.IDLE;
    }

    public String insertCard(){
        if(state!=State.IDLE){
           return "please insert card first";
        }

        if(state==State.CARD_INSERTED) return "card has been already inserted";
        state = State.CARD_INSERTED;
        return "card inserted successfully";
    }

    public String enterPin(int pin){
        if(state!=State.CARD_INSERTED) return "please insert card first";
        if(pin==1234) state = State.AUTHENTICATED;
        else
            return "pin is wrong";

        return "Pin is correct";
    }

    public String withdraw(int amount){
        if(state == State.IDLE) return "Insert card first";
        if(state==State.CARD_INSERTED) return "Enter pin first";
        if(amount>balance) return "Insufficient fund";
        balance-=amount;
        state = State.DISPENSE;
        return "money dispensing pls collect";
    }

    public String ejectCard(){
        state=State.IDLE;
        return "please collect your card";
    }
}

