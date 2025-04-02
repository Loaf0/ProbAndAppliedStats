package Cards;

public class Card {

    private char suit;
    private char value;

    public Card(char suit, char value){
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {

        return super.toString();
    }

    @Override
    public boolean equals(Object c) {
        if(c instanceof Card)
            return ((Card) c).getSuit() == suit && ((Card) c).getValue() == value;
        return false;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
