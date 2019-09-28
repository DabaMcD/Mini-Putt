package org.khanacademy.miniputt;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

class GameCode {
    // Text-specific variables-
    private final static int CENTER = 0;
    private final static int TOP = 1;
    private final static int BOTTOM = 2;
    private final static int LEFT = 3;
    private final static int RIGHT = 4;
    private static int tah = LEFT;
    private static int tav = BOTTOM;

    // Drawing variables
    private static Paint pf = new Paint(Paint.ANTI_ALIAS_FLAG); // Paint fill
    private static Paint ps = new Paint(Paint.ANTI_ALIAS_FLAG); // Paint stroke
    private static Canvas canvas;

    static void draw(Canvas c) {
        canvas = c;
        pf.setStyle(Paint.Style.FILL);
        ps.setStyle(Paint.Style.STROKE);

        pjsCode();
    }
    private static void background(int r, int g, int b) {
        Paint paint = new Paint();
        paint.set(pf);
        pf.setColor(Color.rgb(r, g, b));
        canvas.drawRect(0, 0, 400, 400, pf);
        pf.set(paint);
    }
    private static void background(int shade) {
        Paint paint = new Paint();
        paint.set(pf);
        pf.setColor(Color.rgb(shade, shade, shade));
        canvas.drawRect(0, 0, 400, 400, pf);
        pf.set(paint);
    }
    private static void noFill() {
        pf.setColor(Color.TRANSPARENT);
    }
    private static void fill(int r, int g, int b) {
        pf.setColor(Color.rgb(r, g, b));
    }
    private static void fill(int shade) {
        pf.setColor(Color.rgb(shade, shade, shade));
    }
    private static void noStroke() {
        ps.setColor(Color.TRANSPARENT);
    }
    private static void stroke(int r, int g, int b) {
        ps.setColor(Color.rgb(r, g, b));
    }
    private static void stroke(int shade) {
        ps.setColor(Color.rgb(shade, shade, shade));
    }
    private static void line(float x1, float y1, float x2, float y2) {
        canvas.drawLine(x1, y1, x2, y2, ps);
    }
    private static void rect(float x, float y, float w, float h) {
        canvas.drawRect(x, y, x + w, y + h, pf);
        canvas.drawRect(x, y, x + w, y + h, ps);
    }
    private static void ellipse(float x, float y, float w, float h) {
        RectF r = new RectF(x - (w / 2), y - (h / 2), x + (w / 2), y + (h / 2));
        canvas.drawOval(r, pf);
        canvas.drawOval(r, ps);
    }
    private static void text(String txt, float x, float y) {
        canvas.drawText(
                txt,
                x - ((tah == LEFT) ? 0 : (tah == CENTER) ? pf.measureText(txt) / 2 : pf.measureText(txt)),
                y + ((tav == BOTTOM) ? 0 : (tav == CENTER) ? pf.getTextSize() / 2 : pf.getTextSize()),
                pf
        );
    }
    private static void setTextAlign(int h, int v) {
        tah = h;
        tav = v;
    }
    private static void triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
        Path p = new Path();
        canvas.drawPath(p, pf);
    }
    private static void pjsCode() {

    }
}
