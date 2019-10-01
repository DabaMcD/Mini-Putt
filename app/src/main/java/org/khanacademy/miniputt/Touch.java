package org.khanacademy.miniputt;

import android.view.MotionEvent;
import android.view.View;

class Touch {
    static void setTouchListener(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: // When user's finger touches screen
                        GameCode.mouseIsPressed = true;
                        break;
                    case MotionEvent.ACTION_MOVE: // When user's finger drags across screen
                        break;
                    case MotionEvent.ACTION_UP: // When user's finger is picked up off screen
                        GameCode.mouseIsPressed = false;
                        GameCode.mouseJustReleased = false;
                        break;
                }
                return true;
            }
        });
    }
}
