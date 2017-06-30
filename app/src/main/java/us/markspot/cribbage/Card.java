package us.markspot.cribbage;

/**
 * Created by Mark Endsley on 6/29/2017.
 */

public class Card {

    public int value;
    public boolean outOfDeck = false;
    public boolean inPlay = false;
    public boolean isKing = false;
    public boolean isQueen = false;
    public boolean isJack = false;

    public enum Suit{
        HEART, SPADE, CLUB, DIAMOND;
    }

    Suit suit;

    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public Card(int value, Suit suit, int royalty){
        this.value = value;
        this.suit = suit;
        if(royalty == 0)
            this.isJack = true;
        else if(royalty == 1)
            this.isQueen = true;
        else if(royalty == 2)
            this.isKing = true;

    }

    public void draw(){
        this.outOfDeck = true;
    }
    public boolean isOutOfDeck()
    {
        return this.outOfDeck;
    }
    public void play(){
        this.inPlay = true;
    }
    public boolean isInPlay(){
        return this.inPlay;
    }
    public Suit getSuit(){
        return suit;
    }
}
