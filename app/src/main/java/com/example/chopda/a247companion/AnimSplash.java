package com.example.chopda.a247companion;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class AnimSplash extends AppCompatActivity {

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    Thread SplashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_splash);
        startAnimations();
    }

    public void startAnimations(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        ImageView logo=(ImageView) findViewById(R.id.animIcon);
        logo.clearAnimation();
        logo.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        RelativeLayout text = (RelativeLayout) findViewById(R.id.text);
        text.clearAnimation();
        text.startAnimation(anim);

        SplashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(AnimSplash.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    AnimSplash.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    AnimSplash.this.finish();
                }

            }
        };
        SplashThread.start();
    }
}
