package org.khanacademy.miniputt;

import android.graphics.Canvas;
import android.graphics.Paint;

class GameCode {
    private static Paint paint = new Paint();
    private static Canvas canvas;
    static void draw(Canvas c) {
        canvas = c;
    }

}
