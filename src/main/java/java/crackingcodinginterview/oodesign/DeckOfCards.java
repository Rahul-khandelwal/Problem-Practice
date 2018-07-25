/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.crackingcodinginterview.oodesign;

import java.util.*;

/**
 * Design the data structures for a generic deck of cards.
 * Explain how would you subclass the data structures to implement black jack.
 * 
 * Approach:
 * First we need to ask, what kind of cards can come into generic cards.
 * There can be normal poker like cards, uno cards, baseball cards etc.
 * 
 * Assumption: So we'll assume here that cards are 52-card set for poker, black jack etc.
 * 
 * @author Rahul
 */

/**
 * First we'll have an enum for different suits of cards.
 * In 52-card set, we can have 4 type of cards.
 */
enum Suit {
    
    CLUB(0),
    DIAMOND(1),
    HEART(2),
    SPADE(3);
    
    private final int value;

    private Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static Suit getSuiteByValue(int _val) {
        if (_val > 3 || _val < 0) {
            return null;
        }
        
        return Suit.values()[_val];
    }
    
}

/**
 * This class represents a generic card.
 * card will belong to a suite and it will have a face value.
 * card will also have it's availability and it will be available by default.
 */
abstract class Card {
    private boolean available = true;
    
    /**
     * Number or face that is on card.
     * Here a number from 2 to 10, 11 for jack, 12 for queen, 13 for king and 1 for Ace.
     */
    protected int faceValue;
    
    /**
     * The suit in which card belongs
     */
    protected Suit suit;

    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }
    
    public abstract int getFaceValue();
    
    public Suit suit() {
        return this.suit;
    }
    
    public boolean isAvailable() {
        return this.available;
    }
    
    public void markAvailable() {
        this.available = true;
    }
    
    public void markUnavailable() {
        this.available = false;
    }
    
}

/**
 * This class will represent one hand of cards.
 */
class Hand <T extends Card> {
    protected ArrayList<T> cards = new ArrayList<>(); // cards in this hand
    
    public int getScore() {
        int total = 0;
        
        for (T card : this.cards) {
            total += card.getFaceValue();
        }
        
        return total;
    }
    
    public void addCard(T _card) {
        this.cards.add(_card);
    }
}

/**
 * This will be our main deck of cards class.
 * It will have all the cards for dealing.
 */
class DeckOfCards <T extends Card> {
    private ArrayList<T> cards; // All cards, dealt and undealt
    
    private int dealtIndex = 0; // Marks first undealt card
    
    public void setDeckOfCards(ArrayList<T> _cards) {
        this.cards = new ArrayList<>(_cards); // Initialize a new deck of cards
    }
    
    public void shuffle() {
        Collections.shuffle(this.cards);
    }
    
    public int remainingCards() {
        return this.cards.size() - this.dealtIndex;
    }
 
    public T dealCard() {
        return this.cards.get(dealtIndex++); //deals one card
    }
    
    public T[] dealHand(int _number) {
        return null; // deals one hand
    }
}

/**
 * Now we have a generic implementation for deck and cards.
 * We could also provide a default implementation for face value of cards in Cards class as per the rules of poker,
 * But this won't make sense unless we have a game attached to cards.
 */
/**
 * Now we'll create an implementation for black jack game.
 */

/**
 * This class represents a black jack card with method to get it's face value.
 */
class BlackJackCard extends Card {

    public BlackJackCard(int _faceValue, Suit _suit) {
        super(_faceValue, _suit);
    }
    
    public boolean isAce() {
        return this.faceValue == 1;
    }
    
    public boolean isFaceCard() {
        return this.faceValue >= 11 && this.faceValue <= 13;
    }
    
    public int maxValue() {
        if (this.isAce()) {
            return 11;
        }
        
        return this.getFaceValue();
    }
    
    public int minValue() {
        if (this.isAce()) {
            return 1;
        }
        
        return this.getFaceValue();
   }
    
    @Override
    public int getFaceValue() {
        if (this.isAce()) {
            return 1;
        }
        
        if (this.isFaceCard()) {
            return 10;
        }
        
        return this.faceValue;
    }
}

/**
 * This class represents a hand of black jack cards.
 */
class BlackJackHand extends Hand<BlackJackCard> {

    /**
     * There are multiple possible scores for a black jack hand, since aces have multiple values.
     * 
     * @return Highest possible score that's under 21, or the lowest score that's over.
     */
    @Override
    public int getScore() {
        ArrayList<Integer> scores = this.getAllPossibleScores();
        
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        
        for (int score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score < 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }
    
    private ArrayList<Integer> getAllPossibleScores() {
        return null; // return all possible scores this hand could have, evaluating aces as both 1 and 11
    }
    
    public boolean busted() {
        return this.getScore() > 21;
    }
    
    public boolean is21() {
        return this.getScore() == 21;
    }
     
    public boolean isBlackJack() {
        return true; // return if it's a black jack
    }
     
}