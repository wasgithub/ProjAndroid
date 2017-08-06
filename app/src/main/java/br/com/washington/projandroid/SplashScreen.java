package br.com.washington.projandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    //tempo que a splash screen ficara visivel
    private final int SPLASH_DISPLAY_LENGHT = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //executa o metodo que executara nossa animaçao
        carregar();
    }

    private void carregar() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animacao_splash);

        //Pegando nosso objeto criado no layout
        ImageView iv = (ImageView)findViewById(R.id.splash);
        if (iv != null){
            iv.clearAnimation();
            iv.startAnimation(anim);
        }
    }
}
