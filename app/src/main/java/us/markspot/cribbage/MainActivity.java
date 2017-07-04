package us.markspot.cribbage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.R.attr.bitmap;
import static android.R.attr.id;
import static us.markspot.cribbage.Card.Suit.CLUB;
import static us.markspot.cribbage.Card.Suit.DIAMOND;
import static us.markspot.cribbage.Card.Suit.HEART;
import static us.markspot.cribbage.Card.Suit.SPADE;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;

    Card gameCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        addListenerOnButtonTwo();



            }

    public void addListenerOnButton() {

        imageButton = (ImageButton) findViewById(R.id.StartGame);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                setContentView(R.layout.activity_game);
                addListenerOnButtonFour();



                Context mContext = getApplicationContext();
                Resources mResources = getResources();
                RelativeLayout mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
                ImageButton mImageView = (ImageButton) findViewById(R.id.ivone);

                Deck deck = new Deck();

                Bitmap card1 = bitmapChooser(deck);

                Bitmap card1Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);

                Canvas canvas = new Canvas(card1Print);



                canvas.drawBitmap(card1, 20, 20, null);

                mImageView.setImageBitmap(card1);







                ImageButton mImageView2 = (ImageButton) findViewById(R.id.ivtwo);



                Bitmap card2 = bitmapChooser(deck);

                Bitmap card2Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);

                Canvas canvas2 = new Canvas(card2Print);



                canvas2.drawBitmap(card2, 20, 20, null);

                mImageView2.setImageBitmap(card2);








                ImageButton mImageView3 = (ImageButton) findViewById(R.id.ivthree);



                Bitmap card3 = bitmapChooser(deck);

                Bitmap card3Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);

                Canvas canvas3 = new Canvas(card3Print);



                canvas3.drawBitmap(card3, 20, 20, null);

                mImageView3.setImageBitmap(card3);









                ImageButton mImageView4 = (ImageButton) findViewById(R.id.ivfour);



                Bitmap card4 = bitmapChooser(deck);

                Bitmap card4Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);

                Canvas canvas4 = new Canvas(card4Print);



                canvas4.drawBitmap(card4, 20, 20, null);

                mImageView4.setImageBitmap(card4);










                ImageButton mImageView5 = (ImageButton) findViewById(R.id.ivfive);



                Bitmap card5 = bitmapChooser(deck);

                Bitmap card5Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);

                Canvas canvas5 = new Canvas(card5Print);



                canvas5.drawBitmap(card5, 20, 20, null);

                mImageView5.setImageBitmap(card5);












                ImageButton mImageView6 = (ImageButton) findViewById(R.id.ivsix);



                Bitmap card6 = bitmapChooser(deck);

                Bitmap card6Print = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);

                Canvas canvas6 = new Canvas(card6Print);



                canvas6.drawBitmap(card6, 20, 20, null);

                mImageView6.setImageBitmap(card6);





            }

        });

    }


    public void addListenerOnButtonTwo() {

        imageButton2 = (ImageButton) findViewById(R.id.settings);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                setContentView(R.layout.activity_difficulty);
                addListenerOnButtonThree();

            }

        });

    }

    public void addListenerOnButtonThree() {

        imageButton2 = (ImageButton) findViewById(R.id.backone);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                setContentView(R.layout.activity_main);
                addListenerOnButton();
                addListenerOnButtonTwo();

            }

        });

    }


    public void addListenerOnButtonFour() {

        imageButton2 = (ImageButton) findViewById(R.id.backtwo);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                setContentView(R.layout.activity_main);
                addListenerOnButton();
                addListenerOnButtonTwo();

            }

        });

    }



    public Bitmap bitmapChooser(Deck deck)
    {
        Bitmap bitmap;

        gameCard = deck.getRandomCard();

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
        else if(gameCard.value == 10 && gameCard.getSuit() == SPADE && gameCard.isJack == false && gameCard.isQueen == false && gameCard.isKing == false)
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





}




