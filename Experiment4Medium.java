import java.util.*;

class Card {
    private String symbol;
    private String name;

    public Card(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Card{" + "symbol='" + symbol + '\'' + ", name='" + name + '\'' + '}';
    }
}

public class CardCollection {
    private Collection<Card> cards;

    public CardCollection() {
        this.cards = new ArrayList<>();
    }

    public void addCard(String symbol, String name) {
        cards.add(new Card(symbol, name));
    }

    public List<Card> findCardsBySymbol(String symbol) {
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                result.add(card);
            }
        }
        return result;
    }

    public void displayAllCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public static void main(String[] args) {
        CardCollection collection = new CardCollection();
        collection.addCard("Heart", "Ace");
        collection.addCard("Spade", "King");
        collection.addCard("Heart", "Queen");
        collection.addCard("Diamond", "Jack");

        System.out.println("All Cards:");
        collection.displayAllCards();

        System.out.println("\nCards with symbol 'Heart':");
        List<Card> hearts = collection.findCardsBySymbol("Heart");
        for (Card card : hearts) {
            System.out.println(card);
        }
    }
}
