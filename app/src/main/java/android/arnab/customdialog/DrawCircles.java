package android.arnab.customdialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.concurrent.TimeUnit;

public class DrawCircles extends View
{
    private Paint paint = new Paint();
    float centerX, centerY;
    float radius[];
    int index;
    int colors[];

    public DrawCircles(Context context) {
        super(context);
    }

    public DrawCircles(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCircles(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL);
        final Canvas c = canvas;
        for (int a = index-1; a >=0; a--)
        {
            paint.setColor(colors[a]);
            c.drawCircle(centerX, centerY, radius[a], paint);
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        for (int a = 0; a < index; a++)
        {
            c.drawCircle(centerX, centerY, radius[a], paint);
        }
    }

    public void draw(float centerX, float centerY, float radius[], int colors[], int index)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.index = index;
        this.colors=colors;
        invalidate();
        requestLayout();
    }
}
