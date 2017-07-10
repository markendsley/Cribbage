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
import android.widget.ImageView;
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

    ImageView[] playImages = new ImageView[8];

    ImageView splitImageView;

    Card cardv1;
    Card cardv2;
    Card cardv3;
    Card cardv4;
    Card cardv5;
    Card cardv6;

    Card[] enemyHand = new Card[6];
    Card[] playerHand = new Card[6];

    Crib crib;

    Deck deck = new Deck();
    Card gameCard;
    Card splitCard;

    int cribDebt = 2;
    int playerScore = 0;
    int enemyScore = 0;

    int playerNumberCardsInPlay = 0;
    int enemyNumberCardsInPlay = 0;
    int numberCardsInPlay = 0;

    Card[] cardsInPlay = new Card[8];
    boolean playerTurn = true;


    int roundCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_game2);
        addListenerOnButtonFour();

        crib = new Crib();



        drawPlayerHand();
        drawEnemyHand();



        addCribListener1();
        addCribListener2();
        addCribListener3();
        addCribListener4();
        addCribListener5();
        addCribListener6();



    }

    public void playPhase()
    {

        enemyChooseCribCards();
        drawSplitCard();
        createPlayImages();

        addPlayListener1();

    }

    public void drawEnemyHand()
    {
        for(int i=0;i<6;i++)
        {
            enemyHand[i] = deck.getRandomCard();
            enemyHand[i].isOnTable = true;
            enemyHand[i].isEnemys = true;

        }
    }

    public Card createEmptyCard()
    {
        Card card = new Card(0,HEART);
        return card;

    }

    public void drawSplitCard()
    {
        splitCard = deck.getRandomCard();

        splitImageView = (ImageView) findViewById(R.id.deckimage);
        Bitmap split = bitmapChooser(deck, splitCard);
        Bitmap splitPrint = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(splitPrint);
        canvas.drawBitmap(split, 20, 20, null);
        splitImageView.setImageBitmap(split);

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


    public void addPlayListener1() {

        imageButton2 = (ImageButton) findViewById(R.id.ivone);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
            if(playerHand[0].isOnTable && (playerHand[0].value + roundCounter <= 31) && playerTurn == true)
                {
                    cardsInPlay[numberCardsInPlay] = playerHand[0];
                    playerHand[0].inPlay = true;
                    playerHand[0].isOnTable = false;

                    Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.blank_card);

                    imageButton2.setImageBitmap(bitmap2);

                    setPlayImage(playerHand[0]);

                    roundCounter += playerHand[0].value;


                }


            }

        });

    }

    public void addPlayListener2() {

        imageButton2 = (ImageButton) findViewById(R.id.ivtwo);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {



            }

        });

    }

    public void addPlayListener3() {

        imageButton2 = (ImageButton) findViewById(R.id.ivthree);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {



            }

        });

    }

    public void addPlayListener4() {

        imageButton2 = (ImageButton) findViewById(R.id.ivfour);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {



            }

        });

    }

    public void addPlayListener5() {

        imageButton2 = (ImageButton) findViewById(R.id.ivfive);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {



            }

        });

    }

    public void addPlayListener6() {

        imageButton2 = (ImageButton) findViewById(R.id.ivsix);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {



            }

        });

    }


    public void setPlayImage(Card card)
    {
        Bitmap bitmap2 = bitmapChooser(deck,card);

        playImages[numberCardsInPlay].setImageBitmap(bitmap2);


    }

    public void createPlayImages()
    {
        playImages[0] = (ImageView) findViewById(R.id.playone);
        playImages[1] = (ImageView) findViewById(R.id.playtwo);
        playImages[2] = (ImageView) findViewById(R.id.playthree);
        playImages[3] = (ImageView) findViewById(R.id.playfour);
        playImages[4] = (ImageView) findViewById(R.id.playfive);
        playImages[5] = (ImageView) findViewById(R.id.playsix);
        playImages[6] = (ImageView) findViewById(R.id.playseven);
        playImages[7] = (ImageView) findViewById(R.id.playeight);
    }








    public void addCribListener1() {

        imageButton2 = (ImageButton) findViewById(R.id.ivone);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(playerHand[0].isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView, playerHand[0], crib);
                    playerHand[0].isOnTable = false;
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
                if(playerHand[1].isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView2, playerHand[1], crib);
                    playerHand[1].isOnTable = false;
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
                if(playerHand[2].isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView3, playerHand[2], crib);
                    playerHand[2].isOnTable = false;
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
                if(playerHand[3].isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView4, playerHand[3], crib);
                    playerHand[3].isOnTable = false;
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
                if(playerHand[4].isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView5, playerHand[4], crib);
                    playerHand[4].isOnTable = false;
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
                if(playerHand[5].isOnTable && cribDebt != 0)
                {
                    chooseCribCard(mImageView6, playerHand[5], crib);
                    playerHand[5].isOnTable = false;
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
            enemyHand[a].isOnTable = false;
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
        playerHand[0] = gameCard;
        playerHand[0].isOnTable = true;
        playerHand[0].isPlayers = true;


        mImageView2 = (ImageButton) findViewById(R.id.ivtwo);
        gameCard = deck.getRandomCard();
        Bitmap card2 = bitmapChooser(deck, gameCard);
        Bitmap card2Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(card2Print);
        canvas2.drawBitmap(card2, 20, 20, null);
        mImageView2.setImageBitmap(card2);
        playerHand[1] = gameCard;
        playerHand[1].isOnTable = true;
        playerHand[1].isPlayers = true;


        mImageView3 = (ImageButton) findViewById(R.id.ivthree);
        gameCard = deck.getRandomCard();
        Bitmap card3 = bitmapChooser(deck, gameCard);
        Bitmap card3Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas3 = new Canvas(card3Print);
        canvas3.drawBitmap(card3, 20, 20, null);
        mImageView3.setImageBitmap(card3);
        playerHand[2] = gameCard;
        playerHand[2].isOnTable = true;
        playerHand[2].isPlayers = true;


        mImageView4 = (ImageButton) findViewById(R.id.ivfour);
        gameCard = deck.getRandomCard();
        Bitmap card4 = bitmapChooser(deck, gameCard);
        Bitmap card4Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas4 = new Canvas(card4Print);
        canvas4.drawBitmap(card4, 20, 20, null);
        mImageView4.setImageBitmap(card4);
        playerHand[3] = gameCard;
        playerHand[3].isOnTable = true;
        playerHand[3].isPlayers = true;


        mImageView5 = (ImageButton) findViewById(R.id.ivfive);
        gameCard = deck.getRandomCard();
        Bitmap card5 = bitmapChooser(deck, gameCard);
        Bitmap card5Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas5 = new Canvas(card5Print);
        canvas5.drawBitmap(card5, 20, 20, null);
        mImageView5.setImageBitmap(card5);
        playerHand[4] = gameCard;
        playerHand[4].isOnTable = true;
        playerHand[4].isPlayers = true;


        mImageView6 = (ImageButton) findViewById(R.id.ivsix);
        gameCard = deck.getRandomCard();
        Bitmap card6 = bitmapChooser(deck, gameCard);
        Bitmap card6Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        Canvas canvas6 = new Canvas(card6Print);
        canvas6.drawBitmap(card6, 20, 20, null);
        mImageView6.setImageBitmap(card6);
        playerHand[5] = gameCard;
        playerHand[5].isOnTable = true;
        playerHand[5].isPlayers = true;
    }


}
