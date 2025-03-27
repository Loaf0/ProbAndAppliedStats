package Cards;

import java.util.ArrayList;

/*
 *  @description Custom Deck class to act as simulated deck of cards
 *  @author Tyler Snyder
 */

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        addBaseCards();
    }

    public void addBaseCards(){
        for (int x = 0; x < Constants.SUITS.length(); x++) { // each suit
            for (int y = 0; y < Constants.VALUES.length(); y++) { // each card
                cards.add(new Card(Constants.SUITS.charAt(x), Constants.VALUES.charAt(y)));
            }
        }
    }

    public Card draw(){
        return cards.removeFirst();
    }

    public boolean contains(Card c){
        return cards.contains(c);
    }

    public void shuffle(){
        for (int i = 0; i < 5; i++) {
            ArrayList<Card> split1 = new ArrayList<>();
            ArrayList<Card> split2 = new ArrayList<>();

            for (Card card : cards) {
                if (Math.random() > .5)
                    split2.add(card);
                else
                    split1.add(card);
            }

            if (Math.random() > .5) {
                split2.addAll(split1);
                cards = split2;
            } else {
                split1.addAll(split2);
                cards = split1;
            }
        }
    }
}
