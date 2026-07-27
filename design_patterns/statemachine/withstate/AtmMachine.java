package design_patterns.statemachine.withstate;

//in state machine part instead of passing enum state, we are passing state objects like idle state and all
public class AtmMachine {
    private AtmState state;
    private int balance;

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

    public AtmMachine(int balance){
        state=new IdleState();
        this.balance = balance;
    }
    public String insertCard(){
        return state.insertCard(this);
    }
    public String enterPin(int pin){
        return state.enterPin(this,pin);
    }
    public String withdraw( int amount){
        return state.withdraw(this,amount);
    }
    public String ejectCard(){
        return state.ejectCard(this);
    }

}
