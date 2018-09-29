package com.example.user.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import net.alhazmy13.imagefilter.ImageFilter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image);
        Button button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bm= ImageFilter.applyFilter(bitmap, ImageFilter.Filter.SKETCH);
                ImageView iv = findViewById(R.id.imageView3);
                iv.setImageBitmap(bm);
            }
        } );
    }
}
