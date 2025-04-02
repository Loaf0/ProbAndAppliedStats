package Cards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// used to speed up grading of hands
public class Hand {

    Set<Character> suitsInHand;
    Set<Character> valuesInHand;
    ArrayList<Card> cards;

    public Hand(){
        suitsInHand = new HashSet<>();
        valuesInHand = new HashSet<>();
        cards = new ArrayList<>();
    }

    public void add(Card c){
        cards.add(c);
        suitsInHand.add(c.getSuit());
        valuesInHand.add(c.getValue());
    }

    @Override
    public String toString() {
        String output = "";
        for(Card c : cards)
            output = output + c.getValue() + c.getSuit() + " ";
        return output;
    }

    public Set<Character> getSuitsInHand() {
        return suitsInHand;
    }

    public void setSuitsInHand(Set<Character> suitsInHand) {
        this.suitsInHand = suitsInHand;
    }

    public Set<Character> getValuesInHand() {
        return valuesInHand;
    }

    public void setValuesInHand(Set<Character> valuesInHand) {
        this.valuesInHand = valuesInHand;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
