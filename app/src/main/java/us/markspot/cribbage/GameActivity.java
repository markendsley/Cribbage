package us.markspot.cribbage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;


import static us.markspot.cribbage.Card.Suit.CLUB;
import static us.markspot.cribbage.Card.Suit.DIAMOND;
import static us.markspot.cribbage.Card.Suit.HEART;
import static us.markspot.cribbage.Card.Suit.SPADE;

public class GameActivity extends AppCompatActivity {

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;

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
    int playerCardsLeft = 4;
    int enemyCardsLeft = 4;


    int playerNumberCardsInPlay = 0;
    int enemyNumberCardsInPlay = 0;
    int numberCardsInPlay = 0;

    Card[] cardsInPlay = new Card[20];
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


    //Sets Round Counter To Current Value
    public void setRoundCounter()
    {
        TextView tv = (TextView)findViewById(R.id.roundcounter);
        tv.setText(String.valueOf(roundCounter));
    }


    //Phase Initiated After Player Gives To Crib
    public void playPhase()
    {

        playerCardsLeft = 4;
        enemyCardsLeft = 4;
        numberCardsInPlay = 0;
        addPlayListener1();
        addPlayListener2();
        addPlayListener3();
        addPlayListener4();
        addPlayListener5();
        addPlayListener6();
        enemyChooseCribCards();
        drawSplitCard();
        createPlayImages();





    }

    //Draws Hand For AI
    public void drawEnemyHand()
    {
        for(int i=0;i<6;i++)
        {
            enemyHand[i] = deck.getRandomCard();
            enemyHand[i].isOnTable = true;
            enemyHand[i].isEnemys = true;

        }
    }

    //Creates Card With A Value Of Zero (This function has no use yet)
    public Card createEmptyCard()
    {
        Card card = new Card(0,HEART);
        return card;

    }

    //Draws Split Card And Places On Top Of Deck
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




    //Adds Listener And Functionality For Back Button
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

    //Tests If Any Cards In A Hand Can Be Played
    public boolean canPlay(Card[] card)
    {
        for(int i=0;i<6;i++)
        {
            if(card[i].isOnTable && (card[i].value + roundCounter) <= 31)
            {

                return true;

            }

        }
        return false;
    }

