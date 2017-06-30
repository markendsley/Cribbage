package us.markspot.cribbage;

/**
 * Created by Bob Dole on 6/29/2017.
 */

public abstract class Card {

    public int value;

    public enum suit{
        HEART, SPADE, CLUB, DIAMOND;

        suit suitCode;

        private suit(suit suitCode){
            this.suitCode = suitCode;
        }

    }
}
