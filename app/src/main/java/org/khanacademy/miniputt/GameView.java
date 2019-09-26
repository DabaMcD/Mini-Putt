package org.khanacademy.miniputt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    private Paint paint = new Paint();
    public GameView(Context context) {
        super(context);
    }
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        canvas.drawPaint(paint);
        GameCode.draw(canvas);

        super.onDraw(canvas);
    }
    public void draw() {
        invalidate();
        requestLayout();
    }
}
