public class Card {

    private final Suite suite;
    private final Value value;

    public Card(Suite suite, Value value) {
        this.suite = suite;
        this.value = value;
    }

    public Suite getSuite() {
        return this.suite;
    }

    public Value getValue() {
        return this.value;
    }

}