    //Enemy Turn Handler This Function Is A MONSTER
    public void enemyTurn()
    {

        if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
        {
            roundCounter = 0;
            setRoundCounter();

        }


        if(canPlay(enemyHand)==true && enemyCardsLeft != 0)
        {








            Random rand1 = new Random();
            int a;
            a = rand1.nextInt(6);

            while((enemyHand[a].value + roundCounter) > 31 || enemyHand[a].isOnTable != true )
            {
                a = rand1.nextInt(6);
            }

            cardsInPlay[numberCardsInPlay] = enemyHand[a];

            setPlayImage(enemyHand[a]);
            roundCounter += enemyHand[a].value;
            enemyCardsLeft--;
            numberCardsInPlay++;

            enemyHand[a].isOnTable = false;
            enemyHand[a].inPlay = true;

            setRoundCounter();



            if(canPlay(playerHand) == false && canPlay(enemyHand) == true && enemyCardsLeft != 0)
            {


               while(canPlay(enemyHand) == true && enemyCardsLeft !=0 && canPlay(playerHand) != true)
               {


                   a = rand1.nextInt(6);

                   while((enemyHand[a].value + roundCounter) > 31 || enemyHand[a].isOnTable != true )
                   {
                       a = rand1.nextInt(6);
                   }

                   cardsInPlay[numberCardsInPlay] = enemyHand[a];

                   setPlayImage(enemyHand[a]);
                   roundCounter += enemyHand[a].value;
                   enemyCardsLeft--;
                   numberCardsInPlay++;

                   enemyHand[a].isOnTable = false;
                   enemyHand[a].inPlay = true;

                   setRoundCounter();


               }

               if(playerCardsLeft < 1 && canPlay(enemyHand) == true){
                   while(enemyCardsLeft > 0){
                       a = rand1.nextInt(6);

                       while((enemyHand[a].value + roundCounter) > 31 || enemyHand[a].isOnTable != true )
                       {
                           a = rand1.nextInt(6);
                       }

                       cardsInPlay[numberCardsInPlay] = enemyHand[a];

                       setPlayImage(enemyHand[a]);
                       roundCounter += enemyHand[a].value;
                       enemyCardsLeft--;
                       numberCardsInPlay++;

                       enemyHand[a].isOnTable = false;
                       enemyHand[a].inPlay = true;

                       setRoundCounter();
                   }

               }

                if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                {
                    roundCounter = 0;
                    setRoundCounter();

                    if(canPlay(enemyHand) == true) {


                        while (enemyCardsLeft > 0 && canPlay(playerHand) == false) {
                            a = rand1.nextInt(6);

                            while ((enemyHand[a].value + roundCounter) > 31 || enemyHand[a].isOnTable != true) {
                                a = rand1.nextInt(6);
                            }

                            cardsInPlay[numberCardsInPlay] = enemyHand[a];

                            setPlayImage(enemyHand[a]);
                            roundCounter += enemyHand[a].value;
                            enemyCardsLeft--;
                            numberCardsInPlay++;

                            enemyHand[a].isOnTable = false;
                            enemyHand[a].inPlay = true;

                            setRoundCounter();

                            if(playerCardsLeft < 1 && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                            {
                                roundCounter = 0;
                                setRoundCounter();
                            }
                        }

                    }

                }



            }






        for(int i=0;i<6;i++)
        {
            System.out.println(enemyHand[i].value + " " + enemyHand[i].isOnTable);
        }



        }


        if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
        {
            roundCounter = 0;
            setRoundCounter();

        }



        playerTurn = true;


    }

    //Listeners On Cards For Play Phase These Functions Are The Same
    public void addPlayListener1() {

        imageButton1 = (ImageButton) findViewById(R.id.ivone);

        imageButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                {
                    roundCounter = 0;
                    setRoundCounter();
                }





            if(playerHand[0].isOnTable && (playerHand[0].value + roundCounter) <= 31 )
                {





                    cardsInPlay[numberCardsInPlay] = playerHand[0];
                    playerHand[0].inPlay = true;
                    playerHand[0].isOnTable = false;

                    Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.blank_card);

                    imageButton1.setImageBitmap(bitmap2);

                    setPlayImage(playerHand[0]);

                    roundCounter += playerHand[0].value;
                    numberCardsInPlay++;
                    playerTurn = false;


                    playerCardsLeft--;
                    setRoundCounter();



                    if(canPlay(playerHand) != true)
                    {
                        while(canPlay(enemyHand)==true && enemyCardsLeft > 0)
                        {
                            enemyTurn();
                        }
                    }else{
                        if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                        {
                            roundCounter = 0;
                            setRoundCounter();
                        }
                        enemyTurn();
                    }


                }


            }

        });

    }

    public void addPlayListener2() {

        imageButton2 = (ImageButton) findViewById(R.id.ivtwo);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                {
                    roundCounter = 0;
                    setRoundCounter();
                }




                if(playerHand[1].isOnTable && (playerHand[1].value + roundCounter) <= 31 )
                {





                    cardsInPlay[numberCardsInPlay] = playerHand[1];
                    playerHand[1].inPlay = true;
                    playerHand[1].isOnTable = false;

                    Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.blank_card);

                    imageButton2.setImageBitmap(bitmap2);

                    setPlayImage(playerHand[1]);

                    roundCounter += playerHand[1].value;
                    numberCardsInPlay++;
                    playerTurn = false;
                    setRoundCounter();

                    playerCardsLeft--;

                    if(canPlay(playerHand) != true)
                    {
                        while(canPlay(enemyHand)==true&& enemyCardsLeft > 0)
                        {
                            enemyTurn();
                        }
                    }else{
                        if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                        {
                            roundCounter = 0;
                            setRoundCounter();
                        }
                        enemyTurn();
                    }


                }


            }

        });

    }

    public void addPlayListener3() {

        imageButton3 = (ImageButton) findViewById(R.id.ivthree);

        imageButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                {
                    roundCounter = 0;
                    setRoundCounter();
                }





                if(playerHand[2].isOnTable && (playerHand[2].value + roundCounter) <= 31 )
                {





                    cardsInPlay[numberCardsInPlay] = playerHand[2];
                    playerHand[2].inPlay = true;
                    playerHand[2].isOnTable = false;

                    Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.blank_card);

                    imageButton3.setImageBitmap(bitmap2);

                    setPlayImage(playerHand[2]);

                    roundCounter += playerHand[2].value;
                    numberCardsInPlay++;
                    playerTurn = false;
                    setRoundCounter();

                    playerCardsLeft--;

                    if(canPlay(playerHand) != true)
                    {
                        while(canPlay(enemyHand)==true&& enemyCardsLeft > 0)
                        {
                            enemyTurn();
                        }
                    }else{
                        if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                        {
                            roundCounter = 0;
                            setRoundCounter();
                        }
                        enemyTurn();
                    }

                }


            }

        });

    }

    public void addPlayListener4() {

        imageButton4 = (ImageButton) findViewById(R.id.ivfour);

        imageButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                {
                    roundCounter = 0;
                    setRoundCounter();
                }




                if(playerHand[3].isOnTable && (playerHand[3].value + roundCounter) <= 31 )
                {






                    cardsInPlay[numberCardsInPlay] = playerHand[3];
                    playerHand[3].inPlay = true;
                    playerHand[3].isOnTable = false;

                    Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.blank_card);

                    imageButton4.setImageBitmap(bitmap2);

                    setPlayImage(playerHand[3]);

                    roundCounter += playerHand[3].value;
                    numberCardsInPlay++;
                    playerTurn = false;
                    setRoundCounter();

                    playerCardsLeft--;

                    if(canPlay(playerHand) != true)
                    {
                        while(canPlay(enemyHand)==true&& enemyCardsLeft > 0)
                        {
                            enemyTurn();
                        }
                    }else{
                        if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                        {
                            roundCounter = 0;
                            setRoundCounter();
                        }
                        enemyTurn();
                    }

                }

            }

        });

    }

    public void addPlayListener5() {

        imageButton5 = (ImageButton) findViewById(R.id.ivfive);

        imageButton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                {
                    roundCounter = 0;
                    setRoundCounter();
                }




                if(playerHand[4].isOnTable && (playerHand[4].value + roundCounter) <= 31 )
                {






                    cardsInPlay[numberCardsInPlay] = playerHand[4];
                    playerHand[4].inPlay = true;
                    playerHand[4].isOnTable = false;

                    Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.blank_card);

                    imageButton5.setImageBitmap(bitmap2);

                    setPlayImage(playerHand[4]);

                    roundCounter += playerHand[4].value;
                    numberCardsInPlay++;
                    playerTurn = false;
                    setRoundCounter();

                    playerCardsLeft--;

                    if(canPlay(playerHand) != true)
                    {
                        while(canPlay(enemyHand)==true&& enemyCardsLeft > 0)
                        {
                            enemyTurn();
                        }
                    }else{
                        if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                        {
                            roundCounter = 0;
                            setRoundCounter();

                        }
                        enemyTurn();
                    }

                }


            }

        });

    }

    public void addPlayListener6() {

        imageButton6 = (ImageButton) findViewById(R.id.ivsix);

        imageButton6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                {
                    roundCounter = 0;
                    setRoundCounter();
                }




                if(playerHand[5].isOnTable && (playerHand[5].value + roundCounter) <= 31 )
                {
                    cardsInPlay[numberCardsInPlay] = playerHand[5];
                    playerHand[5].inPlay = true;
                    playerHand[5].isOnTable = false;

                    Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.blank_card);

                    imageButton6.setImageBitmap(bitmap2);

                    setPlayImage(playerHand[5]);

                    roundCounter += playerHand[5].value;
                    numberCardsInPlay++;
                    playerTurn = false;
                    setRoundCounter();

                    playerCardsLeft--;

                    if(canPlay(playerHand) != true)
                    {
                        while(canPlay(enemyHand)==true&& enemyCardsLeft > 0)
                        {
                            enemyTurn();
                        }
                    }else{
                        if(canPlay(playerHand) == false && canPlay(enemyHand) == false&& numberCardsInPlay < 8)
                        {
                            roundCounter = 0;
                            setRoundCounter();
                        }
                        enemyTurn();
                    }



                }


            }

        });

    }

    //Sets Image of Card In Play For The Next Open Place
    public void setPlayImage(Card card)
    {
        Bitmap bitmap2 = bitmapChooser(deck,card);

        playImages[numberCardsInPlay].setImageBitmap(bitmap2);


    }

    //Creates Areas For Play Cards To Be Placed
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



    //Listeners On Cards For Crib Phase
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

    //AI Player Chooses Cards Out Of Hand For Crib
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



    //Moves Card From Player Hand To Crib
    public void chooseCribCard(ImageButton imageButton, Card card, Crib crib)
    {
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.blank_card);

        imageButton.setImageBitmap(bitmap2);

        card.sendToCrib();

        drawCribCard(crib.findEmptySlot());



        crib.insertCard(card);

    }

    //Draws Card In Crib In Next Empty Slot
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

    //Kills Activity
    public void terminate()
    {
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    //Creates Player Hand
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
