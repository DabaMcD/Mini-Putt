package org.khanacademy.miniputt;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

class GameCode {
    private char tah = 'l'; // Text Align Horizontal | l ==> left | c ==> center | r ==> right
    private char tav = 'b'; // Text Align Vertical | b ==> bottom | c ==> center | t ==> top
    private static Paint pf = new Paint(Paint.ANTI_ALIAS_FLAG); // Paint fill
    private static Paint ps = new Paint(Paint.ANTI_ALIAS_FLAG); // Paint stroke
    private static Canvas canvas;
    static void draw(Canvas c) {
        canvas = c;
        pf.setStyle(Paint.Style.FILL);
        ps.setStyle(Paint.Style.STROKE);

        pjsCode();
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
                x,
                y,
                pf
        );
    }
    private static void pjsCode() {

    }
}
