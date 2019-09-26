package org.khanacademy.miniputt;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class GameCode {
    private static Paint paint = new Paint();
    private static Canvas canvas;
    static void draw(Canvas c) {
        canvas = c;

        pjsCode();
    }
    static void rect(float x, float y, float w, float h) {
        canvas.drawRect(x, y, x + w, y + h, paint);
    }
    static void fill(int r, int g, int b) {
        paint.setColor(Color.rgb(r, g, b));
    }
    static void fill(int shade) {
        paint.setColor(Color.rgb(shade, shade, shade));
    }
    static void pjsCode() {

    }
}
