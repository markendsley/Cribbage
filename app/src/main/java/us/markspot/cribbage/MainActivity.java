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

    Crib crib;

    static boolean gameIsStarted = false;


    Card gameCard;

    int cribDebt = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        addListenerOnButtonTwo();
        addListenerOnButtonResume();


            }

    public void addListenerOnButton() {

        imageButton = (ImageButton) findViewById(R.id.StartGame);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {




                gameIsStarted = true;

                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);



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


    public void addListenerOnButtonResume() {

        imageButton2 = (ImageButton) findViewById(R.id.resume);

        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

            if(gameIsStarted)
            finish();


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
                addListenerOnButtonResume();

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
                addListenerOnButtonResume();

            }

        });

    }







}




