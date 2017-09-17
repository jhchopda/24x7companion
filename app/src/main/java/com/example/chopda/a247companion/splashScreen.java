package com.example.chopda.a247companion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import gr.net.maroulis.library.EasySplashScreen;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config= new EasySplashScreen(splashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withLogo(R.mipmap.ic_launcher)
                .withAfterLogoText(getString(R.string.app_name));

        //config.getLogo().setMinimumWidth(150);
        config.getLogo().getLayoutParams().height=150;
        config.getLogo().getLayoutParams().width=150;
        config.getLogo().setScaleType(ImageView.ScaleType.FIT_XY);
        config.getLogo().requestLayout();

/*
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
        config.getLogo().setLayoutParams(layoutParams);
*/
        config.getAfterLogoTextView().setAllCaps(true);

        View view= config.create();

        setContentView(view);
    }
}
