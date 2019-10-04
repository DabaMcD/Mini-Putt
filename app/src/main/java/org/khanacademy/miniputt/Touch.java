package org.khanacademy.miniputt;

import android.view.MotionEvent;
import android.view.View;

class Touch {
    static void setTouchListener(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.performClick();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: // When user's finger touches screen
                        GameCode.setMouseIsPressed(true);
                        break;
                    case MotionEvent.ACTION_UP: // When user's finger is picked up off screen
                        GameCode.setMouseIsPressed(false);
                        GameCode.setMouseJustReleased(true);
                        break;
                }
                GameCode.setMouseX(event.getX());
                GameCode.setMouseY(event.getY());
                return true;
            }
        });
    }
}
