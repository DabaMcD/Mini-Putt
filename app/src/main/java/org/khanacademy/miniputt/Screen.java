package org.khanacademy.miniputt;

import android.util.DisplayMetrics;
import android.view.WindowManager;

public class Screen {
    public static int width;
    public static int height;

    public static void setScreenDims(WindowManager wm) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
    }
}
