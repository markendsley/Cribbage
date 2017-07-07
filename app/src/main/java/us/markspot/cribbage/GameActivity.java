package us.markspot.cribbage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.Random;

import static us.markspot.cribbage.Card.Suit.CLUB;
import static us.markspot.cribbage.Card.Suit.DIAMOND;
import static us.markspot.cribbage.Card.Suit.HEART;
import static us.markspot.cribbage.Card.Suit.SPADE;

public class GameActivity extends AppCompatActivity {

    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;

    ImageButton mImageView;
    ImageButton mImageView2;
    ImageButton mImageView3;
    ImageButton mImageView4;
    ImageButton mImageView5;
    ImageButton mImageView6;

    Card cardv1;
    Card cardv2;
    Card cardv3;
    Card cardv4;
    Card cardv5;
    Card cardv6;

    Card[] enemyHand = new Card[6];

    Crib crib;

    Deck deck = new Deck();
    Card gameCard;

    int cribDebt = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_game2);
        addListenerOnButtonFour();

        crib = new Crib();



        drawPlayerHand();




        addCribListener1();
        addCribListener2();
        addCribListener3();
        addCribListener4();
        addCribListener5();
        addCribListener6();



    }

    public void playPhase()
    {



    }

    public void dealEnemyHand()
    {
        for(int i=0;i<6;i++)
        {
            enemyHand[i] = deck.getRandomCard();
        }
    }









    public void addListenerOnButtonFour() {

        imageButton2 = (ImageButton) findViewById(R.id.backtwo);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }

        });

    }

    public void addCribListener1() {

        imageButton2 = (ImageButton) findViewById(R.id.ivone);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(cardv1.isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView, cardv1, crib);
                    cardv1.isOnTable = false;
                    cribDebt--;
                }
                if(cribDebt == 0)
                    playPhase();


            }

        });

    }
    public void addCribListener2() {

        imageButton2 = (ImageButton) findViewById(R.id.ivtwo);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(cardv2.isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView2, cardv2, crib);
                    cardv2.isOnTable = false;
                    cribDebt--;
                }
                if(cribDebt == 0)
                    playPhase();

            }

        });

    }
    public void addCribListener3() {

        imageButton2 = (ImageButton) findViewById(R.id.ivthree);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(cardv3.isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView3, cardv3, crib);
                    cardv3.isOnTable = false;
                    cribDebt--;
                }
                if(cribDebt == 0)
                    playPhase();

            }

        });

    }

    public void addCribListener4() {

        imageButton2 = (ImageButton) findViewById(R.id.ivfour);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(cardv4.isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView4, cardv4, crib);
                    cardv4.isOnTable = false;
                    cribDebt--;
                }
                if(cribDebt == 0)
                    playPhase();

            }

        });

    }
    public void addCribListener5() {

        imageButton2 = (ImageButton) findViewById(R.id.ivfive);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(cardv5.isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView5, cardv5, crib);
                    cardv5.isOnTable = false;
                    cribDebt--;
                }
                if(cribDebt == 0)
                    playPhase();

            }

        });

    }
    public void addCribListener6() {

        imageButton2 = (ImageButton) findViewById(R.id.ivsix);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(cardv6.isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView6, cardv6, crib);
                    cardv6.isOnTable = false;
                    cribDebt--;
                }
                if(cribDebt == 0)
                    playPhase();

            }

        });

    }


    public void enemyChooseCribCards()
    {
        Random rand1 = new Random();
        int a;

        for(int i=0 ; i<2 ; i++)
        {
            a = rand1.nextInt(6);
            enemyHand[a].sendToCrib();
            drawCribCard(crib.findEmptySlot());
            crib.insertCard(enemyHand[a]);
        }
    }




    public void chooseCribCard(ImageButton imageButton, Card card, Crib crib)
    {
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.blank_card);

        imageButton.setImageBitmap(bitmap2);

        card.sendToCrib();

        drawCribCard(crib.findEmptySlot());



        crib.insertCard(card);

    }

    public void drawCribCard(int slot)
    {
        if(slot == 1)
        {
            ImageButton mImageView6 = (ImageButton) findViewById(R.id.cribone);
            Bitmap card6 = BitmapFactory.decodeResource(getResources(), R.drawable.back_card);
            Bitmap card6Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
            Canvas canvas6 = new Canvas(card6Print);
            canvas6.drawBitmap(card6, 20, 20, null);
            mImageView6.setImageBitmap(card6);
        }
        else if(slot == 2)
        {
            ImageButton mImageView6 = (ImageButton) findViewById(R.id.cribtwo);
            Bitmap card6 = BitmapFactory.decodeResource(getResources(), R.drawable.back_card);
            Bitmap card6Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
            Canvas canvas6 = new Canvas(card6Print);
            canvas6.drawBitmap(card6, 20, 20, null);
            mImageView6.setImageBitmap(card6);
        }
        else if(slot == 3)
        {
            ImageButton mImageView6 = (ImageButton) findViewById(R.id.cribthree);
            Bitmap card6 = BitmapFactory.decodeResource(getResources(), R.drawable.back_card);
            Bitmap card6Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
            Canvas canvas6 = new Canvas(card6Print);
            canvas6.drawBitmap(card6, 20, 20, null);
            mImageView6.setImageBitmap(card6);
        }
        else if(slot == 4)
        {
            ImageButton mImageView6 = (ImageButton) findViewById(R.id.cribfour);
            Bitmap card6 = BitmapFactory.decodeResource(getResources(), R.drawable.back_card);
            Bitmap card6Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
            Canvas canvas6 = new Canvas(card6Print);
            canvas6.drawBitmap(card6, 20, 20, null);
            mImageView6.setImageBitmap(card6);
        }


    }



    //Chooses the correct image for a card that is drawn from the deck.
    public Bitmap bitmapChooser(Deck deck, Card gameCard)
    {
        Bitmap bitmap;



        if(gameCard.value == 1 && gameCard.getSuit() == CLUB)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ace_of_clubs);
        else if(gameCard.value == 2 && gameCard.getSuit() == CLUB)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two_of_clubs);
        else if(gameCard.value == 3 && gameCard.getSuit() == CLUB)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three_of_clubs);
        else if(gameCard.value == 4 && gameCard.getSuit() == CLUB)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four_of_clubs);
        else if(gameCard.value == 5 && gameCard.getSuit() == CLUB)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.five_of_clubs);
        else if(gameCard.value == 6 && gameCard.getSuit() == CLUB)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.six_of_clubs);
        else if(gameCard.value == 7 && gameCard.getSuit() == CLUB)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven_of_clubs);
        else if(gameCard.value == 8 && gameCard.getSuit() == CLUB)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight_of_clubs);
        else if(gameCard.value == 9 && gameCard.getSuit() == CLUB)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nine_of_clubs);
        else if(gameCard.value == 1 && gameCard.getSuit() == DIAMOND)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ace_of_diamonds);
        else if(gameCard.value == 2 && gameCard.getSuit() == DIAMOND)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two_of_diamonds);
        else if(gameCard.value == 3 && gameCard.getSuit() == DIAMOND)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three_of_diamonds);
        else if(gameCard.value == 4 && gameCard.getSuit() == DIAMOND)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four_of_diamonds);
        else if(gameCard.value == 5 && gameCard.getSuit() == DIAMOND)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.five_of_diamonds);
        else if(gameCard.value == 6 && gameCard.getSuit() == DIAMOND)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.six_of_diamonds);
        else if(gameCard.value == 7 && gameCard.getSuit() == DIAMOND)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven_of_diamonds);
        else if(gameCard.value == 8 && gameCard.getSuit() == DIAMOND)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight_of_diamonds);
        else if(gameCard.value == 9 && gameCard.getSuit() == DIAMOND)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nine_of_diamonds);
        else if(gameCard.value == 1 && gameCard.getSuit() == HEART)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ace_of_hearts);
        else if(gameCard.value == 2 && gameCard.getSuit() == HEART)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two_of_hearts);
        else if(gameCard.value == 3 && gameCard.getSuit() == HEART)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three_of_hearts);
        else if(gameCard.value == 4 && gameCard.getSuit() == HEART)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four_of_hearts);
        else if(gameCard.value == 5 && gameCard.getSuit() == HEART)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.five_of_hearts);
        else if(gameCard.value == 6 && gameCard.getSuit() == HEART)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.six_of_hearts);
        else if(gameCard.value == 7 && gameCard.getSuit() == HEART)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven_of_hearts);
        else if(gameCard.value == 8 && gameCard.getSuit() == HEART)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight_of_hearts);
        else if(gameCard.value == 9 && gameCard.getSuit() == HEART)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nine_of_hearts);
        else if(gameCard.value == 1 && gameCard.getSuit() == SPADE)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ace_of_spades);
        else if(gameCard.value == 2 && gameCard.getSuit() == SPADE)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.two_of_spades);
        else if(gameCard.value == 3 && gameCard.getSuit() == SPADE)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.three_of_spades);
        else if(gameCard.value == 4 && gameCard.getSuit() == SPADE)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.four_of_spades);
        else if(gameCard.value == 5 && gameCard.getSuit() == SPADE)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.five_of_spades);
        else if(gameCard.value == 6 && gameCard.getSuit() == SPADE)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.six_of_spades);
        else if(gameCard.value == 7 && gameCard.getSuit() == SPADE)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seven_of_spades);
        else if(gameCard.value == 8 && gameCard.getSuit() == SPADE)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eight_of_spades);
        else if(gameCard.value == 9 && gameCard.getSuit() == SPADE)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nine_of_spades);
        else if(gameCard.value == 10 && gameCard.getSuit() == SPADE && !gameCard.isJack == false && gameCard.isQueen == false && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten_of_spades);
        else if(gameCard.value == 10 && gameCard.getSuit() == HEART && gameCard.isJack == false && gameCard.isQueen == false && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten_of_hearts);
        else if(gameCard.value == 10 && gameCard.getSuit() == DIAMOND && gameCard.isJack == false && gameCard.isQueen == false && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten_of_diamonds);
        else if(gameCard.value == 10 && gameCard.getSuit() == CLUB && gameCard.isJack == false && gameCard.isQueen == false && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ten_of_clubs);
        else if(gameCard.value == 10 && gameCard.getSuit() == SPADE && gameCard.isJack == true && gameCard.isQueen == false && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jack_of_spades);
        else if(gameCard.value == 10 && gameCard.getSuit() == HEART && gameCard.isJack == true && gameCard.isQueen == false && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jack_of_hearts);
        else if(gameCard.value == 10 && gameCard.getSuit() == DIAMOND && gameCard.isJack == true && gameCard.isQueen == false && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jack_of_diamonds);
        else if(gameCard.value == 10 && gameCard.getSuit() == CLUB && gameCard.isJack == true && gameCard.isQueen == false && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jack_of_clubs);
        else if(gameCard.value == 10 && gameCard.getSuit() == SPADE && gameCard.isJack == false && gameCard.isQueen == true && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.queen_of_spades);
        else if(gameCard.value == 10 && gameCard.getSuit() == HEART && gameCard.isJack == false && gameCard.isQueen == true && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.queen_of_hearts);
        else if(gameCard.value == 10 && gameCard.getSuit() == DIAMOND && gameCard.isJack == false && gameCard.isQueen == true && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.queen_of_diamonds);
        else if(gameCard.value == 10 && gameCard.getSuit() == CLUB && gameCard.isJack == false && gameCard.isQueen == true && gameCard.isKing == false)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.queen_of_clubs);
        else if(gameCard.value == 10 && gameCard.getSuit() == SPADE && gameCard.isJack == false && gameCard.isQueen == false && gameCard.isKing == true)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.king_of_spades);
        else if(gameCard.value == 10 && gameCard.getSuit() == HEART && gameCard.isJack == false && gameCard.isQueen == false && gameCard.isKing == true)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.king_of_hearts);
        else if(gameCard.value == 10 && gameCard.getSuit() == DIAMOND && gameCard.isJack == false && gameCard.isQueen == false && gameCard.isKing == true)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.king_of_diamonds);
        else if(gameCard.value == 10 && gameCard.getSuit() == CLUB && gameCard.isJack == false && gameCard.isQueen == false && gameCard.isKing == true)
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.king_of_clubs);
        else
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.king_of_clubs);

        return bitmap;


    }

    public void terminate()
    {
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void drawPlayerHand()
    {
        mImageView = (ImageButton) findViewById(R.id.ivone);
        gameCard = deck.getRandomCard();
        Bitmap card1 = bitmapChooser(deck, gameCard);
        Bitmap card1Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(card1Print);
        canvas.drawBitmap(card1, 20, 20, null);
        mImageView.setImageBitmap(card1);
        cardv1 = gameCard;
        cardv1.isOnTable = true;


        mImageView2 = (ImageButton) findViewById(R.id.ivtwo);
        gameCard = deck.getRandomCard();
        Bitmap card2 = bitmapChooser(deck, gameCard);
        Bitmap card2Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(card2Print);
        canvas2.drawBitmap(card2, 20, 20, null);
        mImageView2.setImageBitmap(card2);
        cardv2 = gameCard;
        cardv2.isOnTable = true;


        mImageView3 = (ImageButton) findViewById(R.id.ivthree);
        gameCard = deck.getRandomCard();
        Bitmap card3 = bitmapChooser(deck, gameCard);
        Bitmap card3Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas3 = new Canvas(card3Print);
        canvas3.drawBitmap(card3, 20, 20, null);
        mImageView3.setImageBitmap(card3);
        cardv3 = gameCard;
        cardv3.isOnTable = true;


        mImageView4 = (ImageButton) findViewById(R.id.ivfour);
        gameCard = deck.getRandomCard();
        Bitmap card4 = bitmapChooser(deck, gameCard);
        Bitmap card4Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas4 = new Canvas(card4Print);
        canvas4.drawBitmap(card4, 20, 20, null);
        mImageView4.setImageBitmap(card4);
        cardv4 = gameCard;
        cardv4.isOnTable = true;


        mImageView5 = (ImageButton) findViewById(R.id.ivfive);
        gameCard = deck.getRandomCard();
        Bitmap card5 = bitmapChooser(deck, gameCard);
        Bitmap card5Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas5 = new Canvas(card5Print);
        canvas5.drawBitmap(card5, 20, 20, null);
        mImageView5.setImageBitmap(card5);
        cardv5 = gameCard;
        cardv5.isOnTable = true;


        mImageView6 = (ImageButton) findViewById(R.id.ivsix);
        gameCard = deck.getRandomCard();
        Bitmap card6 = bitmapChooser(deck, gameCard);
        Bitmap card6Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas6 = new Canvas(card6Print);
        canvas6.drawBitmap(card6, 20, 20, null);
        mImageView6.setImageBitmap(card6);
        cardv6 = gameCard;
        cardv6.isOnTable = true;
    }


}
