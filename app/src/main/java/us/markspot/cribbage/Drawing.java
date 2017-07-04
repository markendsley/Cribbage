package us.markspot.cribbage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Bob Dole on 7/3/2017.
 */

public class Drawing extends View {

    public Drawing(Context context) {
        super(context);

    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);



        Rect ourRect = new Rect();
        ourRect.set(0,0,canvas.getWidth(), canvas.getHeight()/2);

        Paint blue = new Paint();
        blue.setColor(Color.RED);
        blue.setStyle(Paint.Style.FILL);

        canvas.drawRect(ourRect, blue);


    }

}
