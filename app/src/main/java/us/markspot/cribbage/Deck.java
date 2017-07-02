package us.markspot.cribbage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static us.markspot.cribbage.Card.Suit.CLUB;
import static us.markspot.cribbage.Card.Suit.DIAMOND;
import static us.markspot.cribbage.Card.Suit.HEART;
import static us.markspot.cribbage.Card.Suit.SPADE;

/**
 * Created by Mark Endsley on 6/30/2017.
 */

public class Deck {

    public Card[][] deck = new Card[3][13];

    public Deck()
    {


        //Add Hearts

        deck[0] = new Card[13];
        for(int i=0;i<10; i++)
        {
            Card card = new Card(i+1, HEART);
            deck[0][i] = card;
        }
        Card card = new Card(10, HEART, 0);
        deck[0][10] = card;

        card = new Card(10, HEART, 1);
        deck[0][11] = card;

        card = new Card(10, HEART, 2);
        deck[0][12] = card;



        //Add Spades

        deck[1] = new Card[13];
        for(int i=0;i<10; i++)
        {
            card = new Card(i+1, SPADE);
            deck[1][i] = card;
        }
        card = new Card(10, SPADE, 0);
        deck[1][10] = card;

        card = new Card(10, SPADE, 1);
        deck[1][11] = card;

        card = new Card(10, SPADE, 2);
        deck[1][12] = card;



        //Add Clubs

        deck[2] = new Card[13];
        for(int i=0;i<10; i++)
        {
            card = new Card(i+1, CLUB);
            deck[2][i] = card;
        }
        card = new Card(10, CLUB, 0);
        deck[2][10] = card;

        card = new Card(10, CLUB, 1);
        deck[2][11] = card;

        card = new Card(10, CLUB, 2);
        deck[2][12] = card;



        //Add Diamonds

        deck[3] = new Card[13];
        for(int i=0;i<10; i++)
        {
            card = new Card(i+1, DIAMOND);
            deck[3][i] = card;
        }
        card = new Card(10, DIAMOND, 0);
        deck[3][10] = card;

        card = new Card(10, DIAMOND, 1);
        deck[3][11] = card;

        card = new Card(10, DIAMOND, 2);
        deck[3][12] = card;


    }

    //Chooses Random Card That Is Still In Deck
    public Card getRandomCard()
    {

        Random rand1 = new Random();
        Random rand2 = new Random();

        int a = rand1.nextInt(4);
        int b = rand2.nextInt(13);

        while(deck[a][b].isOutOfDeck() != true){
            a = rand1.nextInt(4);
            b = rand2.nextInt(13);
        }

        deck[a][b].draw();

        return deck[a][b];


    }

    //Returns Number of Remaining Cards In The Deck
    public int cardsLeft()
    {
        int count = 0;
        int j = 0;

        for(int i=0 ; i<4 ; i++)
        {
            for(j=0 ; i<13 ; j++)
            {
                if(deck[i][j].isOutOfDeck() == false)
                    count++;
            }
        }

        return count;
    }

    //Returns True Deck Is Empty, False Otherwise
    public boolean isEmpty()
    {
        int count = 0;
        int j = 0;

        for(int i=0 ; i<4 ; i++)
        {
            for(j=0 ; i<13 ; j++)
            {
                if(deck[i][j].isOutOfDeck() == false)
                    count++;
            }
        }
        if(count == 0)
            return true;
        else
            return false;
    }



    }





