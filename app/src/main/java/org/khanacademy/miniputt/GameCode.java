package org.khanacademy.miniputt;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

class GameCode {
    // Text vars
    private final static int CENTER = 0;
    private final static int TOP = 1;
    private final static int BOTTOM = 2;
    private final static int LEFT = 3;
    private final static int RIGHT = 4;
    private final static int BASELINE = 5;
    private static float tl; // Text Leading: the vertical distance between adjacent lines of text
    private static float ta; // Text Ascent: the vertical distance between the "inner floor" and the "outer ceiling" of the text
    private static float td; // Text Descent: the vertical distance between the "inner floor" and the "outer floor" of the text
    private static int tah = LEFT; // Text Align Horizontal
    private static int tav = BOTTOM; // Text Align Vertical

    // Drawing vars
    private final static float width = 400; // Original Canvas Width
    private final static float height = 400; // Original Canvas Height
    private static Paint pf = new Paint(Paint.ANTI_ALIAS_FLAG); // Paint fill
    private static Paint ps = new Paint(Paint.ANTI_ALIAS_FLAG); // Paint stroke
    private static Canvas canvas;

    // Mouse vars
    private static float mouseX, mouseY;
    private static boolean mouseJustReleased, mouseIsPressed;
    
    // Misc vars
    private static Path mp; // Miscellaneous Path
    private static long frameCount = 0;
    static int mpf; // Millis per frame
    private static String angleMode = "degrees";

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
    private static int L1S = 0;
    private static int L2S = 0;
    private static int L3S = 0;
    private static int L4S = 0;
    private static int L5S = 0;
    private static int L6S = 0;
    private static int L7S = 0;
    private static int L8S = 0;
    private static int L9S = 0;
    private static int L10S = 0;
    private static int L11S = 0;
    private static int L12S = 0;
    private static int L13S = 0;
    private static int L14S = 0;
    private static int L15S = 0;
    private static int L16S = 0;
    private static int L17S = 0;
    private static int L18S = 0;
    private static int LevelSelect = 0;
    private static boolean ScoreDisplay = false;
    private static float dY = 0;
    private static int restart = 0;
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
    private static boolean PrevSlopeX = false;
    private static boolean PrevSlopeY = false;
    private static float PrevSpeedX = 0;
    private static String alertText = "";
    private static boolean slopeLEFT = false;
    private static boolean slopeRIGHT = false;
    private static boolean slopeUP = false;
    private static boolean slopeDOWN = false;
    private static boolean bunker = false;
    private static boolean UsedCommands = false;
    private static float delayTimer = 0;
    private static int selection = 0;
    private static float Bonus = 0;
    private static boolean LevelMenu = false;
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static float tS = 7;
    private static String onOffString = "ON";
    private static int tipSelect = 0;
    private static float tY = 0;
    private static boolean tipDisplay = false;
    private static boolean endGame = false;

    static void init() {
        ps.setStrokeCap(Paint.Cap.ROUND);
        pf.setStyle(Paint.Style.FILL);
        ps.setStyle(Paint.Style.STROKE);

        frameRate(60);
    }
    static void draw(Canvas c) {
        frameCount ++;
        canvas = c;

        canvas.save();
        if (Screen.width > Screen.height) {
            canvas.translate((Screen.width - Screen.height) / 2, 0);
            canvas.scale(Screen.height / height, Screen.height / height, 0, 0);
            pjsCode();
        } else {
            canvas.translate(0, (Screen.height - Screen.width) / 2);
            canvas.scale(Screen.width / width, Screen.width / width, 0, 0);
        }
        canvas.restore();

        mouseJustReleased = false;
    }
    static void setMouseX(float mouseX) {
        GameCode.mouseX = (mouseX - (Screen.width - Screen.height) / 2f) * height / Screen.height;
    }
    static void setMouseY(float mouseY) {
        GameCode.mouseY = mouseY * height / Screen.height;
    }
    static void setMouseJustReleased(boolean mouseJustReleased) {
        GameCode.mouseJustReleased = mouseJustReleased;
    }
    static void setMouseIsPressed(boolean mouseIsPressed) {
        GameCode.mouseIsPressed = mouseIsPressed;
    }
    private static void restartProgram() {
        ballPOSx = 200;
        ballPOSy = 200;
        drop = false;
        Level1 = false;
        Level2 = false;
        Level3 = false;
        Level4 = false;
        Level5 = false;
        Level6 = false;
        Level7 = false;
        Level8 = false;
        Level9 = false;
        Level10 = false;
        Level11 = false;
        Level12 = false;
        Level13 = false;
        Level14 = false;
        Level15 = false;
        Level16 = false;
        Level17 = false;
        Level18 = false;
        LevelStart = true;
        titleScreen = true;
        power = 0;
        powerX = 0;
        powerY = 0;
        shotLEFT = false;
        shotUP = false;
        shot = false;
        dotx = 0;
        doty = 0;
        speedX = 0;
        speedY = 0;
        shotDiminish = 0;
        resetShot = false;
        holePOSx = 300;
        holePOSy = 200;
        dX1 = 75;
        dX2 = 115;
        dY1 = 165;
        dY2 = 235;
        eX = 100;
        eY = 320;
        oldX = 0;
        oldY = 0;
        L1S = 0;
        L2S = 0;
        L3S = 0;
        L4S = 0;
        L5S = 0;
        L6S = 0;
        L7S = 0;
        L8S = 0;
        L9S = 0;
        L10S = 0;
        L11S = 0;
        L12S = 0;
        L13S = 0;
        L14S = 0;
        L15S = 0;
        L16S = 0;
        L17S = 0;
        L18S = 0;
        LevelSelect = 0;
        ScoreDisplay = false;
        dY = 0;
        restart = 0;
        linePOS = 0;
        lineUP = false;
        grav = 1;
        slopeX = false;
        slopeY = false;
        textDiminish = 255;
        textDiminishB = 0;
        underGround = false;
        water = false;
        underWater = false;
        waterTime = 0;
        tips = true;
        PrevSlopeX = false;
        PrevSlopeY = false;
        PrevSpeedX = 0;
        alertText = "";
        slopeLEFT = false;
        slopeRIGHT = false;
        slopeUP = false;
        slopeDOWN = false;
        bunker = false;
        UsedCommands = false;
        delayTimer = 0;
        selection = 0;
        Bonus = 0;
        LevelMenu = false;
        a = 0;
        b = 0;
        c = 0;
        tS = 7;
        onOffString = "ON";
        tipSelect = 0;
        tY = 0;
        tipDisplay = false;
        endGame = false;
    }
    private static void background(int r, int g, int b) {
        Paint paint = new Paint();
        paint.set(pf);
        pf.setColor(Color.rgb(r, g, b));
        canvas.drawRect(0f, 0f, 400f, 400f, pf);
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
    private static void fill(int r, int g, int b, float a) {
        pf.setColor(Color.argb((int) a, r, g, b));
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
    private static void stroke(int r, int g, int b, float a) {
        ps.setColor(Color.argb((int) (a > 0 ? (a < 255 ? a : 255) : 0), r, g, b));
    }
    private static void stroke(int r, int g, int b) {
        ps.setColor(Color.rgb(r, g, b));
    }
    private static void stroke(int shade) {
        ps.setColor(Color.rgb(shade, shade, shade));
    }
    private static void strokeWeight(float w) {
        ps.setStrokeWidth(w);
    }
    private static void line(float x1, float y1, float x2, float y2) {
        canvas.drawLine(x1, y1, x2, y2, ps);
    }
    private static void rect(float x, float y, float w, float h) {
        canvas.drawRect(x, y, x + w, y + h, pf);
        canvas.drawRect(x, y, x + w, y + h, ps);
    }
    private static void ellipse(float x, float y, float w, float h) {
        RectF r = new RectF(x - (w / 2f), y - (h / 2f), x + (w / 2f), y + (h / 2f));
        canvas.drawOval(r, pf);
        canvas.drawOval(r, ps);
    }
    private static void textLeading(float dist) {
        tl = dist;
    }
    private static void text(String txt, float x, float y) {
        drawMultilineText(txt, x, y);
    }
    private static void text(int txt, float x, float y) {
        drawMultilineText(String.valueOf(txt), x, y);
    }
    private static void drawMultilineText(String str, float x, float y) {
        String[] lines = str.split("\n");

        pushMatrix();
        if (tav == BOTTOM) {
            translate(0, y - tl * (lines.length - 1) - td);
        } else if (tav == BASELINE) {
            translate(0, y);
        } else if (tav == CENTER) {
            translate(0, y - tl * (lines.length - 1) / 2 + ta / 2);
        } else { // Text Align Vertical = TOP
            translate(0, y + ta);
        }

        if (tah == LEFT) {
            for (int i = 0; i < lines.length; i++) {
                canvas.drawText(lines[i], x, i * tl, pf);
            }
        } else if (tah == CENTER) {
            for (int i = 0; i < lines.length; i++) {
                canvas.drawText(lines[i], x - textWidth(lines[i]) / 2, i * tl, pf);
            }
        } else { // Text Align Horizontal = RIGHT
            for (int i = 0; i < lines.length; i++) {
                canvas.drawText(lines[i], x - textWidth(lines[i]), i * tl, pf);
            }
        }
        popMatrix();
    }
    private static void textAlign(int h, int v) { // Use ints CENTER, LEFT, RIGHT, TOP or BOTTOM.
        tah = h;
        tav = v;
    }
    private static void textSize(float size) {
        if (size < 0) {
            return;
        }
        pf.setTextSize(size);
        ta = pf.getTextSize() * 0.716f;
        td = pf.getTextSize() * 0.211f;
        tl = pf.getTextSize() * 1.149f;
    }
    private static float textWidth(String txt) {
        float w = 0;
        String[] lines = txt.split("\n");
        for (String line : lines) {
            w = pf.measureText(line) > w ? pf.measureText(line) : w;
        }
        return w;
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
    private static void quad(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
        Path p = new Path();
        p.moveTo(x1, y1);
        p.lineTo(x2, y2);
        p.lineTo(x3, y3);
        p.lineTo(x4, y4);
        p.close();
        canvas.drawPath(p, pf);
        canvas.drawPath(p, ps);
    }
    private static void arc(float x, float y, float w, float h, float start, float stop) {
        RectF r = new RectF(x - w / 2, y - h / 2, x + w / 2, y + h / 2);
        canvas.drawArc(r, start, stop - start, false, ps);
        r = new RectF(x - w / 2 + ps.getStrokeWidth() / 2, y - h / 2 + ps.getStrokeWidth() / 2, x + w / 2 - ps.getStrokeWidth() / 2, y + h / 2 - ps.getStrokeWidth() / 2);
        canvas.drawArc(r, start, stop - start, true, pf);
    }
    private static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    private static double sin(double degrees) {
        return Math.sin(degrees * 2 * Math.PI / 360);
    }
    private static double cos(double degrees) {
        return Math.cos(degrees * 2 * Math.PI / 360);
    }
    private static double tan(double degrees) {
        return Math.tan(degrees * 2 * Math.PI / 360);
    }
    private static double asin(double degrees) {
        return Math.asin(degrees * 2 * Math.PI / 360);
    }
    private static double acos(double degrees) {
        return Math.acos(degrees * 2 * Math.PI / 360);
    }
    private static double atan(double degrees) {
        return Math.atan(degrees * 2 * Math.PI / 360);
    }
    private static void beginShape() {
        mp = new Path();
    }
    private static void vertex(float x, float y) {
        if (mp.isEmpty()) {
            mp.moveTo(x, y);
        } else {
            mp.lineTo(x, y);
        }
    }
    private static void endShape() {
        mp.close();
        canvas.drawPath(mp, pf);
        canvas.drawPath(mp, ps);
    }
    private static double random(double high) {
        return high * Math.random();
    }
    private static double random(double low, double high) {
        return (high - low) * Math.random() + low;
    }
    private static int round(double num) {
        return (int) num;
    }
    private static void point(float x, float y) {
        canvas.drawPoint(x, y, ps);
    }
    private static void pushMatrix() {
        canvas.save();
    }
    private static void popMatrix() {
        canvas.restore();
    }
    private static void translate(float x, float y) {
        canvas.translate(x, y);
    }
    private static void rotate(float angle) {
        canvas.rotate((angleMode.equals("degrees")) ? angle : (float) (angle * 360 / (2 * Math.PI)), 0, 0);
    }
    private static void scale(float sx, float sy) {
        canvas.scale(sx, sy, 0, 0);
    }
    private static void scale(float s) {
        canvas.scale(s, s, 0, 0);
    }
    private static void frameRate(int fps) {
        mpf = 1000 / fps;
    }
    private static void pjsCode() {
        background(107, 72, 1);

        int[] LS = {L1S, L2S, L3S, L4S, L5S, L6S, L7S, L8S, L9S, L10S, L11S, L12S, L13S, L14S, L15S, L16S, L17S, L18S};
        int[] Par = {2, 3, 3, 3, 2, 2, 5, 2, 3, 3, 3, 3, 3, 3, 2, 4, 2, 2};
        int[] ParSum = {2, 5, 8, 11, 13, 15, 20, 22, 25, 28, 31, 34, 37, 40, 42, 46, 48, 50};
        int  LST = L1S + L2S + L3S + L4S + L5S + L6S + L7S + L8S + L9S + L10S + L11S + L12S + L13S + L14S + L15S + L16S + L17S + L18S;
        if (speedX <= 0.1 && speedY <= 0.1) {
            resetShot = true;
            speedX = 0;
            speedY = 0;
            if (shot && mouseJustReleased && !titleScreen && !endGame && !(mouseX > 170 && mouseX < 230 && mouseY <= 10) && !ScoreDisplay) {
                speedX = powerX/4;
                speedY = powerY/4;
                shotDiminish = power/5;
                if (Level1) {L1S += 1;}
                else if (Level2) {L2S += 1;}
                else if (Level3) {L3S += 1;}
                else if (Level4) {L4S += 1;}
                else if (Level5) {L5S += 1;}
                else if (Level6) {L6S += 1;}
                else if (Level7) {L7S += 1;}
                else if (Level8) {L8S += 1;}
                else if (Level9) {L9S += 1;}
                else if (Level10) {L10S += 1;}
                else if (Level11) {L11S += 1;}
                else if (Level12) {L12S += 1;}
                else if (Level13) {L13S += 1;}
                else if (Level14) {L14S += 1;}
                else if (Level15) {L15S += 1;}
                else if (Level16) {L16S += 1;}
                else if (Level17) {L17S += 1;}
                else if (Level18) {L18S += 1;}
            }
            shot = false;
        }
        else {
            resetShot = false;
            if (shotLEFT) {
                ballPOSx -= speedX;
            } else {
                ballPOSx += speedX;
            }
            if (shotUP) {
                ballPOSy -= speedY;
            } else {
                ballPOSy += speedY;
            }
            if (speedX > 0 && !slopeY){
                speedX -= speedX/shotDiminish;
            } else {
                if (!slopeY){
                    speedX = 0;
                } else {
                    speedX -= speedX/(shotDiminish * 1.5);
                }
            }
            if (speedY > 0 && !slopeX) {
                speedY -= speedY/shotDiminish;
            } else {
                if (!slopeX) {
                    speedY = 0;
                } else {
                    speedY -= speedY/(shotDiminish * 1.5);
                }
            }
        }
        power = (float) dist(mouseX, mouseY, ballPOSx, ballPOSy);
        powerX = (float) dist(mouseX, 0, ballPOSx, 0);
        powerY = (float) dist(0, mouseY, 0, ballPOSy);

        slopeX = false;
        slopeY = false;
        slopeLEFT = false;
        slopeRIGHT = false;
        slopeUP = false;
        slopeDOWN = false;
        water = false;
        bunker = false;

        //LEVEL 1
        if (Level1) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 100f, 300f, 200f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(75f, 165f, 40f, 70);
            strokeWeight(1);
            dX1 = 75;
            dX2 = 115;
            dY1 = 165;
            dY2 = 235;
            holePOSx = 300;
            holePOSy = 200;
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                textAlign(CENTER, BOTTOM);
                text("Tap and release to your ball in the dark green zone, then tap again to putt it.", 200f, 90f);
                text("The farther back you hold the putter, the harder the putt.", 200f, 320f);
                textAlign(LEFT, BOTTOM);
            }
            //Boundaries
            if (ballPOSy >= 295) {
                ballPOSy = 295;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 106) {
                ballPOSy = 106;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
        }

        //LEVEL 2
        else if (Level2) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(100f, 80f, 200f, 300f);
            fill(92, 62, 1);
            rect(175f, 80f, 10f, 225f);
            rect(215f, 80f, 10f, 225f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(110f, 90f, 55f, 40f);
            dX1 = 110;
            dX2 = 165;
            dY1 = 90;
            dY2 = 130;
            holePOSx = 263;
            holePOSy = 100;
            strokeWeight(1);
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                text("<--- Restart Hole", 40f, 30f);
                textAlign(CENTER, BOTTOM);
                text("Make your way around obstacles to get to the hole.", 200f, 70f);
                textAlign(LEFT, BOTTOM);
            }
            //Boundaries
            if (ballPOSy >= 375) {
                ballPOSy = 375;
                shotUP = true;
            }
            if (ballPOSx >= 295) {
                ballPOSx = 295;
                shotLEFT = true;
            }
            if (ballPOSy <= 86) {
                ballPOSy = 86;
                shotUP = false;
            }
            if (ballPOSx <= 106) {
                ballPOSx = 106;
                shotLEFT = false;
            }
            if (ballPOSy <= 305) {
                if (oldX < 170 && ballPOSx >= 170) {
                    shotLEFT = true;
                    oldX = 169;
                    ballPOSx = 169;
                }
                if (oldX > 190 && ballPOSx <= 190) {
                    shotLEFT = false;
                    oldX = 191;
                    ballPOSx = 191;
                }
                if (oldX < 210 && ballPOSx >= 210) {
                    shotLEFT = true;
                    oldX = 209;
                    ballPOSx = 209;
                }
                if (oldX > 231 && ballPOSx <= 231) {
                    shotLEFT = false;
                    oldX = 232;
                    ballPOSx = 232;
                }
            }
            if (ballPOSy <= 313 && oldY < 313) {
                if (ballPOSx >= 170 && ballPOSx <= 190) {
                    ballPOSy = 313;
                    shotUP = false;
                }
                if (ballPOSx >= 210 && ballPOSx <= 231) {
                    ballPOSy = 313;
                    shotUP = false;
                }
            }
        }

        //LEVEL 3
        else if (Level3) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(100f, 50f, 200f, 300f);
            fill(128, 86, 2);
            rect(100f, 50f, 70f, 50f);
            rect(230f, 50f, 70f, 50f);
            strokeWeight(6);
            stroke(110);
            line(160f, 290f, 240f, 290f);
            line(105f, 230f, 145f, 230f);
            line(255f, 230f, 295f, 230f);
            line(160f, 170f, 240f, 170f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(160f, 300f, 80f, 40f);
            strokeWeight(1);
            holePOSx = 200;
            holePOSy = 79;
            dX1 = 160;
            dX2 = 240;
            dY1 = 300;
            dY2 = 340;
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(10);
                fill(255, 255, 0, textDiminish);
                textAlign(CENTER, BOTTOM);
                text("The faster your ball is going the more accurate you have to be to get it in the hole.", 200f, 45f);
                text("If it is going too fast it can't go in the hole at all", 200f, 370f);
                textAlign(LEFT, BOTTOM);
            }
            //Boundaries
            if (ballPOSy >= 345) {
                ballPOSy = 345;
                shotUP = true;
            }
            if (ballPOSx >= 295) {
                ballPOSx = 295;
                shotLEFT = true;
            }
            if (ballPOSy <= 56) {
                ballPOSy = 56;
                shotUP = false;
            }
            if (ballPOSx <= 106) {
                ballPOSx = 106;
                shotLEFT = false;
            }
            if (ballPOSx >= 158 && ballPOSx <= 243) {
                if (oldY > 296 && ballPOSy <= 296) {
                    oldY = 297;
                    ballPOSy = 297;
                    shotUP = false;
                }
                if (oldY < 285 && ballPOSy >= 285) {
                    oldY = 284;
                    ballPOSy = 284;
                    shotUP = true;
                }
                if (oldY > 176 && ballPOSy <= 176) {
                    oldY = 177;
                    ballPOSy = 177;
                    shotUP = false;
                }
                if (oldY < 165 && ballPOSy >= 165) {
                    oldY = 164;
                    ballPOSy = 164;
                    shotUP = true;
                }
            }
            if (ballPOSx <= 148) {
                if (oldY > 236 && ballPOSy <= 236) {
                    oldY = 237;
                    ballPOSy = 237;
                    shotUP = false;
                }
                if (oldY < 225 && ballPOSy >= 225) {
                    oldY = 224;
                    ballPOSy = 224;
                    shotUP = true;
                }
            }
            if (ballPOSx >= 253) {
                if (oldY > 236 && ballPOSy <= 236) {
                    oldY = 237;
                    ballPOSy = 237;
                    shotUP = false;
                }
                if (oldY < 225 && ballPOSy >= 225) {
                    oldY = 224;
                    ballPOSy = 224;
                    shotUP = true;
                }
            }
            if (ballPOSy <= 106 && oldY > 106) {
                if (ballPOSx <= 176) {
                    ballPOSy = 107;
                    shotUP = false;
                }
                if (ballPOSx >= 228) {
                    ballPOSy = 107;
                    shotUP = false;
                }
            }
            if (ballPOSy <= 103) {
                if (ballPOSx <= 176 && oldX > 176) {
                    ballPOSx = 176;
                    shotLEFT = false;
                }
                if (ballPOSx >= 228 && oldX < 228) {
                    ballPOSx = 228;
                    shotLEFT = true;
                }
            }
        }

        //LEVEL 4
        else if (Level4) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(30f, 110f, 340f, 210f);
            fill(128, 86, 2);
            rect(30f, 250f, 70f, 70f);
            line(30f, 250f, 270f, 250f);
            line(110f, 180f, 370f, 180f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(105f, 255f, 40f, 61f);
            strokeWeight(1);
            dX1 = 105;
            dX2 = 145;
            dY1 = 255;
            dY2 = 316;
            holePOSx = 345;
            holePOSy = 145;
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                textAlign(CENTER, BOTTOM);
                text("Tap on the tab at the top to see your score card", 200f, 105f);
                text("^SCORE CARD^", 200f, 20f);
                textAlign(LEFT, BOTTOM);
            }
            //Boundaries
            if (ballPOSy >= 315) {
                ballPOSy = 315;
                shotUP = true;
            }
            if (ballPOSx >= 365) {
                ballPOSx = 365;
                shotLEFT = true;
            }
            if (ballPOSy <= 116) {
                ballPOSy = 116;
                shotUP = false;
            }
            if (ballPOSx <= 36) {
                ballPOSx = 36;
                shotLEFT = false;
            }
            if (ballPOSy >= 250 && ballPOSx <= 106 && oldY > 250) {
                ballPOSx = 106;
                shotLEFT = false;
            }
            if (ballPOSx <= 273) {
                if (oldY > 256 && ballPOSy <= 256) {
                    oldY = 257;
                    ballPOSy = 257;
                    shotUP = false;
                }
                if (oldY < 245 && ballPOSy >= 245) {
                    oldY = 244;
                    ballPOSy = 244;
                    shotUP = true;
                }
            }
            if (ballPOSx >= 107) {
                if (oldY > 186 && ballPOSy <= 186) {
                    oldY = 187;
                    ballPOSy = 187;
                    shotUP = false;
                }
                if (oldY < 175 && ballPOSy >= 175) {
                    oldY = 174;
                    ballPOSy = 174;
                    shotUP = true;
                }
            }
        }

