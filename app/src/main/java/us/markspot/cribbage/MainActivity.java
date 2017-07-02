package us.markspot.cribbage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;


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

}




