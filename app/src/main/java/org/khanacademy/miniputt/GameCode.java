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
    private static int tah = LEFT; // Text Align Horizontal
    private static int tav = BOTTOM; // Text Align Vertical

    // Drawing variables
    private static Paint pf = new Paint(Paint.ANTI_ALIAS_FLAG); // Paint fill
    private static Paint ps = new Paint(Paint.ANTI_ALIAS_FLAG); // Paint stroke
    private static Canvas canvas;

    // PJS vars
    private static float ballPOSx = 200;
    private static float ballPOSy = 200;
    private static boolean drop = false;
    private static boolean Level1 = false;
    private static boolean Level2 = false;
    private static boolean Level3 = false;
    private static boolean Level4 = false;
    private static boolean Level5 = false;
    private static boolean Level6 = false;
    private static boolean Level7 = false;
    private static boolean Level8 = false;
    private static boolean Level9 = false;
    private static boolean Level10 = false;
    private static boolean Level11 = false;
    private static boolean Level12 = false;
    private static boolean Level13 = false;
    private static boolean Level14 = false;
    private static boolean Level15 = false;
    private static boolean Level16 = false;
    private static boolean Level17 = false;
    private static boolean Level18 = false;
    private static boolean LevelStart = true;
    private static boolean titleScreen = true;
    private static float power = 0;
    private static float powerX = 0;
    private static float powerY = 0;
    private static boolean shotLEFT = false;
    private static boolean shotUP = false;
    private static boolean shot = false;
    private static float dotx = 0;
    private static float doty = 0;
    private static float speedX = 0;
    private static float speedY = 0;
    private static float shotCount = 0;
    private static float shotDiminish = 0;
    private static boolean resetShot = false;
    private static float holePOSx = 300;
    private static float holePOSy = 200;
    private static float dX1 = 75;
    private static float dX2 = 115;
    private static float dY1 = 165;
    private static float dY2 = 235;
    private static float eX = 100;
    private static float eY = 320;
    private static float oldX = 0;
    private static float oldY = 0;
    private static float L1S = 0;
    private static float L2S = 0;
    private static float L3S = 0;
    private static float L4S = 0;
    private static float L5S = 0;
    private static float L6S = 0;
    private static float L7S = 0;
    private static float L8S = 0;
    private static float L9S = 0;
    private static float L10S = 0;
    private static float L11S = 0;
    private static float L12S = 0;
    private static float L13S = 0;
    private static float L14S = 0;
    private static float L15S = 0;
    private static float L16S = 0;
    private static float L17S = 0;
    private static float L18S = 0;
    private static float LevelSelect = 0;
    private static boolean ScoreDisplay = false;
    private static float dY = 0;
    private static float restart = 0;
    private static float linePOS = 0;
    private static boolean lineUP = false;
    private static float grav = 1;
    private static boolean slopeX = false;
    private static boolean slopeY = false;
    private static float textDiminish = 255;
    private static float textDiminishB = 0;
    private static boolean underGround = false;
    private static boolean water = false;
    private static boolean underWater = false;
    private static float waterTime = 0;
    private static boolean tips = true;
    private static float PrevSlopeX = 0;
    private static float PrevSlopeY = 0;
    private static float PrevSpeedX = 0;
    private static float PrevSpeedY = 0;
    private static String alertText = "";
    private static boolean AutoComplete = false;
    private static boolean AConoff = false;
    private static boolean slopeLEFT = false;
    private static boolean slopeRIGHT = false;
    private static boolean slopeUP = false;
    private static boolean slopeDOWN = false;
    private static boolean bunker = false;
    private static boolean UsedCommands = false;
    private static float delayTimer = 0;
    private static float selection = 0;
    private static float Bonus = 0;
    private static boolean LevelMenu = false;
    private static float a = 0;
    private static float b = 0;
    private static float c = 0;
    private static float roll = 5;
    private static float tS = 7;
    private static String onoffString = "ON";
    private static float tipSelect = 0;
    private static float tY = 0;
    private static boolean tipDisplay = false;
    private static boolean endGame = false;

    static void draw(Canvas c) {
        canvas = c;
        pf.setStyle(Paint.Style.FILL);
        ps.setStyle(Paint.Style.STROKE);

        canvas.save();
        canvas.translate((Screen.width - Screen.height) / 2, 0);
        canvas.scale(Screen.height / 400f, Screen.height / 400f, 0, 0);
        pjsCode();
        canvas.restore();
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
        canvas.drawRect(0f, 0f, 400f, 400f, pf);
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
        p.moveTo(x1, y1);
        p.lineTo(x2, y2);
        p.lineTo(x3, y3);
        p.close();
        canvas.drawPath(p, pf);
        canvas.drawPath(p, ps);
    }
    private static void pjsCode() {
        background(255);
        fill(0, 0, 255);
        noStroke();
        triangle(100, 100, 400, 400, 100, 200);
    }
}
