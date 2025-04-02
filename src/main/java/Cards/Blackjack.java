package Cards;

import java.util.ArrayList;

public class Blackjack {

    public boolean playTurn(int drawUntil){
        Deck deck = new Deck();
        deck.shuffle();

        Hand dealer = new Hand();
        Hand player = new Hand();

        dealer.add(deck.draw());
        dealer.add(deck.draw());

        player.add(deck.draw());
        player.add(deck.draw());

        if (getBlackjackScore(player) == 21) // win instantly if first hand is 21
            return true;

        while (getBlackjackScore(player) < drawUntil)
            player.add(deck.draw());


        while (getBlackjackScore(dealer) < 16)
            dealer.add(deck.draw());

        int playerScore = getBlackjackScore(player);
        int dealerScore = getBlackjackScore(dealer);

        if (playerScore > 21)
            return false;

        if (dealerScore <= 21 && playerScore < dealerScore)
            return false;

        if (dealerScore == playerScore)
            return true;

        return dealerScore > 21; // dealer busted
    }

    public int getBlackjackScore(Hand hand){
        ArrayList<Card> cards = hand.getCards();
        int score = 0;
        int aces = 0;

        for(Card c : cards){
            if (c.getValue() == 'A'){
                aces++;
                continue; // process aces last
            }

            int cardValue = Constants.VALUES.indexOf("" + c.getValue()) + 1; // offset zero index
            if (cardValue > 10)
                cardValue = 10;
            score += cardValue;
        }

        for (int i = 0; i < aces; i++) {
            if (score + 11 <= 21) { // make sure you won't bust for taking an 11 ace
                score += 11;
            } else {
                score += 1;
            }
        }
        return score;
    }

}
