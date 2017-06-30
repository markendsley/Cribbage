package us.markspot.cribbage;

/**
 * Created by Bob Dole on 6/29/2017.
 */

public abstract class Card {

    public int value;
    public boolean outOfDeck = false;
    public boolean inPlay = false;

    public enum suit{
        HEART, SPADE, CLUB, DIAMOND;

        suit suitCode;

        private suit(suit suitCode){
            this.suitCode = suitCode;
        }

    }

    public Card(int value){
        this.value = value;
    }

    public draw(){
        this.outOfDeck = true;
    }
    public boolean isOutOfDeck()
    {
        return this.outOfDeck;
    }
    public play(){
        this.inPlay = true;
    }
    public boolean isInPlay(){
        return this.inPlay;
    }
}