        //LEVEL 5
        else if (Level5) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 120f, 300f, 160f);
            dX1 = 75;
            dX2 = 115;
            dY1 = 165;
            dY2 = 235;
            holePOSx = 300;
            holePOSy = 200;
            if (linePOS <= 4) {
                lineUP = false;
            }
            if (linePOS >= 75) {
                lineUP = true;
            }
            if (lineUP) {
                linePOS -= 1;
            } else {
                linePOS += 1;
            }
            strokeWeight(6);
            stroke(100);
            line(150f, linePOS + 120f, 150f, linePOS + 200f);
            line(200f, 280f - linePOS, 200f, 200f - linePOS);
            line(250f, linePOS + 120f, 250f, linePOS + 200f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(75f, 165f, 40f, 70f);
            strokeWeight(1);
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                textAlign(CENTER, BOTTOM);
                text("Some obstacles may move, aim accordingly.", 200f, 105f);
                textAlign(LEFT, BOTTOM);
            }
            //Boundaries
            if (ballPOSy >= 275) {
                ballPOSy = 275;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 126) {
                ballPOSy = 126;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (ballPOSy >= linePOS + 117 && ballPOSy <= linePOS + 203) {
                if (oldX < 144 && ballPOSx >= 144) {
                    oldX = 143;
                    ballPOSx = 143;
                    shotLEFT = true;
                }
                if (oldX > 156 && ballPOSx <= 156) {
                    oldX = 157;
                    ballPOSx = 157;
                    shotLEFT = false;
                }
                if (oldX < 244 && ballPOSx >= 244) {
                    oldX = 243;
                    ballPOSx = 243;
                    shotLEFT = true;
                }
                if (oldX > 256 && ballPOSx <= 256) {
                    oldX = 257;
                    ballPOSx = 257;
                    shotLEFT = false;
                }
            }
            if (ballPOSy >= 207 - linePOS && ballPOSy <= 283 - linePOS) {
                if (oldX < 194 && ballPOSx >= 194) {
                    oldX = 193;
                    ballPOSx = 193;
                    shotLEFT = true;
                }
                if (oldX > 206 && ballPOSx <= 206) {
                    oldX = 207;
                    ballPOSx = 207;
                    shotLEFT = false;
                }
            }
        }

        //LEVEL 6
        else if (Level6) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 100f, 300f, 200f);
            stroke(153, 103, 3);
            line(200f, 105f, 200f, 190f);
            line(200f, 295f, 200f, 210f);
            line(175f, 190f, 225f, 190f);
            line(175f, 210f, 225f, 210f);
            stroke(100);
            line(170f, 131f + linePOS, 170f, 189f + linePOS);
            line(230f, 209f - linePOS, 230f, 271f - linePOS);
            line(310f, 191f, 310f, 208f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(75f, 165f, 40f, 70f);
            strokeWeight(1);
            if (linePOS <= 0) {
                lineUP = false;
            }
            if (linePOS >= 80) {
                lineUP = true;
            }
            if (lineUP) {
                linePOS -= 1.5;
            } else {
                linePOS += 1.5;
            }
            //Boundaries
            if (ballPOSy >= 295) {
                ballPOSy = 295;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 106) {
                ballPOSy = 106;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (ballPOSy >= 209 - linePOS && ballPOSy <= 271 - linePOS) {
                if (oldX < 225 && ballPOSx >= 225) {
                    oldX = 224;
                    ballPOSx = 224;
                    shotLEFT = true;
                }
                if (oldX > 236 && ballPOSx <= 236) {
                    oldX = 237;
                    ballPOSx = 237;
                    shotLEFT = false;
                }
            }
            if (ballPOSy >= 129 + linePOS && ballPOSy <= 192 + linePOS) {
                if (oldX < 165 && ballPOSx >= 165) {
                    oldX = 164;
                    ballPOSx = 164;
                    shotLEFT = true;
                }
                if (oldX > 176 && ballPOSx <= 176) {
                    oldX = 177;
                    ballPOSx = 177;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 170 && ballPOSx <= 230) {
                if (oldY > 216 && ballPOSy <= 216) {
                    oldY = 217;
                    ballPOSy = 217;
                    shotUP = false;
                }
                if (oldY < 205 && ballPOSy >= 205) {
                    oldY = 204;
                    ballPOSy = 204;
                    shotUP = true;
                }
                if (oldY > 196 && ballPOSy <= 196) {
                    oldY = 197;
                    ballPOSy = 197;
                    shotUP = false;
                }
                if (oldY < 185 && ballPOSy >= 185) {
                    oldY = 184;
                    ballPOSy = 184;
                    shotUP = true;
                }
            }
            if (oldX < 195 && ballPOSx >= 195) {
                if (ballPOSy < 190) {
                    oldX = 194;
                    ballPOSx = 194;
                    shotLEFT = true;
                }
                if (ballPOSy > 210) {
                    oldX = 194;
                    ballPOSx = 194;
                    shotLEFT = true;
                }
            }
            if (oldX > 206 && ballPOSx <= 206) {
                if (ballPOSy < 190) {
                    oldX = 207;
                    ballPOSx = 207;
                    shotLEFT = false;
                }
                if (ballPOSy > 210) {
                    oldX = 207;
                    ballPOSx = 207;
                    shotLEFT = false;
                }
            }
            if (ballPOSy >= 189 && ballPOSy <= 211) {
                if (oldX < 305 && ballPOSx >= 305) {
                    oldX = 304;
                    ballPOSx = 304;
                    shotLEFT = true;
                }
                if (oldX > 316 && ballPOSx <= 316) {
                    oldX = 317;
                    ballPOSx = 317;
                    shotLEFT = false;
                }
            }
        }

        //LEVEL 7
        else if (Level7) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(30f, 110f, 340f, 210f);
            fill(128, 86, 2);
            line(30f, 180f, 280f, 180f);
            line(220f, 250f, 350f, 250f);
            line(220f, 250f, 220f, 230f);
            line(220f, 180f, 220f, 200f);
            line(110f, 225f, 220f, 225f);
            line(90f, 205f, 220f, 205f);
            line(110f, 225f, 110f, 300f);
            line(90f, 205f, 90f, 300f);
            line(50f, 300f, 90f, 300f);
            line(50f, 235f, 50f, 300f);
            line(50f, 235f, 60f, 235f);
            line(60f, 235f, 60f, 205f);
            line(30f, 205f, 60f, 205f);
            line(110f, 300f, 350f, 300f);
            line(350f, 300f, 350f, 250f);
            noStroke();
            rect(113f, 253f, 235f, 45f);
            rect(113f, 228f, 105f, 25f);
            rect(63f, 183f, 25f, 115f);
            rect(33f, 183f, 185f, 20f);
            rect(53f, 238f, 25f, 60f);
            fill(0, 0, 0, 100);
            rect(35f, 115f, 80f, 61f);
            dX1 = 35;
            dX2 = 115;
            dY1 = 115;
            dY2 = 176;
            holePOSx = 45;
            holePOSy = 220;
            strokeWeight(1);
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                textAlign(CENTER, BOTTOM);
                text("There are some bugs in this hole, use them to your advantage!", 200f, 340f);
                textAlign(LEFT, BOTTOM);
            }
            //Boundaries
            if (ballPOSy >= 315) {
                ballPOSy = 315;
                shotUP = true;
            }
            if (ballPOSx >= 365) {
                ballPOSx = 365;
                shotLEFT = true;
            }
            if (ballPOSy <= 116) {
                ballPOSy = 116;
                shotUP = false;
            }
            if (ballPOSx <= 36) {
                ballPOSx = 36;
                shotLEFT = false;
            }
            if (ballPOSx <= 282) {
                if (oldY < 175 && ballPOSy >= 175) {
                    oldY = 174;
                    ballPOSy = 174;
                    shotUP = true;
                }
                if (oldY > 186 && ballPOSy <= 186) {
                    oldY = 187;
                    ballPOSy = 187;
                    shotUP = false;
                }
            }
            if (ballPOSx <= 226) {
                if (oldX > 226) {
                    if (ballPOSy >= 180 && ballPOSy < 205) {
                        oldX = 226;
                        ballPOSx = 226;
                        shotLEFT = false;
                    }
                    if (ballPOSy >= 225 && ballPOSy <= 250) {
                        oldX = 226;
                        ballPOSx = 226;
                        shotLEFT = false;
                    }
                }
                if (oldY > 211 && ballPOSy <= 211) {
                    oldY = 212;
                    ballPOSy = 212;
                    shotUP = false;
                }
            }
            if (ballPOSx >= 105) {
                if (ballPOSy >= 223 && ballPOSy <= 303) {
                    if (oldX < 105) {
                        oldX = 104;
                        ballPOSx = 104;
                        shotLEFT = true;
                    }
                    if (ballPOSy >= 250 && oldX > 356 && ballPOSx <= 356) {
                        oldX = 356;
                        ballPOSx = 356;
                        shotLEFT = false;
                    }
                }
            }
            if (ballPOSx >= 105 && ballPOSx <= 356 && oldY > 306 && ballPOSy <= 306) {
                oldY = 307;
                ballPOSy = 307;
                shotUP = false;
            }
            if (ballPOSx >= 110 && ballPOSx <= 226 && oldY < 220 && ballPOSy >= 220) {
                oldY = 219;
                ballPOSy = 219;
                shotUP = true;
            }
            if (ballPOSx >= 220 && ballPOSx <= 350 && oldY < 245 && ballPOSy >= 245) {
                oldY = 244;
                ballPOSy = 244;
                shotUP = true;
            }
            if (ballPOSy >= 200 && ballPOSy <= 306 && oldX > 96 && ballPOSx <= 96) {
                oldX = 97;
                ballPOSx = 97;
                shotLEFT = false;
            }
            if (ballPOSx >= 45 && ballPOSx <= 96 && oldY > 306 && ballPOSy <= 306) {
                oldX = 307;
                ballPOSy = 307;
                shotUP = false;
            }
            if (ballPOSy >= 230 && ballPOSy <= 306 && oldX < 45 && ballPOSx >= 45) {
                oldX = 44;
                ballPOSx = 44;
                shotLEFT = true;
            }
            if (ballPOSy > 200 && ballPOSy <= 235 && oldX < 55 && ballPOSx >= 55) {
                oldX = 54;
                ballPOSx = 54;
                shotLEFT = true;
            }
            if (ballPOSx >= 45 && ballPOSx <= 65 && oldY < 230 && ballPOSy >= 230) {
                oldY = 229;
                ballPOSy = 229;
                shotUP = true;
            }
        }

        //LEVEL 8
        else if (Level8) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 100f, 300f, 200f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(75f, 165f, 40f, 70f);
            strokeWeight(1);
            fill(3, 148, 8);
            rect(150f, 103f, 80f, 195f);
            fill(13, 184, 4);
            rect(270f, 103f, 63f, 195f);
            for (int aRep = 0; aRep < 10; aRep += 1) {
                stroke(0, 125, 0);
                line(155f, 110f + aRep * 20f, 225f, 105f + aRep * 20f);
                line(155f, 110f + aRep * 20f, 225f, 115f + aRep * 20f);
                stroke(90, 190, 90);
                line(328f, 110f + aRep * 20f, 275f, 105f + aRep * 20f);
                line(328f, 110f + aRep * 20f, 275f, 115f + aRep * 20f);
            }
            noStroke();
            dX1 = 75;
            dX2 = 115;
            dY1 = 165;
            dY2 = 235;
            holePOSx = 250;
            holePOSy = 120;
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                stroke(255, 255, 0, textDiminish);
                strokeWeight(3);
                line(50f, 350f, 150f, 350f);
                line(150f, 350f, 230f, 325f);
                line(230f, 325f, 270f, 325f);
                line(270f, 325f, 333f, 350f);
                line(333f, 350f, 350f, 350f);
                text("<SIDE VIEW", 300f, 370f);
                textAlign(CENTER, BOTTOM);
                text("This hole introduces slopes. The arrows point to the bottom\nwhile the large end is at the top.", 200f, 80f);
                textAlign(LEFT, BOTTOM);
            }
            //Boundaries
            if (ballPOSy >= 295) {
                ballPOSy = 295;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 106) {
                ballPOSy = 106;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (ballPOSx > 150 && ballPOSx < 230) {
                slopeLEFT = true;
            }
            if (ballPOSx > 270 && ballPOSx < 335) {
                slopeRIGHT = true;
            }
        }

        //LEVEL 9
        else if (Level9) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(35f, 100f, 330f, 250f);
            line(35f, 290f, 291f, 290f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(41f, 145f, 40f, 100f);
            dX1 = 41;
            dX2 = 81;
            dY1 = 145;
            dY2 = 245;
            holePOSx = 65;
            holePOSy = 320;
            strokeWeight(1);
            fill(3, 148, 8);
            rect(85f, 168f, 70f, 120f);
            rect(155f, 228f, 70f, 60f);
            rect(225f, 168f, 70f, 120f);
            fill(13, 184, 4);
            rect(85f, 103f, 70f, 60f);
            rect(155f, 103f, 70f, 120f);
            rect(225f, 103f, 70f, 60f);
            rect(295f, 103f, 68f, 190f);
            for (int aRep = 0; aRep < 3; aRep += 1) {
                stroke(90, 190, 90);
                line(95f + aRep * 20f, 110f, 100f + aRep * 20f, 157f);
                line(105f + aRep * 20f, 110f, 100f + aRep * 20f, 157f);
                line(165f + aRep * 20f, 110f, 170f + aRep * 20f, 217f);
                line(175f + aRep * 20f, 110f, 170f + aRep * 20f, 217f);
                line(235f + aRep * 20f, 110f, 240f + aRep * 20f, 157f);
                line(245f + aRep * 20f, 110f, 240f + aRep * 20f, 157f);
                line(305f + aRep * 20f, 110f, 310f + aRep * 20f, 288f);
                line(315f + aRep * 20f, 110f, 310f + aRep * 20f, 288f);
                stroke(0, 125, 0);
                line(95f + aRep * 20f, 282f, 100f + aRep * 20f, 175f);
                line(105f + aRep * 20f, 282f, 100f + aRep * 20f, 175f);
                line(165f + aRep * 20f, 282f, 170f + aRep * 20f, 235f);
                line(175f + aRep * 20f, 282f, 170f + aRep * 20f, 235f);
                line(235f + aRep * 20f, 282f, 240f + aRep * 20f, 175f);
                line(245f + aRep * 20f, 282f, 240f + aRep * 20f, 175f);
            }
            //Boundaries
            if (ballPOSy >= 345) {
                ballPOSy = 345;
                shotUP = true;
            }
            if (ballPOSx >= 360) {
                ballPOSx = 360;
                shotLEFT = true;
            }
            if (ballPOSy <= 106) {
                ballPOSy = 106;
                shotUP = false;
            }
            if (ballPOSx <= 41) {
                ballPOSx = 41;
                shotLEFT = false;
            }
            if (ballPOSx <= 294) {
                if (oldY < 285 && ballPOSy >= 285) {
                    oldY = 284;
                    ballPOSy = 284;
                    shotUP = true;
                }
                if (oldY > 296 && ballPOSy <= 296) {
                    oldY = 297;
                    ballPOSy = 297;
                    shotUP = false;
                }
            }
            if (ballPOSx >= 85 && ballPOSx <= 365 && ballPOSy < 163) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 155 && ballPOSx <= 225 && ballPOSy < 223) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 295 && ballPOSy < 293) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 85 && ballPOSx <= 295 && ballPOSy > 228 && ballPOSy <= 288) {
                slopeUP = true;
            }
            if (ballPOSx >= 85 && ballPOSx <= 155 && ballPOSy > 168 && ballPOSy <= 288) {
                slopeUP = true;
            }
            if (ballPOSx >= 225 && ballPOSx <= 295 && ballPOSy > 168 && ballPOSy <= 288) {
                slopeUP = true;
            }
        }

        //LEVEL 10
        else if (Level10) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 80f, 300f, 260f);
            line(50f, 160f, 160f, 160f);
            line(240f, 160f, 350f, 160f);
            fill(128, 86, 2);
            rect(140f, 240f, 20f, 20f);
            rect(240f, 240f, 20f, 100f);
            rect(115f, 265f, 20f, 20f);
            stroke(0, 158, 0);
            stroke(100);
            line(165f, 160f, 165f, 258f);
            line(235f, 160f, 235f, 258f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(55f, 85f, 70f, 71f);
            rect(276f, 85f, 70f, 71f);
            strokeWeight(1);
            fill(3, 148, 8);
            rect(168f, 157f, 65f, 30f);
            fill(13, 184, 4);
            rect(168f, 231f, 65f, 30f);
            rect(120f, 163f, 43f, 75f);
            rect(263f, 238f, 85f, 82f);
            if (mouseX <= 125) {
                dX1 = 55;
                dX2 = 125;
            }
            if (mouseX >= 276) {
                dX1 = 276;
                dX2 = 346;
            }
            dY1 = 85;
            dY2 = 156;
            holePOSx = 305;
            holePOSy = 200;
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                textAlign(CENTER, BOTTOM);
                text("There are 2 drop zones in this hole, use which ever you like.", 200f, 75f);
                text("There's also a bridge. Go under it to get to the hole", 200f, 360f);
                textAlign(LEFT, BOTTOM);
            }
            for (int  bRep = 0; bRep < 3; bRep += 1) {
                stroke(0, 125, 0);
                line(175f + bRep * 20f, 183f, 180f + bRep * 20f, 160f);
                line(185f + bRep * 20f, 183f, 180f + bRep * 20f, 160f);
                stroke(90, 190, 90);
                line(175f + bRep * 20f, 235f, 180f + bRep * 20f, 258f);
                line(185f + bRep * 20f, 235f, 180f + bRep * 20f, 258f);
            }
            for (int  cRep = 0; cRep < 4; cRep += 1) {
                stroke(90, 190, 90);
                line(269f + cRep * 20f, 245f, 274f + cRep * 20f, 313f);
                line(279f + cRep * 20f, 245f, 274f + cRep * 20f, 313f);
                line(125f, 168f + cRep * 18f, 156f, 172f + cRep * 18f);
                line(125f, 176f + cRep * 18f, 156f, 172f + cRep * 18f);
            }
            for (int  aRep = 0; aRep < 10; aRep += 1) {
                stroke(0, 0, 0, 15 * aRep);
                line(153f + aRep, 163f, 153f + aRep, 237f);
                line(247f - aRep, 163f, 247f - aRep, 237f);
            }
            //Boundaries
            if (ballPOSy >= 335) {
                ballPOSy = 335;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 86) {
                ballPOSy = 86;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (underGround && ballPOSy <= 160) {
                ballPOSy = 160;
                shotUP = false;
            }
            if (underGround && ballPOSy >= 240) {
                ballPOSy = 240;
                shotUP = true;
            }
            if (ballPOSx <= 163) {
                if (oldY < 155 && ballPOSy >= 155) {
                    oldY = 154;
                    ballPOSy = 154;
                    shotUP = true;
                }
                if (oldY > 166 && ballPOSy <= 166) {
                    oldY = 167;
                    ballPOSy = 167;
                    shotUP = false;
                }
            }
            if (ballPOSx >= 232) {
                if (oldY < 155 && ballPOSy >= 155) {
                    oldY = 154;
                    ballPOSy = 154;
                    shotUP = true;
                }
                if (oldY > 166 && ballPOSy <= 166) {
                    oldY = 167;
                    ballPOSy = 167;
                    shotUP = false;
                }
            }
            if (ballPOSy >= 158 && ballPOSy <= 261 && !underGround) {
                if (oldX < 160 && ballPOSx >= 160) {
                    underGround = true;
                }
                if (oldX > 171 && ballPOSx <= 171) {
                    oldX = 172;
                    ballPOSx = 172;
                    shotLEFT = false;
                }
                if (oldX < 230 && ballPOSx >= 230) {
                    oldX = 229;
                    ballPOSx = 229;
                    shotLEFT = true;
                }
                if (oldX > 241 && ballPOSx <= 241) {
                    underGround = true;
                }
            }
            if (ballPOSy >= 238 && ballPOSy <= 263 && oldX < 135 && ballPOSx >= 135) {
                oldX = 134;
                ballPOSx = 134;
                shotLEFT = true;
            }
            if (ballPOSx >= 138 && ballPOSx <= 163 && oldY < 235 && ballPOSy >= 235) {
                oldY = 234;
                ballPOSy = 234;
                shotUP = true;
            }
            if (ballPOSx >= 138 && ballPOSx <= 168 && oldY > 266 && ballPOSy <= 266) {
                oldY = 267;
                ballPOSy = 267;
                shotUP = false;
            }
            if (ballPOSy >= 238) {
                if (oldX < 235 && ballPOSx >= 235) {
                    oldX = 234;
                    ballPOSx = 234;
                    shotLEFT = true;
                }
                if (oldX > 266 && ballPOSx <= 266) {
                    oldX = 267;
                    ballPOSx = 267;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 238 && ballPOSx <= 263 && oldY < 235 && ballPOSy >= 235) {
                oldY = 234;
                ballPOSy = 234;
                shotUP = true;
            }
            if (ballPOSy >= 263 && ballPOSy <= 288) {
                if (oldX < 110 && ballPOSx >= 110) {
                    oldX = 109;
                    ballPOSx = 109;
                    shotLEFT = true;
                }
                if (oldX > 141 && ballPOSx <= 141) {
                    oldX = 142;
                    ballPOSx = 142;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 113 && ballPOSx <= 138) {
                if (oldY < 260 && ballPOSy >= 260) {
                    oldY = 259;
                    ballPOSy = 259;
                    shotUP = true;
                }
                if (oldY > 291 && ballPOSy <= 291) {
                    oldY = 292;
                    ballPOSy = 292;
                    shotUP = false;
                }
            }
            if (ballPOSx >= 168 && ballPOSx <= 233 && ballPOSy > 157 && ballPOSy <= 187) {
                slopeUP = true;
            }
            if (ballPOSx >= 168 && ballPOSx <= 233 && ballPOSy >= 231 && ballPOSy <= 261) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 263 && ballPOSx <= 328 && ballPOSy >= 238 && ballPOSy <= 320) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 120 && ballPOSx <= 163 && ballPOSy >= 163 && ballPOSy <= 238) {
                slopeRIGHT = true;
            }
            if (underGround) {
                slopeRIGHT = true;
            }
            if (ballPOSx < 160) {
                underGround = false;
            }
            if (ballPOSx > 240) {
                underGround = false;
            }
        }

        //LEVEL 11
        else if (Level11) {
            fill(30, 168, 2);
            strokeWeight(5f);
            stroke(173, 116, 2);
            rect(50f, 90f, 300f, 220f);
            fill(128, 86, 2);
            rect(50f, 90f, 55f, 75f);
            rect(50f, 235f, 55f, 75f);
            rect(295f, 90f, 55f, 75f);
            rect(295f, 235f, 55f, 75f);
            rect(165f, 143f, 70f, 115f);
            noStroke();
            fill(107, 72, 1);
            rect(47f, 87f, 55f, 75f);
            rect(47f, 238f, 55f, 75f);
            rect(298f, 87f, 55f, 75f);
            rect(298f, 238f, 55f, 75f);
            fill(0, 0, 0, 100);
            rect(55f, 170f, 40f, 61f);
            dX1 = 55;
            dX2 = 95;
            dY1 = 170;
            dY2 = 231;
            holePOSx = 322;
            holePOSy = 200;
            if (linePOS <= 0) {
                lineUP = false;
            }
            if (linePOS >= 30) {
                lineUP = true;
            }
            if (lineUP) {
                linePOS -= 1.5;
            } else {
                linePOS += 1.5;
            }
            fill(13, 184, 4);
            rect(108f, 233f, 55f, 28f);
            rect(238f, 141f, 55f, 28f);
            rect(238f, 170f, 55f, 64f);
            fill(3, 148, 8);
            rect(108f, 141f, 55f, 28f);
            rect(238f, 233f, 55f, 28f);
            strokeWeight(1f);
            for (int  bRep = 0; bRep < 3; bRep += 1) {
                stroke(0, 125, 0);
                line(110f + bRep * 20f, 168f, 115f + bRep * 20f, 143f);
                line(120f + bRep * 20f, 168f, 115f + bRep * 20f, 143f);
                line(240f + bRep * 20f, 259f, 245f + bRep * 20f, 235f);
                line(250f + bRep * 20f, 259f, 245f + bRep * 20f, 235f);
                stroke(90, 190, 90);
                line(110f + bRep * 20f, 235f, 115f + bRep * 20f, 259f);
                line(120f + bRep * 20f, 235f, 115f + bRep * 20f, 259f);
                line(240f + bRep * 20f, 143f, 245f + bRep * 20f, 168f);
                line(250f + bRep * 20f, 143f, 245f + bRep * 20f, 168f);
                line(240f, 175f + bRep * 20f, 288f, 180f + bRep * 20f);
                line(240f, 185f + bRep * 20f, 288f, 180f + bRep * 20f);
            }
            strokeWeight(5f);
            stroke(100);
            line(104f, 170f + (4f * linePOS) / 3f, 104f, 190f + (4f * linePOS) / 3f);
            line(110f + linePOS, 165f, 130f + linePOS, 165f);
            line(160f - linePOS, 235f, 140f - linePOS, 235f);
            //Boundaries
            if (ballPOSy >= 305) {
                ballPOSy = 305;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 96) {
                ballPOSy = 96;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (oldX > 111 && ballPOSx <= 111) {
                if (ballPOSy <= 165) {
                    oldX = 112;
                    ballPOSx = 112;
                    shotLEFT = false;
                }
                if (ballPOSy >= 235) {
                    oldX = 112;
                    ballPOSx = 112;
                    shotLEFT = false;
                }
            }
            if (oldX < 290 && ballPOSx >= 290) {
                if (ballPOSy <= 165) {
                    oldX = 291;
                    ballPOSx = 291;
                    shotLEFT = true;
                }
                if (ballPOSy >= 235) {
                    oldX = 291;
                    ballPOSx = 291;
                    shotLEFT = true;
                }
            }
            if (oldY > 171 && ballPOSy <= 171) {
                if (ballPOSx <= 105) {
                    oldY = 172;
                    ballPOSy = 172;
                    shotUP = false;
                }
                if (ballPOSx >= 295) {
                    oldY = 172;
                    ballPOSy = 172;
                    shotUP = false;
                }
            }
            if (oldY < 230 && ballPOSy >= 230) {
                if (ballPOSx <= 105) {
                    oldY = 231;
                    ballPOSy = 231;
                    shotUP = true;
                }
                if (ballPOSx >= 295) {
                    oldY = 231;
                    ballPOSy = 231;
                    shotUP = true;
                }
            }
            if (ballPOSx >= 165 && ballPOSx <= 235) {
                if (oldY < 138 && ballPOSy >= 138) {
                    oldY = 137;
                    ballPOSy = 137;
                    shotUP = true;
                }
                if (oldY > 264 && ballPOSy <= 264) {
                    oldY = 265;
                    ballPOSy = 265;
                    shotUP = false;
                }
            }
            if (ballPOSy >= 143 && ballPOSy <= 258) {
                if (oldX < 160 && ballPOSx >= 160) {
                    oldX = 159;
                    ballPOSx = 159;
                    shotLEFT = true;
                }
                if (oldX > 241 && ballPOSx <= 241) {
                    oldX = 242;
                    ballPOSx = 242;
                    shotLEFT = false;
                }
            }
            if (ballPOSy >= 170 + (4 * linePOS)/3 && ballPOSy <= 190 + (4 * linePOS)/3) {
                if (oldX < 99 && ballPOSx >= 99) {
                    oldX = 98;
                    ballPOSx = 98;
                    shotLEFT = true;
                }
                if (oldX > 110 && ballPOSx <= 110) {
                    oldX = 111;
                    ballPOSx = 111;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 110 + linePOS && ballPOSx <= 130 + linePOS) {
                if (oldY < 160 && ballPOSy >= 160) {
                    oldY = 159;
                    ballPOSy = 159;
                    shotUP = true;
                }
                if (oldY > 171 && ballPOSy <= 171) {
                    oldY = 172;
                    ballPOSy = 172;
                    shotUP = false;
                }
            }
            if (ballPOSx >= 140 - linePOS && ballPOSx <= 160 - linePOS) {
                if (oldY < 230 && ballPOSy >= 230) {
                    oldY = 229;
                    ballPOSy = 229;
                    shotUP = true;
                }
                if (oldY > 241 && ballPOSy <= 241) {
                    oldY = 242;
                    ballPOSy = 242;
                    shotUP = false;
                }
            }
            if (ballPOSx >= 108 && ballPOSx <= 163 && ballPOSy >= 141 && ballPOSy <= 169) {
                slopeUP = true;
            }
            if (ballPOSx >= 238 && ballPOSx <= 293 && ballPOSy >= 233 && ballPOSy <= 261) {
                slopeUP = true;
            }
            if (ballPOSx >= 108 && ballPOSx <= 163 && ballPOSy >= 233 && ballPOSy <= 261) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 238 && ballPOSx <= 293 && ballPOSy >= 141 && ballPOSy <= 169) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 238 && ballPOSx <= 293 && ballPOSy >= 168 && ballPOSy <= 232) {
                slopeRIGHT = true;
            }
        }

        //LEVEL 12
        else if (Level12) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 100f, 300f, 200f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(75f, 165f, 40f, 70f);
            strokeWeight(2);
            fill(199, 190, 91);
            rect(140f, 210f, 40f, 88f);
            rect(220f, 103f, 40f, 88f);
            stroke(163, 163, 95);
            arc(160f, 210f, 40f, 40f, 180f, 360f);
            arc(240f, 190f, 40f, 40f, 0f, 180f);
            line(140f, 210f, 140f, 296f);
            line(180f, 210f, 180f, 296f);
            line(220f, 105f, 220f, 190f);
            line(260f, 105f, 260f, 190f);
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                textAlign(CENTER, BOTTOM);
                text("This hole contains bunkers. Try to avoid them.", 200f, 90f);
                textAlign(LEFT, BOTTOM);
            }
            holePOSx = 300;
            holePOSy = 200;
            dX1 = 75;
            dX2 = 115;
            dY1 = 165;
            dY2 = 235;
            //Boundaries
            if (ballPOSy >= 295) {
                ballPOSy = 295;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 106) {
                ballPOSy = 106;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (ballPOSx >= 140 && ballPOSx <= 180 && ballPOSy >= 210) {
                bunker = true;
            }
            if (dist(ballPOSx, ballPOSy, 160, 210) < 20) {
                bunker = true;
            }
            if (ballPOSx >= 220 && ballPOSx <= 260 && ballPOSy <= 190) {
                bunker = true;
            }
            if (dist(ballPOSx, ballPOSy, 240, 190) < 20) {
                bunker = true;
            }
        }

        //LEVEL 13
        else if (Level13) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 110f, 300f, 180f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(55f, 215f, 52f, 71f);
            fill(13, 184, 4);
            rect(53f, 113f, 295f, 75f);
            stroke(173, 116, 2);
            fill(92, 62, 1);
            rect(195f, 110f, 10f, 75f);
            noStroke();
            strokeWeight(2);
            fill(199, 190, 91);
            rect(110f, 230f, 190f, 58f);
            rect(130f, 210f, 150f, 78f);
            stroke(163, 163, 95);
            arc(130f, 230f, 40f, 40f, 180f, 270f);
            arc(280f, 230f, 40f, 40f, 270f, 360f);
            line(110f, 230f, 110f, 286f);
            line(300f, 230f, 300f, 286f);
            line(130f, 210f, 280f, 210f);
            strokeWeight(1);
            for (int  bRep = 0; bRep < 7; bRep += 1) {
                stroke(90, 190, 90);
                line(60f + bRep * 20f, 118f, 65f + bRep * 20f, 182f);
                line(70f + bRep * 20f, 118f, 65f + bRep * 20f, 182f);
                line(210f + bRep * 20f, 118f, 215f + bRep * 20f, 182f);
                line(220f + bRep * 20f, 118f, 215f + bRep * 20f, 182f);
            }
            dX1 = 55f;
            dX2 = 107f;
            dY1 = 215f;
            dY2 = 286f;
            holePOSx = 325f;
            holePOSy = 260f;
            //Boundaries
            if (ballPOSy >= 285f) {
                ballPOSy = 285f;
                shotUP = true;
            }
            if (ballPOSx >= 345f) {
                ballPOSx = 345f;
                shotLEFT = true;
            }
            if (ballPOSy <= 116f) {
                ballPOSy = 116f;
                shotUP = false;
            }
            if (ballPOSx <= 56f) {
                ballPOSx = 56f;
                shotLEFT = false;
            }
            if (ballPOSy <= 188f) {
                if (oldX < 190f && ballPOSx >= 190f) {
                    oldX = 189f;
                    ballPOSx = 189f;
                    shotLEFT = true;
                }
                if (oldX > 211f && ballPOSx <= 211f) {
                    oldX = 212f;
                    ballPOSx = 212f;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 190 && ballPOSx <= 211 && oldY > 191 && ballPOSy <= 191) {
                oldY = 192;
                ballPOSy = 192;
                shotUP = false;
            }
            if (ballPOSy <= 188) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 110 && ballPOSx <= 300 && ballPOSy >= 230) {
                bunker = true;
            }
            if (ballPOSx >= 130 && ballPOSx <= 280 && ballPOSy >= 210) {
                bunker = true;
            }
            if (dist(ballPOSx, ballPOSy, 130, 230) < 20) {
                bunker = true;
            }
            if (dist(ballPOSx, ballPOSy, 280, 230) < 20) {
                bunker = true;
            }
        }

        //LEVEL 14
        else if (Level14) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 100f, 300f, 200f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(75f, 165f, 40f, 70f);
            strokeWeight(2);
            fill(199, 190, 91);
            rect(170f, 285f, 178f, 13f);
            rect(190f, 265f, 138f, 33f);
            rect(325f, 103f, 23f, 195f);
            rect(170f, 103f, 178f, 13f);
            rect(190f, 103f, 138f, 33f);
            rect(305f, 245f, 20f, 20f);
            rect(305f, 136f, 20f, 20f);
            stroke(163, 163, 95);
            arc(190f, 285f, 40f, 40f, 180f, 270f);
            arc(190f, 116f, 40f, 40f, 90f, 180f);
            fill(30, 168, 2);
            arc(305f, 156f, 40f, 40f, 270f, 360f);
            arc(305f, 245f, 40f, 40f, 0f, 90f);
            line(170f, 285f, 170f, 296f);
            line(170f, 104f, 170f, 116f);
            line(190f, 265f, 302f, 265f);
            line(190f, 136f, 302f, 136f);
            line(325f, 156f, 325f, 245f);
            fill(0, 115, 220);
            noStroke();
            rect(170f, 180f, 125f, 40f);
            rect(190f, 160f, 85f, 80f);
            stroke(80, 150, 205);
            arc(190f, 180f, 40f, 40f, 180f, 270f);
            arc(275f, 180f, 40f, 40f, 270f, 360f);
            arc(275f, 220f, 40f, 40f, 0f, 90f);
            arc(190f, 220f, 40f, 40f, 90f, 180f);
            line(170f, 180f, 170f, 220f);
            line(190f, 160f, 275f, 160f);
            line(295f, 180f, 295f, 220f);
            line(190f, 240f, 275f, 240f);
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                textAlign(CENTER, BOTTOM);
                text("Don't putt your ball into the water", 200f, 90f);
                textAlign(LEFT, BOTTOM);
            }
            holePOSx = 310;
            holePOSy = 200;
            dX1 = 75;
            dX2 = 115;
            dY1 = 165;
            dY2 = 235;
            //Boundaries
            if (ballPOSy >= 295) {
                ballPOSy = 295;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 106) {
                ballPOSy = 106;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (ballPOSx >= 170 && ballPOSy <= 116) {
                bunker = true;
            }
            if (ballPOSx >= 190 && ballPOSy <= 136) {
                bunker = true;
            }
            if (ballPOSx >= 170 && ballPOSy >= 285) {
                bunker = true;
            }
            if (ballPOSx >= 190 && ballPOSy >= 265) {
                bunker = true;
            }
            if (ballPOSx >= 325) {
                bunker = true;
            }
            if (dist(ballPOSx, ballPOSy, 190, 116) < 20) {
                bunker = true;
            }
            if (dist(ballPOSx, ballPOSy, 190, 285) < 20) {
                bunker = true;
            }
            if (ballPOSx >= 305 && ballPOSy <= 156 && dist(ballPOSx, ballPOSy, 305, 156) > 20) {
                bunker = true;
            }
            if (ballPOSx >= 305 && ballPOSy >= 265 && dist(ballPOSx, ballPOSy, 305, 265) > 20) {
                bunker = true;
            }
            if (ballPOSx >= 170 && ballPOSx <= 295 && ballPOSy >= 180 && ballPOSy <= 220) {
                water = true;
            }
            if (ballPOSx >= 190 && ballPOSx <= 275 && ballPOSy >= 160 && ballPOSy <= 240) {
                water = true;
            }
            if (dist(ballPOSx, ballPOSy, 190, 180) < 20) {
                water = true;
            }
            if (dist(ballPOSx, ballPOSy, 275, 180) < 20) {
                water = true;
            }
            if (dist(ballPOSx, ballPOSy, 275, 220) < 20) {
                water = true;
            }
            if (dist(ballPOSx, ballPOSy, 190, 220) < 20) {
                water = true;
            }
        }

        //LEVEL 15
        else if (Level15) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 50f, 300f, 300f);
            line(50f, 100f, 300f, 100f);
            line(300f, 100f, 300f, 300f);
            line(100f, 300f, 300f, 300f);
            line(100f, 150f, 100f, 300f);
            line(100f, 150f, 250f, 150f);
            line(250f, 150f, 250f, 250f);
            line(150f, 250f, 250f, 250f);
            line(150f, 200f, 150f, 250f);
            line(150f, 200f, 200f, 200f);
            noStroke();
            fill(0, 0, 0, 100);
            rect(55f, 55f, 40f, 40f);
            fill(13, 184, 4);
            rect(97f, 53f, 205f, 45f);
            rect(53f, 103f, 199f, 45f);
            rect(103f, 153f, 100f, 45f);
            rect(303f, 53f, 45f, 250f);
            rect(253f, 103f, 45f, 150f);
            rect(204f, 153f, 44f, 50f);
            fill(3, 148, 8);
            rect(53f, 148f, 45f, 200f);
            rect(103f, 198f, 45f, 100f);
            rect(203f, 203f, 45f, 45f);
            rect(99f, 303f, 249f, 45f);
            rect(149f, 253f, 149f, 45f);
            dX1 = 55;
            dX2 = 95;
            dY1 = 55;
            dY2 = 95;
            holePOSx = 178;
            holePOSy = 225;
            strokeWeight(1);
            for (int  bRep = 0; bRep < 45; bRep += 15) {
                stroke(0, 125, 0);
                line(55f + bRep, 345f, 60f + bRep, 150f);
                line(65f + bRep, 345f, 60f + bRep, 150f);
                line(345f, 305f + bRep, 100f, 310f + bRep);
                line(345f, 315f + bRep, 100f, 310f + bRep);
                line(105f + bRep, 295f, 110f + bRep, 200f);
                line(115f + bRep, 295f, 110f + bRep, 200f);
                line(295f, 255f + bRep, 150f, 260f + bRep);
                line(295f, 265f + bRep, 150f, 260f + bRep);
                line(245f, 205f + bRep, 205f, 210f + bRep);
                line(245f, 215f + bRep, 205f, 210f + bRep);
                stroke(90, 190, 90);
                line(100f, 55f + bRep, 300f, 60f + bRep);
                line(100f, 65f + bRep, 300f, 60f + bRep);
                line(305f + bRep, 55f, 310f + bRep, 300f);
                line(315f + bRep, 55f, 310f + bRep, 300f);
                line(55f, 105f + bRep, 250f, 110f + bRep);
                line(55f, 115f + bRep, 250f, 110f + bRep);
                line(255f + bRep, 105f, 260f + bRep, 250f);
                line(265f + bRep, 105f, 260f + bRep, 250f);
                line(105f, 155f + bRep, 200f, 160f + bRep);
                line(105f, 165f + bRep, 200f, 160f + bRep);
                line(205f + bRep, 155f, 210f + bRep, 200f);
                line(215f + bRep, 155f, 210f + bRep, 200f);
            }
            //Boundaries
            if (ballPOSy >= 345) {
                ballPOSy = 345;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 56) {
                ballPOSy = 56;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (ballPOSx <= 300) {
                if (oldY < 95 && ballPOSy >= 95) {
                    oldY = 94;
                    ballPOSy = 94;
                    shotUP = true;
                }
                if (oldY > 106 && ballPOSy <= 106) {
                    oldY = 107;
                    ballPOSy = 107;
                    shotUP = false;
                }
            }
            if (ballPOSy >= 100 && ballPOSy <= 300) {
                if (oldX < 295 && ballPOSx >= 295) {
                    oldX = 294;
                    ballPOSx = 294;
                    shotLEFT = true;
                }
                if (oldX > 306 && ballPOSx <= 306) {
                    oldX = 307;
                    ballPOSx = 307;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 100 && ballPOSx <= 300) {
                if (oldY < 295 && ballPOSy >= 295) {
                    oldY = 294;
                    ballPOSy = 294;
                    shotUP = true;
                }
                if (oldY > 306 && ballPOSy <= 306) {
                    oldY = 307;
                    ballPOSy = 307;
                    shotUP = false;
                }
            }
            if (ballPOSy >= 150 && ballPOSy <= 300) {
                if (oldX < 95 && ballPOSx >= 95) {
                    oldX = 94;
                    ballPOSx = 94;
                    shotLEFT = true;
                }
                if (oldX > 106 && ballPOSx <= 106) {
                    oldX = 107;
                    ballPOSx = 107;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 100 && ballPOSx <= 250) {
                if (oldY < 145 && ballPOSy >= 145) {
                    oldY = 144;
                    ballPOSy = 144;
                    shotUP = true;
                }
                if (oldY > 156 && ballPOSy <= 156) {
                    oldY = 157;
                    ballPOSy = 157;
                    shotUP = false;
                }
            }
            if (ballPOSy >= 150 && ballPOSy <= 250) {
                if (oldX < 245 && ballPOSx >= 245) {
                    oldX = 244;
                    ballPOSx = 244;
                    shotLEFT = true;
                }
                if (oldX > 256 && ballPOSx <= 256) {
                    oldX = 257;
                    ballPOSx = 257;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 150 && ballPOSx <= 250) {
                if (oldY < 245 && ballPOSy >= 245) {
                    oldY = 244;
                    ballPOSy = 244;
                    shotUP = true;
                }
                if (oldY > 256 && ballPOSy <= 256) {
                    oldY = 257;
                    ballPOSy = 257;
                    shotUP = false;
                }
            }
            if (ballPOSy >= 200 && ballPOSy <= 250) {
                if (oldX < 145 && ballPOSx >= 145) {
                    oldX = 144;
                    ballPOSx = 144;
                    shotLEFT = true;
                }
                if (oldX > 156 && ballPOSx <= 156) {
                    oldX = 157;
                    ballPOSx = 157;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 150 && ballPOSx <= 200) {
                if (oldY < 195 && ballPOSy >= 195) {
                    oldY = 194;
                    ballPOSy = 194;
                    shotUP = true;
                }
                if (oldY > 206 && ballPOSy <= 206) {
                    oldY = 207;
                    ballPOSy = 207;
                    shotUP = false;
                }
            }
            if (ballPOSx >= 97 && ballPOSx <= 302 && ballPOSy >= 53 && ballPOSy <= 98) {
                slopeRIGHT = true;
            }
            if (ballPOSx >= 303 && ballPOSx <= 348 && ballPOSy >= 53 && ballPOSy <= 303) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 53 && ballPOSx <= 252 && ballPOSy >= 103 && ballPOSy <= 148) {
                slopeRIGHT = true;
            }
            if (ballPOSx >= 253 && ballPOSx <= 298 && ballPOSy >= 103 && ballPOSy <= 253) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 103 && ballPOSx <= 203 && ballPOSy >= 153 && ballPOSy <= 198) {
                slopeRIGHT = true;
            }
            if (ballPOSx >= 204 && ballPOSx <= 248 && ballPOSy >= 153 && ballPOSy <= 203) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 53 && ballPOSx <= 98 && ballPOSy >= 148 && ballPOSy <= 348) {
                slopeUP = true;
            }
            if (ballPOSx >= 99 && ballPOSx <= 348 && ballPOSy >= 303 && ballPOSy <= 348) {
                slopeLEFT = true;
            }
            if (ballPOSx >= 103 && ballPOSx <= 148 && ballPOSy >= 198 && ballPOSy <= 298) {
                slopeUP = true;
            }
            if (ballPOSx >= 149 && ballPOSx <= 298 && ballPOSy >= 253 && ballPOSy <= 298) {
                slopeLEFT = true;
            }
            if (ballPOSx >= 203 && ballPOSx <= 248 && ballPOSy >= 203 && ballPOSy <= 248) {
                slopeLEFT = true;
            }
        }

        //LEVEL 16
        else if (Level16) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 100f, 300f, 200f);
            noStroke();
            fill(13, 184, 4);
            rect(162f, 103f, 15f, 195f);
            rect(202f, 103f, 15f, 195f);
            rect(242f, 103f, 15f, 195f);
            fill(3, 148, 8);
            rect(142f, 103f, 15f, 195f);
            rect(182f, 103f, 15f, 195f);
            rect(222f, 103f, 15f, 195f);
            rect(53f, 153f, 45f, 70f);
            rect(304f, 147f, 44f, 130f);
            fill(0, 0, 0, 100);
            rect(55f, 225f, 38f, 71f);
            fill(0, 115, 220);
            rect(98f, 103f, 30f, 195f);
            rect(272f, 103f, 30f, 195f);
            stroke(80, 150, 205);
            strokeWeight(2);
            line(98f, 104f, 98f, 296f);
            line(128f, 104f, 128f, 296f);
            line(272f, 104f, 272f, 296f);
            line(302f, 104f, 302f, 296f);
            stroke(100);
            strokeWeight(5);
            line(93f, 105f + linePOS, 133f, 105f + linePOS);
            line(93f, 125f + linePOS, 133f, 125f + linePOS);
            line(267f, 295f - linePOS, 307f, 295f - linePOS);
            line(267f, 275f - linePOS, 307f, 275f - linePOS);
            noStroke();
            fill(125);
            rect(98f, 108f + linePOS, 30f, 15f);
            rect(272f, 278f - linePOS, 30f, 15f);
            strokeWeight(5);
            stroke(173, 116, 2);
            line(97f, 180f, 97f, 298f);
            line(303f, 102f, 303f, 220f);
            strokeWeight(1);
            for (int  bRep = 0; bRep < 42; bRep += 14) {
                stroke(0, 125, 0);
                line(55f + bRep, 220f, 60f + bRep, 155f);
                line(65f + bRep, 220f, 60f + bRep, 155f);
                line(307f + bRep, 270f, 312f + bRep, 150f);
                line(317f + bRep, 270f, 312f + bRep, 150f);
            }
            for (int  bRep = 0; bRep < 200; bRep += 20) {
                stroke(0, 125, 0);
                line(154f, 105f + bRep, 145f, 110f + bRep);
                line(154f, 115f + bRep, 145f, 110f + bRep);
                line(194f, 105f + bRep, 185f, 110f + bRep);
                line(194f, 115f + bRep, 185f, 110f + bRep);
                line(234f, 105f + bRep, 225f, 110f + bRep);
                line(234f, 115f + bRep, 225f, 110f + bRep);
                stroke(90, 190, 90);
                line(165f, 105f + bRep, 174f, 110f + bRep);
                line(165f, 115f + bRep, 174f, 110f + bRep);
                line(205f, 105f + bRep, 214f, 110f + bRep);
                line(205f, 115f + bRep, 214f, 110f + bRep);
                line(245f, 105f + bRep, 254f, 110f + bRep);
                line(245f, 115f + bRep, 254f, 110f + bRep);
            }
            if (linePOS <= 0) {
                lineUP = false;
            }
            if (linePOS >= 50) {
                lineUP = true;
            }
            if (lineUP) {
                linePOS -= 1;
            } else {
                linePOS += 1;
            }
            dX1 = 55f;
            dX2 = 95f;
            dY1 = 225f;
            dY2 = 296f;
            holePOSx = 325f;
            holePOSy = 125f;
            //Boundaries
            if (ballPOSy >= 295) {
                ballPOSy = 295;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 106) {
                ballPOSy = 106;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (ballPOSy >= 180) {
                if (oldX < 92 && ballPOSx >= 92) {
                    oldX = 91;
                    ballPOSx = 91;
                    shotLEFT = true;
                }
                if (oldX > 103 && ballPOSx <= 103) {
                    oldX = 104;
                    ballPOSx = 104;
                    shotLEFT = false;
                }
            }
            if (ballPOSy <= 220) {
                if (oldX < 298 && ballPOSx >= 298) {
                    oldX = 297;
                    ballPOSx = 297;
                    shotLEFT = true;
                }
                if (oldX > 309 && ballPOSx <= 309) {
                    oldX = 310;
                    ballPOSx = 310;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 90 && ballPOSx <= 136) {
                if (oldY < 100 + linePOS && ballPOSy >= 100 + linePOS) {
                    oldY = 99 + linePOS;
                    ballPOSy = 99 + linePOS;
                    shotUP = true;
                }
                if (oldY > 111 + linePOS && ballPOSy <= 111 + linePOS) {
                    oldY = 112 + linePOS;
                    ballPOSy = 112 + linePOS;
                    shotUP = false;
                }
                if (oldY < 120 + linePOS && ballPOSy >= 120 + linePOS) {
                    oldY = 119 + linePOS;
                    ballPOSy = 119 + linePOS;
                    shotUP = true;
                }
                if (oldY > 131 + linePOS && ballPOSy <= 131 + linePOS) {
                    oldY = 132 + linePOS;
                    ballPOSy = 132 + linePOS;
                    shotUP = false;
                }
            }
            if (ballPOSx >= 98 && ballPOSx <= 128) {
                if (ballPOSy <= 100 + linePOS) {
                    water = true;
                }
                if (ballPOSy >= 131 + linePOS) {
                    water = true;
                }
                if (ballPOSy > 100 + linePOS && ballPOSy < 131 + linePOS) {
                    if (lineUP) {
                        ballPOSy -= 1;
                    } else {
                        ballPOSy += 1;
                    }
                }
            }
            if (ballPOSx >= 264 && ballPOSx <= 310) {
                if (oldY < 270 - linePOS && ballPOSy >= 270 - linePOS) {
                    oldY = 269 - linePOS;
                    ballPOSy = 269 - linePOS;
                    shotUP = true;
                }
                if (oldY > 281 - linePOS && ballPOSy <= 281 - linePOS) {
                    oldY = 282 - linePOS;
                    ballPOSy = 282 - linePOS;
                    shotUP = false;
                }
                if (oldY < 290 - linePOS && ballPOSy >= 290 - linePOS) {
                    oldY = 289 - linePOS;
                    ballPOSy = 289 - linePOS;
                    shotUP = true;
                }
                if (oldY > 301 - linePOS && ballPOSy <= 301 - linePOS) {
                    oldY = 302 - linePOS;
                    ballPOSy = 302 - linePOS;
                    shotUP = false;
                }
            }
            if (ballPOSx >= 272 && ballPOSx <= 302) {
                if (ballPOSy <= 270 - linePOS) {
                    water = true;
                }
                if (ballPOSy >= 301 - linePOS) {
                    water = true;
                }
                if (ballPOSy > 270 - linePOS && ballPOSy < 301 - linePOS) {
                    if (lineUP) {
                        ballPOSy -= 1;
                    } else {
                        ballPOSy += 1;
                    }
                }
            }
            if (ballPOSx >= 53 && ballPOSx <= 98 && ballPOSy >= 153 && ballPOSy <= 223) {
                slopeUP = true;
            }
            if (ballPOSx >= 304 && ballPOSx <= 348 && ballPOSy >= 147 && ballPOSy <= 277) {
                slopeUP = true;
            }
            if (ballPOSx >= 142 && ballPOSx <= 157 && ballPOSy >= 103 && ballPOSy <= 298) {
                slopeLEFT = true;
            }
            if (ballPOSx >= 182 && ballPOSx <= 197 && ballPOSy >= 103 && ballPOSy <= 298) {
                slopeLEFT = true;
            }
            if (ballPOSx >= 222 && ballPOSx <= 237 && ballPOSy >= 103 && ballPOSy <= 298) {
                slopeLEFT = true;
            }
            if (ballPOSx >= 162 && ballPOSx <= 177 && ballPOSy >= 103 && ballPOSy <= 298) {
                slopeRIGHT = true;
            }
            if (ballPOSx >= 202 && ballPOSx <= 217 && ballPOSy >= 103 && ballPOSy <= 298) {
                slopeRIGHT = true;
            }
        }

        //LEVEL 17
        else if (Level17) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 65f, 230f, 100f);
            rect(50f, 230f, 250f, 120f);
            line(150, 280, 220, 280);
            line(150, 300, 220, 300);
            fill(128, 86, 2);
            rect(200f, 230f, 25f, 50f);
            rect(200f, 300f, 25f, 50f);
            rect(225f, 230f, 75f, 25f);
            rect(225f, 325f, 75f, 25f);
            noStroke();
            rect(205f, 233f, 50f, 20f);
            rect(205f, 328f, 50f, 20f);
            fill(0, 0, 0, 100);
            rect(55f, 255f, 40f, 70f);
            strokeWeight(2);
            fill(175);
            stroke(125);
            beginShape();
            vertex(303f, 310f);
            vertex(303f, 325f);
            vertex(335f, 325f);
            vertex(335f, 107f);
            vertex(283f, 107f);
            vertex(283f, 122f);
            vertex(320f, 122f);
            vertex(320f, 310f);
            vertex(303f, 310f);
            endShape();
            beginShape();
            vertex(303f, 282f);
            vertex(303f, 297f);
            vertex(360f, 297f);
            vertex(360f, 85f);
            vertex(283f, 85f);
            vertex(283f, 100f);
            vertex(345f, 100f);
            vertex(345f, 282f);
            vertex(303f, 282f);
            endShape();
            beginShape();
            vertex(277f, 228f);
            vertex(292f, 228f);
            vertex(292f, 205f);
            vertex(307f, 185f);
            vertex(307f, 142f);
            vertex(283f, 130f);
            vertex(283f, 150f);
            vertex(292f, 155f);
            vertex(292f, 180f);
            vertex(277f, 200f);
            vertex(277f, 228f);
            endShape();
            noStroke();
            strokeWeight(1);
            fill(3, 148, 8);
            rect(148f, 283f, 80f, 15f);
            rect(140f, 68f, 60f, 95f);
            stroke(0, 125, 0);
            line(228f, 285f, 150f, 290f);
            line(228f, 295f, 150f, 290f);
            for (int  bRep = 0; bRep < 100; bRep += 20) {
                line(198f, 70f + bRep, 143f, 75f + bRep);
                line(198f, 80f + bRep, 143f, 75f + bRep);
            }
            for (int  cRep = 0; cRep < 3; cRep += 1) {
                stroke(0, 0, 0, 90 - cRep * 30);
                line(277f - cRep, 85f, 277f - cRep, 100f);
                line(277f - cRep, 107f, 277f - cRep, 122f);
                line(277f - cRep, 130f, 277f - cRep, 145f);
            }
            noStroke();
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                textAlign(CENTER, BOTTOM);
                text("Go into one of the holes to send the ball out the other side", 200f, 60f);
                textAlign(LEFT, BOTTOM);
            }
            dX1 = 55;
            dX2 = 95;
            dY1 = 255;
            dY2 = 325;
            holePOSx = 100;
            holePOSy = 115;
            //Boundaries
            if (ballPOSy >= 345) {
                ballPOSy = 345;
                shotUP = true;
            }
            if (ballPOSx >= 295) {
                ballPOSx = 295;
                shotLEFT = true;
            }
            if (ballPOSy <= 71) {
                ballPOSy = 71;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (oldY < 160 && ballPOSy >= 160) {
                oldY = 159;
                ballPOSy = 159;
                shotUP = true;
            }
            if (oldY > 236 && ballPOSy <= 236) {
                oldY = 237;
                ballPOSy = 237;
                shotUP = false;
            }
            if (ballPOSy < 200 && ballPOSx >= 275) {
                ballPOSx = 275;
                shotLEFT = true;
            }
            if (ballPOSx >= 150 && ballPOSx <= 220) {
                if (oldY < 275 && ballPOSy >= 275) {
                    oldY = 274;
                    ballPOSy = 274;
                    shotUP = true;
                }
                if (oldY > 286 && ballPOSy <= 286) {
                    oldY = 287;
                    ballPOSy = 287;
                    shotUP = false;
                }
                if (oldY < 295 && ballPOSy >= 295) {
                    oldY = 294;
                    ballPOSy = 294;
                    shotUP = true;
                }
                if (oldY > 306 && ballPOSy <= 306) {
                    oldY = 307;
                    ballPOSy = 307;
                    shotUP = false;
                }
            }
            if (oldX < 195 && ballPOSx >= 195) {
                if (ballPOSy >= 300) {
                    oldX = 194;
                    ballPOSx = 194;
                    shotLEFT = true;
                }
                if (ballPOSy <= 280 && ballPOSy >= 200) {
                    oldX = 194;
                    ballPOSx = 194;
                    shotLEFT = true;
                }
            }
            if (oldX > 231 && ballPOSx <= 231) {
                if (ballPOSy >= 300) {
                    oldX = 232;
                    ballPOSx = 232;
                    shotLEFT = false;
                }
                if (ballPOSy <= 280 && ballPOSy >= 200) {
                    oldX = 232;
                    ballPOSx = 232;
                    shotLEFT = false;
                }
            }
            if (ballPOSx >= 210) {
                if (oldY > 261 && ballPOSy <= 261) {
                    oldY = 262;
                    ballPOSy = 262;
                    shotUP = false;
                }
                if (oldY < 320 && ballPOSy >= 320) {
                    oldY = 319;
                    ballPOSy = 319;
                    shotUP = true;
                }
            }
            if (ballPOSx >= 148 && ballPOSx <= 228 && ballPOSy >= 283 && ballPOSy <= 298) {
                slopeLEFT = true;
            }
            if (ballPOSx >= 140 && ballPOSx <= 200 && ballPOSy <= 200) {
                slopeLEFT = true;
            }
            fill(0, 0, 0, 100);
            ellipse(285, 270, 14, 14);
            ellipse(285, 270, 10, 10);
            if (dist(ballPOSx, ballPOSy, 285, 270) <= 10 - (speedX + speedY)/3 && speedX < 8 && speedY < 8) {
                ballPOSx = 285;
                ballPOSy = 270;
                speedX = 0;
                speedY = 0;
                resetShot = false;
                if (delayTimer < 40) {
                    if (delayTimer >= 10) {
                        underGround = true;
                    }
                    delayTimer += 1;
                } else {
                    underGround = false;
                    delayTimer = 0;
                    ballPOSx = 280;
                    ballPOSy = 137;
                    shotLEFT = true;
                    shotUP = true;
                    speedX = 14;
                    speedY = 7;
                    shotDiminish = 11;
                }
            }
            fill(0, 0, 0, 100);
            ellipse(285, 290, 14, 14);
            ellipse(285, 290, 10, 10);
            if (dist(ballPOSx, ballPOSy, 285, 290) <= 10 - (speedX + speedY)/3 && speedX < 8 && speedY < 8) {
                ballPOSx = 285;
                ballPOSy = 290;
                speedX = 0;
                speedY = 0;
                resetShot = false;
                if (delayTimer < 40) {
                    if (delayTimer >= 10) {
                        underGround = true;
                    }
                    delayTimer += 1;
                } else {
                    underGround = false;
                    delayTimer = 0;
                    ballPOSx = 280;
                    ballPOSy = 92;
                    shotLEFT = true;
                    speedX = 20;
                    shotDiminish = 10;
                }
            }
            fill(0, 0, 0, 100);
            ellipse(285, 310, 14, 14);
            ellipse(285, 310, 10, 10);
            if (dist(ballPOSx, ballPOSy, 285, 308) <= 10 - (speedX + speedY)/3 && speedX < 8 && speedY < 8) {
                ballPOSx = 285;
                ballPOSy = 310;
                speedX = 0;
                speedY = 0;
                resetShot = false;
                if (delayTimer < 40) {
                    if (delayTimer >= 10) {
                        underGround = true;
                    }
                    delayTimer += 1;
                } else {
                    underGround = false;
                    delayTimer = 0;
                    ballPOSx = 280;
                    ballPOSy = 115;
                    shotLEFT = true;
                    speedX = 20;
                    shotDiminish = 10;
                }
            }
        }

        //LEVEL 18
        else if (Level18) {
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 75f, 300f, 250f);
            rect(284f, 325f, 66f, 100f);
            line(284f, 260f, 315f, 260f);
            line(315f, 120f, 315f, 260f);
            fill(133, 89, 2);
            rect(99f, 75f, 185f, 185f);
            noStroke();
            fill(30, 168, 2);
            rect(287f, 320f, 61f, 10f);
            fill(125);
            rect(97f, 78f, 100f, 50f);
            rect(192f, 208f, 95f, 50f);
            float cX = 192;
            float cY = 168;
            float cD = 180;
            fill(13, 184, 4);
            rect(287f, 78f, 30f, 40f);
            rect(318f, 78f, 30f, 184f);
            rect(287f, 263f, 60f, 140f);
            rect(53f, 263f, 44f, 60f);
            fill(3, 148, 8);
            rect(287f, 118f, 26f, 140f);
            strokeWeight(1);
            for (int  bRep = 0; bRep < 30; bRep += 15) {
                stroke(0, 125, 0);
                line(288f + bRep, 255f, 293f + bRep, 121f);
                line(298f + bRep, 255f, 293f + bRep, 121f);
                stroke(90, 190, 90);
                line(320f + bRep, 80f, 325f + bRep, 260f);
                line(330f + bRep, 80f, 325f + bRep, 260f);
            }
            for (int  aRep = 0; aRep < 36; aRep += 12) {
                line(288f, 80f + aRep, 314f, 85f + aRep);
                line(288f, 90f + aRep, 314f, 85f + aRep);
            }
            strokeWeight(4);
            for (int  cRep = 0; cRep < 16; cRep += 1) {
                if (selection == cRep && underGround) {
                    fill(230, 230, 28);
                } else {
                    fill(150);
                }
                stroke(125);
                arc(cX, cY, cD, cD, (float) (-90 + cRep * 22.5), (float) (-67.5 + cRep * 22.5));
            }
            for (int  dRep = 0; dRep < 60; dRep += 20) {
                stroke(90, 190, 90);
                strokeWeight(1);
                line(292f + dRep, 265f, 297f + dRep, 398f);
                line(302f + dRep, 265f, 297f + dRep, 398f);
                line(55f, 268f + dRep, 95f, 273f + dRep);
                line(55f, 278f + dRep, 95f, 273f + dRep);
                stroke(105);
                strokeWeight(2);
                line(100f + dRep/2f, 94f, 110f + dRep/2f, 100f);
                line(100f + dRep/2f, 106f, 110f + dRep/2f, 100f);
                line(254f + dRep/2f, 234f, 264f + dRep/2f, 240f);
                line(254f + dRep/2f, 246f, 264f + dRep/2f, 240f);
            }
            stroke(125);
            strokeWeight(4f);
            String[] FortuneString = {"+1", "-1", "0", "+2", "-2", "Re", "+3", "-3", "0", "+4", "-4", "0", "+5", "-5", "0", "Spin"};
            textAlign(CENTER, CENTER);
            for (int  bRep = 0; bRep < 16; bRep += 1) {
                line((float) (cos(bRep * 22.5f - 90f) * 90f + cX), (float) (sin(bRep * 22.5f - 90f) * 90f + cY), cX, cY);
                fill(255);
                text(FortuneString[bRep], (float) (cos(bRep * 22.5f - 80f) * 70f + cX), (float) (sin(bRep * 22.5f - 80f) * 70f + cY));
            }
            textAlign(LEFT, BOTTOM);
            noStroke();
            fill(0, 0, 0, 100);
            rect(55f, 80f, 40f, 70f);
            strokeWeight(1);
            if (tips) {
                if (textDiminish > 0) {
                    if (drop) {
                        textDiminish -= 0.2;
                    } else {
                        textDiminish -= 5;
                    }
                }
                textSize(11);
                fill(255, 255, 0, textDiminish);
                textAlign(CENTER, BOTTOM);
                text("Putt your ball into the wheel or play it safe and go around", 200f, 70f);
                textAlign(LEFT, BOTTOM);
            }
            dX1 = 55;
            dX2 = 95;
            dY1 = 80;
            dY2 = 150;
            holePOSx = 320;
            holePOSy = 500;
            if (ballPOSy > 400) {
                speedX = 0;
                speedY = 0;
                ballPOSx = holePOSx;
                ballPOSy = holePOSy;
            }
            //Boundaries
            if (ballPOSx <= 284 && oldY < 320 && ballPOSy >= 320) {
                oldY = 319;
                ballPOSy = 319;
                shotUP = true;
            }
            if (ballPOSx >= 345) {
                ballPOSx = 345;
                shotLEFT = true;
            }
            if (ballPOSy <= 81) {
                ballPOSy = 81;
                shotUP = false;
            }
            if (ballPOSx <= 56) {
                ballPOSx = 56;
                shotLEFT = false;
            }
            if (ballPOSy < 128 && oldX < 95 && ballPOSx >= 95) {
                underGround = true;
            }
            if (ballPOSy >= 320 && oldX > 290 && ballPOSx <= 290) {
                oldX = 291;
                ballPOSx = 291;
                shotLEFT = false;
            }
            if (ballPOSy >= 128 && ballPOSy <= 260 && oldX < 94 && ballPOSx >= 94) {
                oldX = 93;
                ballPOSx = 93;
                shotLEFT = true;
            }
            if (ballPOSx >= 99 && ballPOSx <= 315) {
                if (oldY > 266 && ballPOSy <= 266) {
                    oldY = 267;
                    ballPOSy = 267;
                    shotUP = false;
                }
                if (oldY < 255 && ballPOSy >= 255) {
                    oldY = 254;
                    ballPOSy = 254;
                    shotUP = true;
                }
            }
            if (ballPOSy >= 120 && ballPOSy <= 260) {
                if (oldX < 310 && ballPOSx >= 310) {
                    oldX = 309;
                    ballPOSx = 309;
                    shotLEFT = true;
                }
                if (oldX > 321 && ballPOSx <= 321) {
                    oldX = 322;
                    ballPOSx = 322;
                    shotLEFT = false;
                }
            }

            if (ballPOSx >= 284 && ballPOSx <= 317 && ballPOSy >= 118 && ballPOSy <= 260) {
                slopeUP = true;
            }
            if (ballPOSx >= 284 && ballPOSx <= 317 && ballPOSy <= 118) {
                slopeRIGHT = true;
            }
            if (ballPOSx >= 318 && ballPOSy <= 262) {
                slopeDOWN = true;
            }
            if (ballPOSx >= 284 && ballPOSy >= 260) {
                slopeDOWN = true;
            }

            if (ballPOSy <= 260 && oldX > 290 && ballPOSx <= 290) {
                oldX = 291;
                ballPOSx = 291;
                shotLEFT = false;
            }
            if (ballPOSx <= 97 && ballPOSy >= 263) {
                slopeRIGHT = true;
            }
            if (underGround) {
                delayTimer += speedX/2;
                ballPOSx = 290;
                ballPOSy = 233;
                if (PrevSpeedX > 0.1 && speedX <= 0.1) {
                    delayTimer = 0;
                }
                if (speedX <= 0.1) {
                    resetShot = false;
                    if (selection == 0) {Bonus = 1;}
                    if (selection == 1) {Bonus = -1;}
                    if (selection == 3) {Bonus = 2;}
                    if (selection == 4) {Bonus = -4;}
                    if (selection == 5) {
                        drop = true;
                        speedX = 0;
                        speedY = 0;
                        delayTimer = 0;
                        underGround = false;
                    }
                    if (selection == 6) {Bonus = 3;}
                    if (selection == 7) {Bonus = -3;}
                    if (selection == 9) {Bonus = 4;}
                    if (selection == 10) {Bonus = -4;}
                    if (selection == 12) {Bonus = 5;}
                    if (selection == 13) {Bonus = -5;}
                    if (selection == 15) {speedX = (float) random(10, 30);}
                    textAlign(CENTER, BOTTOM);
                    textSize(20);
                    delayTimer += 3;
                    fill(255, 255, 255, 255 - delayTimer);
                    text("Prize:  " + FortuneString[selection], 200f, 70f);
                    textAlign(LEFT, BOTTOM);
                    if (delayTimer >= 255) {
                        shotUP = true;
                        shotLEFT = false;
                        speedX = 3;
                        underGround = false;
                    }
                } else {
                    selection = round(delayTimer) % 16;
                }
            }
        }

        //Hole
        noStroke();
        fill(0, 0, 0, 100);
        if (!titleScreen && !endGame) {
            ellipse(holePOSx, holePOSy, 14, 14);
            ellipse(holePOSx, holePOSy, 10, 10);
        }
        if (dist(ballPOSx, ballPOSy, holePOSx, holePOSy) <= 10 - (speedX + speedY)/3 && speedX < 8 && speedY < 8 && !titleScreen && !endGame) {
            ballPOSx = holePOSx;
            ballPOSy = holePOSy;
            speedX = 0;
            speedY = 0;
            resetShot = false;
            fill(51, 39, 5);
            rect(eX + 10f, eY, 180f, 60f);
            rect(eX, eY + 10f, 200f, 40f);
            ellipse(eX + 10f, eY + 10f, 20f, 20f);
            ellipse(eX + 190f, eY + 10f, 20f, 20f);
            ellipse(eX + 10f, eY + 50f, 20f, 20f);
            ellipse(eX + 190f, eY + 50f, 20f, 20f);
            if ((mouseIsPressed || mouseJustReleased) && mouseX > eX + 20 && mouseX < eX + 180 && mouseY > eY && mouseY < eY + 60) {
                fill(150);
                if (mouseJustReleased) {
                    if (!LevelMenu) {
                        if(Level18){endGame=true;Level18 = false;}
                        else if(Level17){Level18 = true;Level17 = false;}
                        else if(Level16){Level17 = true;Level16 = false;}
                        else if(Level15){Level16 = true;Level15 = false;}
                        else if(Level14){Level15 = true;Level14 = false;}
                        else if(Level13){Level14 = true;Level13 = false;}
                        else if(Level12){Level13 = true;Level12 = false;}
                        else if(Level11){Level12 = true;Level11 = false;}
                        else if(Level10){Level11 = true;Level10 = false;}
                        else if(Level9){Level10 = true;Level9 = false;}
                        else if(Level8){Level9 = true;Level8 = false;}
                        else if(Level7){Level8 = true;Level7 = false;}
                        else if(Level6){Level7 = true;Level6 = false;}
                        else if(Level5){Level6 = true;Level5 = false;}
                        else if(Level4){Level5 = true;Level4 = false;}
                        else if(Level3){Level4 = true;Level3 = false;}
                        else if(Level2){Level3 = true;Level2 = false;}
                        else if(Level1){Level2 = true;Level1 = false;}
                        if (LevelSelect < 17) {
                            LevelSelect += 1;
                        }
                        drop = true;
                    } else {
                        titleScreen = true;
                        Level1 = false;
                        Level2 = false;
                        Level3 = false;
                        Level4 = false;
                        Level5 = false;
                        Level6 = false;
                        Level7 = false;
                        Level8 = false;
                        Level9 = false;
                        Level10 = false;
                        Level11 = false;
                        Level12 = false;
                        Level13 = false;
                        Level14 = false;
                        Level15 = false;
                        Level16 = false;
                        Level17 = false;
                        Level18 = false;
                        drop = true;
                    }
                    textDiminish = 255;
                    mouseJustReleased = false;
                }
            } else {
                fill(60);
            }
            textSize(32);
            text("Next Hole", eX + 15f, eY + 48f);
            triangle(eX + 165f, eY + 40f, eX + 165f, eY + 20f, eX + 180f, eY + 30f);
            textSize(12);

        }

        //drop
        strokeWeight(1);
        if (LevelStart) {
            drop = true;
            shot = false;
            LevelStart = false;
        }
        if (drop && mouseY > 50) {
            ballPOSx = mouseX;
            ballPOSy = mouseY;
            if (ballPOSx <= dX1 + 3) {
                ballPOSx = dX1 + 3;
            }
            else if (ballPOSx >= dX2 - 3) {
                ballPOSx = dX2 - 3;
            }
            if (ballPOSy <= dY1 + 3) {
                ballPOSy = dY1 + 3;
            }
            else if (ballPOSy >= dY2 - 3) {
                ballPOSy = dY2 - 3;
            }
            fill(0);
            if (!titleScreen && !endGame && !ScoreDisplay) {
                text(mouseIsPressed ? "drop" : "", mouseX - 12f, mouseY - 30f);
                if (mouseJustReleased) {
                    drop = false;
                }
            }
        }
        else if (!drop) {
            if (resetShot && !water && !titleScreen && !endGame && (mouseIsPressed || mouseJustReleased)) {
                stroke(0);
                fill(0);
                ellipse(mouseX - 5f, mouseY, 10f, 4f);
                line(mouseX - 8f, mouseY, mouseX - 11f, mouseY - 20f);
                shot = true;
                if (mouseX > ballPOSx) {
                    shotLEFT = true;
                    dotx = -powerX;
                } else {
                    shotLEFT = false;
                    dotx = powerX;
                }
                if (mouseY > ballPOSy) {
                    shotUP = true;
                    doty = -powerY;
                } else {
                    shotUP = false;
                    doty = powerY;
                }
                stroke(234, 234, 0);
                strokeWeight(5);
                for (int  dotRep = 1; dotRep < 6; dotRep += 1) {
                    point(ballPOSx + dotRep * dotx/4, ballPOSy + dotRep * doty/4);
                }
            }
        }

        //Ball
        strokeWeight(1);
        if (Level17) {
            stroke((int) (200 - delayTimer * 20));
            fill((int) (255 - delayTimer * 25.5));
        } else {
            stroke(200);
            fill(255);
        }
        if (!underGround && !underWater && !titleScreen && !endGame && ((mouseIsPressed && mouseY > 50) || !drop)) {
            ellipse(ballPOSx, ballPOSy, 6, 6);
        }

        //Water
        if (water) {
            if (speedX < 15 && speedY < 15) {
                underWater = true;
            }
            if (speedX > 15) {
                speedX = 15;
            }
            if (speedY > 15) {
                speedY = 15;
            }
        }
        if (underWater) {
            waterTime += 1;
            speedX = 0;
            speedY = 0;
            noFill();
            for(int  wRep = 0; wRep < 30; wRep += 10) {
                if (waterTime >= wRep) {
                    stroke(80, 150, 205, 255 + wRep * 5 - waterTime * 10);
                    ellipse(ballPOSx, ballPOSy, (float) (waterTime * 1.5 - wRep), (float) (waterTime * 1.5 - wRep));
                }
            }
            if (waterTime >= 60) {
                water = false;
                underWater = false;
                drop = true;
            }
        } else {
            waterTime = 0;
        }

        //Bunker
        if (bunker) {
            speedX = speedX / 2;
            speedY = speedY / 2;
        }

        //Score Display
        if (mouseJustReleased && mouseX > 150 && mouseX < 250 && mouseY <= 35 && !titleScreen) {
            ScoreDisplay = true;
            mouseJustReleased = false;
        }
        if (ScoreDisplay && dY < 80) {
            dY += 8;
        }
        if (mouseJustReleased && mouseY > 80 && !endGame && ScoreDisplay) {
            dY = 0;
            ScoreDisplay = false;
            mouseJustReleased = false;
        }
        if (titleScreen) {
            ScoreDisplay = false;
        }
        fill(185);
        noStroke();
        rect(0f, dY - 80f, 400f, 80f);
        fill(175);
        quad(0f, dY - 80f, 0f, dY, 5f, dY - 5f, 5f, dY - 75f);
        quad(400f, dY - 80f, 400f, dY, 395f, dY - 5f, 395f, dY - 75f);
        fill(200);
        quad(0f, dY - 80f, 5f, dY - 75f, 395f, dY - 75f, 400f, dY - 80f);
        quad(0f, dY, 5f, dY - 5f, 395f, dY - 5f, 400f, dY);
        fill(185);
        stroke(100);
        strokeWeight(1);
        if (!titleScreen) {
            quad(170f, dY, 182f, dY + 7f, 218f, dY + 7f, 230f, dY);
            line(0f, dY - 1f, 400f, dY - 1f);
        }
        stroke(0);
        strokeWeight(3);
        noFill();
        //Restart
        if (!titleScreen && !endGame) {
            arc(18f, dY + 18f, 22f, 22f, 120f, 240f);
            arc(18f, dY + 18f, 22f, 22f, -60f, 60f);
            noStroke();
            if (Level18 && !endGame) {
                fill(255, 0, 0);
                quad(5f, 5f + dY, 10f, 5f + dY, 32f, 30f + dY, 27f, 30f + dY);
                quad(5f, 30f + dY, 10f, 30f + dY, 32f, 5f + dY, 27f, 5f + dY);
            }
            fill(0);
            triangle(14f, dY + 31f, 14f, dY + 24f, 20f, dY + 28f);
            triangle(22f, dY + 12f, 22f, dY + 5f, 16f, dY + 8f);
        }
        textSize(10);
        if ((mouseIsPressed || mouseJustReleased) && dist(mouseX, mouseY, 18, dY + 18) <= 11 && !titleScreen && !Level18) {
            fill(0);
            if (!drop) {
                text("Restart Hole", 5f, dY + 42f);
            }
            if (mouseJustReleased) {
                drop = true;
                speedX = 0;
                if(Level1){L1S = 0;}
                else if(Level2){L2S = 0;}
                else if(Level3){L3S = 0;}
                else if(Level4){L4S = 0;}
                else if(Level5){L5S = 0;}
                else if(Level6){L6S = 0;}
                else if(Level7){L7S = 0;}
                else if(Level8){L8S = 0;}
                else if(Level9){L9S = 0;}
                else if(Level10){L10S = 0;}
                else if(Level11){L11S = 0;}
                else if(Level12){L12S = 0;}
                else if(Level13){L13S = 0;}
                else if(Level14){L14S = 0;}
                else if(Level15){L15S = 0;}
                else if(Level16){L16S = 0;}
                else if(Level17){L17S = 0;}
                else if(Level18){L18S = 0;}
                linePOS = 0;
                restart += 1;
                speedX = 0;
                speedY = 0;
                textDiminish = 255;
                delayTimer = 0;
                underGround = false;
            }
        }
        if (!titleScreen && !endGame) {
            if (restart > 0) {
                text(restart, 35f, dY + 23f);
            }
            textSize(12);
            text("Hole " + (LevelSelect + 1), 45f, dY + 18f);
            text("Par  " + Par[LevelSelect], 280f, dY + 18f);
            text("Strokes " + LS[LevelSelect], 330f, dY + 18f);
        }
        noFill();
        stroke(100);
        strokeWeight(2);
        rect(15f, dY - 70f, 306, 60f);
        line(15f, dY - 40f, 321f, dY - 40f);
        stroke(100);
        rect(362f, dY - 70f, 30f, 30f);
        for(int  lRep = 32; lRep < 311; lRep += 17) {
            line(lRep, dY - 70f, lRep, dY - 11f);
        }
        textSize(18);
        fill(75);
        textAlign(CENTER, BOTTOM);
        text(ParSum[LevelSelect], 336f, dY - 15f);
        text(LST, 336f, dY - 45f);
        text(LST - ParSum[LevelSelect],  377f, dY - 45f);
        textAlign(LEFT, BOTTOM);
        for(int sRep = 0; sRep < 18; sRep += 1) {
            if (LevelSelect == sRep) {
                fill(255, 0, 0);
            } else {
                fill(75);
            }
            if (LS[sRep] > 0) {
                text(LS[sRep], 19f + sRep * 17f, dY - 45f);
            }
            fill(75);
            if (LevelSelect >= sRep) {
                text(Par[sRep], 19f + sRep * 17f, dY - 15f);
            }
            textSize(9);
            text(sRep + 1, 19f + sRep * 17f, dY - 70f);
            textSize(18);
        }
        noFill();
        stroke(255, 0, 0);
        rect(15f + LevelSelect * 17f, dY - 70f, 17f, 60f);
        stroke(0, 0, 255);
        rect(321f, dY - 70f, 30f, 60f);
        line(321f, dY - 40f, 350f, dY - 40f);
        fill(75);
        textSize(9);
        pushMatrix();
        translate(12, dY - 32);
        rotate(-90);
        text("STROKES", 0f, 0f);
        text("PAR", -23f, 0f);
        popMatrix();
        text("SCORE", 361f, dY - 28f);
        strokeWeight(1);
        textSize(13);


        fill(255, 255, 255, textDiminishB);
        text(alertText, 20f, 380f);
        if (textDiminishB > 0) {
            textDiminishB -= 5;
        }

        //Slopes
        if (slopeLEFT) {
            slopeRIGHT = false;
            if (speedX > 0 && !shotLEFT) {
                speedX -= 0.3;
                if (speedX <= 1) {
                    shotLEFT = true;
                }
            }
            if (shotLEFT) {
                speedX += grav/8;
                if (grav < 20) {
                    grav *= 1.05;
                }
            }
            slopeX = true;
        }
        else if (slopeRIGHT) {
            slopeLEFT = false;
            if (speedX > 0 && shotLEFT) {
                speedX -= 0.3;
                if (speedX <= 1) {
                    shotLEFT = false;
                }
            }
            if (!shotLEFT) {
                speedX += grav/8;
                if (grav < 20) {
                    grav *= 1.05;
                }
            }
            slopeX = true;
        }
        if (slopeUP) {
            slopeDOWN = false;
            if (speedY > 0 && !shotUP) {
                speedY -= 0.3;
                if (speedY <= 1) {
                    shotUP = true;
                }
            }
            if (shotUP) {
                speedY += grav/8;
                if (grav < 20) {
                    grav *= 1.05;
                }
            }
            slopeY = true;
        }
        else if (slopeDOWN) {
            slopeUP = false;
            if (speedY > 0 && shotUP) {
                speedY -= 0.3;
                if (speedY <= 1) {
                    shotUP = false;
                }
            }
            if (!shotUP) {
                speedY += grav/8;
                if (grav < 20) {
                    grav *= 1.05;
                }
            }
            slopeY = true;
        }
        if (!slopeX && !slopeY) {
            grav = 1;
        }
        else if (!PrevSlopeX && slopeX) {
            grav = 1;
        }
        else if (!PrevSlopeY && slopeY) {
            grav = 1;
        }
        if (!slopeX) {
            slopeLEFT = false;
            slopeRIGHT = false;
        }
        if (!slopeY) {
            slopeUP = false;
            slopeDOWN = false;
        }
        if (underGround && Level18  && selection != 15) {
            if (PrevSpeedX < speedX) {
                speedX = PrevSpeedX;
            }
        }
        PrevSlopeX = slopeX;
        PrevSlopeY = slopeY;
        PrevSpeedX = speedX;
        oldX = ballPOSx;
        oldY = ballPOSy;

        String[] tipString = {
                "If you're backed up against a wall and can't draw\nback far enough, aim the other way for a rebound.",
                "Slope affects your ball's speed. If the hole is at the top of\na slope, draw farther back to get the necessary extra power\nand get your ball up the hill.",
                "Use the walls to your advantage. If there is no straight\nshot, go for the rebound and try for the hole in one.",
                "If you are having trouble with a hole, try short, controlled\nshots to get to the hole, then restart the hole and see if you\ncan replicate that with fewer putts.",
                "Click on the score card tab a the top of\nthe screen to check your progress while you play.",
                "Don't go into bunkers; they stop your ball almost immediately\nand are very difficult to get out of. Treat them with caution.",
                "Slopes can come in handy when trying to get the ball\naround a corner, but they can also slow the ball down or\nsend it backwards, so aim carefully.",
                "Water will reset your ball without resetting\nyour strokes, so avoid it at all costs."
        };


        if (titleScreen) {
            pushMatrix();
            final String[] splashText = "10,000+ votes!".split("");
            textAlign(LEFT, CENTER);
            textSize(25);
            String splashPart = "";
            translate(200f, 55 - tY - tS);
            for (String txt : splashText) {
                fill(0, 0, 0, 100);
                text(txt, -textWidth("") / 2f + textWidth(splashPart) + 3f, 2f);
                fill((int) (200 - sin(frameCount) * 55), (int) (200 + cos(frameCount) * 55), (int) (200 + sin(frameCount) * 55));
                text(txt, -textWidth("") / 2f + textWidth(splashPart), 0f);
                splashPart += txt;
            }
            popMatrix();
            resetShot = false;
            if (mouseIsPressed && mouseX > 170 && mouseX < 230 && mouseY >= 323 + tS && mouseY <= 335 + tS && titleScreen) {
                if (!tipDisplay) {
                    tipSelect = round(random(-0.49, tipString.length - 0.51));
                }
                tipDisplay = true;
            }
            if (tipDisplay && tY < 30) {
                tY += 8;
            }
            if (mouseIsPressed && mouseY < 283 + tS) {
                tY = 0;
                tipDisplay = false;
            }
            if (mouseIsPressed && mouseY > 370 + tS) {
                tY = 0;
                tipDisplay = false;
            }
            stroke(125);
            fill(185);
            quad(170f, 323f + tS + tY - 1, 182f, 330f + tS + tY - 1, 218f, 330f + tS + tY - 1, 230f, 323f + tS + tY - 1);
            noStroke();
            rect(50f, 258f + tS + tY - 1, 300f, 65f);
            fill(175);
            quad(50f, 258f + tS + tY - 1, 55f, 263f + tS + tY - 1, 55f, 318f + tS + tY - 1, 50f, 323f + tS + tY - 1);
            quad(350f, 258f + tS + tY - 1, 345f, 263f + tS + tY - 1, 345f, 318f + tS + tY - 1, 350f, 323f + tS + tY - 1);
            fill(200);
            quad(50f, 258f + tS + tY - 1, 55f, 263f + tS + tY - 1, 345f, 263f + tS + tY - 1, 350f, 258f + tS + tY - 1);
            quad(50f, 323f + tS + tY - 1, 55f, 318f + tS + tY - 1, 345f, 318f + tS + tY - 1, 350f, 323f + tS + tY - 1);
            textAlign(CENTER, CENTER);
            textSize(10);
            fill(0);
            text(tipString[tipSelect], 200f, 290f + tS + tY);

            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 80f - tS - tY, 300f, 240f + tS * 2f);
            fill(130, 83, 3);
            strokeWeight(4);
            stroke(59, 39, 11);
            rect(155f, 160f - tS - tY, 90f, 30f);
            rect(150f, 200f - tS - tY, 100f, 30f);
            fill(41, 23, 0);
            textSize(52);
            text("MINI PUTT", 200f, 120f - tS - tY);
            textSize(54);
            fill(122, 82, 1);
            text("MINI PUTT", 200f, 120f - tS - tY);
            fill(255);
            textSize(56);
            text("MINI PUTT", 200f, 120f - tS - tY);
            textSize(12);
            fill(168, 113, 2);
            textAlign(RIGHT, BOTTOM);
            text("Originally created by Matt on Khan Academy", 395f, 395f);
            textAlign(CENTER, CENTER);
            if ((mouseIsPressed || mouseJustReleased) && mouseX >= 155 && mouseX <= 245 && mouseY >= 160 - tS - tY && mouseY <= 190 - tS - tY) {
                if (mouseJustReleased) {
                    titleScreen = false;
                    Level1 = true;
                    drop = true;
                    LevelMenu = false;
                }
                fill(255);
            } else {
                fill(179, 135, 69);
            }
            textSize(19);
            text("START", 191f, 175f - tS - tY);
            noStroke();
            triangle(227f, 168f - tS - tY, 240f, 175f - tS - tY, 227f, 182f - tS - tY);
            if ((mouseIsPressed || mouseJustReleased) && mouseX >= 123 && mouseX <= 160 && mouseY >= 193 - tS - tY && mouseY <= 237 - tS - tY) {
                fill(255);
                if (mouseJustReleased) {
                    if(tips){onOffString="OFF";tips=false;}
                    else{onOffString="ON";tips=true;}
                }
            } else {
                fill(130, 83, 3);
            }
            triangle(145f, 207f - tS - tY, 145f, 222f - tS - tY, 138f, 215f - tS - tY);
            if ((mouseIsPressed || mouseJustReleased) && mouseX >= 240 && mouseX <= 277 && mouseY >= 193 - tS && mouseY <= 237 - tS - tY) {
                fill(255);
                if (mouseJustReleased) {
                    if(tips){onOffString="OFF";tips=false;}
                    else{onOffString="ON";tips=true;}
                }
            } else {
                fill(130, 83, 3);
            }
            triangle(255f, 207f - tS - tY, 255, 222f - tS - tY, 262f, 215f - tS - tY);
            fill(255);
            text("TIPS " + onOffString, 200f, 215f - tS - tY);
            int[] code = {6, 1, 4};
            if (!LevelMenu) {
                for (int  sRep = 0; sRep < 3; sRep += 1) {
                    fill(130, 83, 3);
                    stroke(59, 39, 11);
                    rect(127f + sRep * 60f, 255f - tY, 25f, 25f);
                    noStroke();
                    if ((mouseIsPressed || mouseJustReleased) && mouseX >= 110 + sRep * 60 && mouseX <= 127 + sRep * 60 && mouseY >= 250 - tY && mouseY <= 285 - tY) {
                        fill(255);
                        if (mouseJustReleased) {
                            if(sRep==0){
                                if(a>0){
                                    a-=1;
                                }else{
                                    a=9;
                                }
                            }
                            if(sRep==1){
                                if(b>0){
                                    b-=1;
                                }else{
                                    b=9;
                                }
                            }
                            if(sRep==2){
                                if(c>0){
                                    c-=1;
                                }else{
                                    c=9;
                                }
                            }
                        }
                    } else {
                        fill(130, 83, 3);
                    }
                    triangle(122f + sRep * 60f, 260f - tY, 122f + sRep * 60f, 275f - tY, 115f + sRep * 60f, 268f - tY);
                    if ((mouseIsPressed || mouseJustReleased) && mouseX >= 152 + sRep * 60 && mouseX <= 169 + sRep * 60 && mouseY >= 250 - tY && mouseY <= 285 - tY) {
                        fill(255);
                        if (mouseJustReleased) {
                            if(sRep==0){if(a<9){a+=1;}else{a=0;}}
                            if(sRep==1){if(b<9){b+=1;}else{b=0;}}
                            if(sRep==2){if(c<9){c+=1;}else{c=0;}}
                        }
                    } else {
                        fill(130, 83, 3);
                    }
                    triangle(157f + sRep * 60f, 260f - tY, 157f + sRep * 60f, 275f - tY, 164f + sRep * 60f, 268f - tY);
                }
                fill(255);
                text(a, 139f, 268f - tY);
                text(b, 199f, 268f - tY);
                text(c, 259f, 268f - tY);
                fill(130, 83, 3);
                stroke(59, 39, 11);
                rect(162f, 288f - tY, 76f, 30f);
                if ((mouseIsPressed || mouseJustReleased) && mouseX >= 162 && mouseX <= 238 && mouseY >= 288 - tY && mouseY <= 318 - tY) {
                    fill(255);
                    if (a == code[0] && b == code[1] && c == code[2] && mouseJustReleased) {
                        LevelMenu = true;
                        tS = 35;
                    }
                } else {
                    fill(179, 135, 69);
                }
                text("ENTER", 200f, 302f - tY);
                fill(130, 83, 3);
                textSize(12);
                text("Unlock Level Select", 200f, 244f - tY);
            } else {
                for (int  lRep = 0; lRep < 3; lRep += 1) {
                    for (int  mRep = 0; mRep < 6; mRep += 1) {
                        fill(130, 83, 3);
                        stroke(59, 39, 11);
                        rect(60f + mRep * 50f, 215f + lRep * 50f - tY, 30f, 30f);
                        if ((mouseIsPressed || mouseJustReleased) && mouseX >= 60 + mRep * 50 && mouseX <= 90 + mRep * 50 && mouseY >= 215 + lRep * 50 - tY && mouseY <= 245 + lRep * 50 + tY) {
                            fill(255);
                            if (mouseJustReleased) {
                                if(mRep+1+lRep*6==1){Level1=true;LevelSelect=0;}
                                if(mRep+1+lRep*6==2){Level2=true;LevelSelect=1;}
                                if(mRep+1+lRep*6==3){Level3=true;LevelSelect=2;}
                                if(mRep+1+lRep*6==4){Level4=true;LevelSelect=3;}
                                if(mRep+1+lRep*6==5){Level5=true;LevelSelect=4;}
                                if(mRep+1+lRep*6==6){Level6=true;LevelSelect=5;}
                                if(mRep+1+lRep*6==7){Level7=true;LevelSelect=6;}
                                if(mRep+1+lRep*6==8){Level8=true;LevelSelect=7;}
                                if(mRep+1+lRep*6==9){Level9=true;LevelSelect=8;}
                                if(mRep+1+lRep*6==10){Level10=true;LevelSelect=9;}
                                if(mRep+1+lRep*6==11){Level11=true;LevelSelect=10;}
                                if(mRep+1+lRep*6==12){Level12=true;LevelSelect=11;}
                                if(mRep+1+lRep*6==13){Level13=true;LevelSelect=12;}
                                if(mRep+1+lRep*6==14){Level14=true;LevelSelect=13;}
                                if(mRep+1+lRep*6==15){Level15=true;LevelSelect=14;}
                                if(mRep+1+lRep*6==16){Level16=true;LevelSelect=15;}
                                if(mRep+1+lRep*6==17){Level17=true;LevelSelect=16;}
                                if(mRep+1+lRep*6==18){Level18=true;LevelSelect=17;}
                                titleScreen = false;
                            }
                        } else {
                            fill(179, 135, 69);
                        }
                        text(mRep + 1 + lRep * 6, 75f + mRep * 50f, 230f + lRep * 50f - tY);
                    }
                }
            }
        }
        else if (endGame) {
            resetShot = false;
            textAlign(CENTER, CENTER);
            fill(30, 168, 2);
            strokeWeight(5);
            stroke(173, 116, 2);
            rect(50f, 80f, 300f, 240f);
            fill(130, 83, 3);
            strokeWeight(4);
            stroke(59, 39, 11);
            rect(100f, 92f, 200f, 50f);
            rect(100f, 150f, 200f, 110f);
            textSize(12);
            text((LST - ParSum[LevelSelect] + Bonus) < -9 && restart == 0 ? "The code to unlock\nLevel Select is (6, 1, 4)." : "You must get a score of\n-10 or less with no restarts to be\nshown the Unlock Level Select code", 200f, 290f);
            fill(255);
            textSize(35);
            text("Game Over", 200f, 115f);
            textSize(15);
            if (!UsedCommands) {
                text("Bonus = " + (int) Bonus + "\n(negative is better)", 200f, 173f);
                text("Score = " + (int) (LST - ParSum[LevelSelect] + Bonus) + "\n(including bonus)", 200f, 212f);
                text("Restarts =  " + restart, 200f, 245f);
            } else {
                text("No Score; Used Commands", 200f, 200f);
            }
            if (textDiminish > 0) {
                textDiminish -= 10;
            } else {
                textDiminish = 255;
            }
            if (dY == 0) {
                fill(255, 255, 0, textDiminish);
                textSize(12);
                text("^Score Card^", 200f, 15f);
            }
            canvas.save();
            translate(364f, 364f);
            textAlign(RIGHT, CENTER);
            fill(255, 255, 0);
            textSize(11f);
            text("Restart ENTIRE game -->", 0f, 18f);
            stroke(0);
            strokeWeight(3f);
            noFill();
            arc(18f, 18f, 22f, 22f, 120f, 240f);
            arc(18f, 18f, 22f, 22f, -60f, 60f);
            fill(0);
            triangle(14f, 31f, 14f, 24f, 20f, 28f);
            triangle(22f, 12f, 22f, 5f, 16f, 8f);
            canvas.restore();
            if (mouseJustReleased && mouseX > 364 && mouseY > 364) {
                restartProgram();
            }
        }
    }
}
