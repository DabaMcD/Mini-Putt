package org.khanacademy.miniputt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Thread thread;
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameView = findViewById(R.id.gameView);

        startMainThread();
    }
    private void startMainThread() {
        thread = new Thread() {
            public void run() {
                while (true) {
                    long previousMillis = System.currentTimeMillis();
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                gameView.draw();
                            }
                        });
                        Thread.sleep(Math.abs(previousMillis - System.currentTimeMillis() + 30));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}
