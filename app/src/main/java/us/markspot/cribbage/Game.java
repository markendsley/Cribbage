package us.markspot.cribbage;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.lang.Object;

import static android.R.attr.left;

/**
 * Created by Bob Dole on 7/3/2017.
 */

public class Game extends Activity {

    Drawing v;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        v = new Drawing(this);
        setContentView(v);
    }


}
