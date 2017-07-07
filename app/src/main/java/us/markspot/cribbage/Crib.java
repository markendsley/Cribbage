package us.markspot.cribbage;

/**
 * Created by Bob Dole on 7/6/2017.
 */

public class Crib {

    Card[] cards  = new Card[4];

    boolean[] cribFull = new boolean[4];

    public Crib()
    {
        for(int i = 0;i<4;i++)
        {
            cribFull[i] = false;

        }
    }

    //Inserts Card into next Empty Slot
    public void insertCard(Card card)
    {
        for(int i = 0; i<4; i++)
        {
            if(cribFull[i] == false)
            {
                cards[i] = card;
                cribFull[i] = true;
                break;
            }
        }
    }

    //Returns Number of Next Open Slot Starting at 1
    public int findEmptySlot()
    {
        for(int i = 0; i<4; i++)
        {
            if(cribFull[i] == false)
            {
                return i + 1;
            }
        }

        return 0;
    }


}
