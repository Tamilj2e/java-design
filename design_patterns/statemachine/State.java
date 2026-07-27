package design_patterns.statemachine;

public enum State {
    IDLE("idle"),
    CARD_INSERTED("card has been inserted"),
    AUTHENTICATED("pin authenticated"),
    DISPENSE("Amount has been dispensed");

    private String value;

    State(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
