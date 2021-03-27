import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final Type type;
    private final List<Card> cards;

    public Player(String name, Type type) {
        this.name = name;
        this.type = type;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", cards=" + cards +
                '}';
    }
}
