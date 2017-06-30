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

    public enum Suit
    {
        HEART, SPADE, CLUB, DIAMOND;
    }

    Suit suit;

    //Constructor For Numbered Cards
    public Card(int value, Suit suit)
    {
        this.value = value;
        this.suit = suit;
    }

    //Constructor For Royal Cards
    public Card(int value, Suit suit, int royalty)
    {
        this.value = value;
        this.suit = suit;
        if(royalty == 0)
            this.isJack = true;
        else if(royalty == 1)
            this.isQueen = true;
        else if(royalty == 2)
            this.isKing = true;

    }

    //Take Card From Deck
    public void draw()
    {
        this.outOfDeck = true;
    }

    //Ask If Card Is In Deck
    public boolean isOutOfDeck()
    {
        return this.outOfDeck;
    }

    //Set Card In Play
    public void play()
    {
        this.inPlay = true;
    }

    //Ask If Card Is In Play
    public boolean isInPlay()
    {
        return this.inPlay;
    }

    //Ask What Suit Card Is
    public Suit getSuit()
    {
        return suit;
    }
}
