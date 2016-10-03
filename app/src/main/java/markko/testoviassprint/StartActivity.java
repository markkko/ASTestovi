package markko.testoviassprint;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;

public class StartActivity extends AppCompatActivity {

    private MainActivity ma;
    static ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baner);

        imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setAlpha(0x00);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setAlpha(0x40);
            }
        }, 300);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 600);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setAlpha(0x80);
            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setAlpha(0xBF);
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setAlpha(0xFF);
            }
        }, 2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_start);
            }
        }, 4500);
    }



    public void onClickA (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("test", 1);
        startActivity(intent);
        finish();
    }
    public void onClickB (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("test", 2);
        startActivity(intent);
        finish();
    }
    public void onClickC (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("test", 3);
        startActivity(intent);
        finish();
    }
}
