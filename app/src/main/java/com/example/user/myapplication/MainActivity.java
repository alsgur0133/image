package com.example.user.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import net.alhazmy13.imagefilter.ImageFilter;

public class MainActivity extends AppCompatActivity {
Context context;
Bitmap mbitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
         mbitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image);
        Button button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranStatus tranStatus = new TranStatus();
                tranStatus.execute();
            }
        } );
    }
    class TranStatus extends AsyncTask<String, Void, String>{
    ProgressDialog asyProgressDialog = new ProgressDialog(context);


        @Override
        protected String doInBackground(String... strings) {
            for (int i=0;i<5; i++){
                asyProgressDialog.setProgress(i+30);
                try{
                    Thread.sleep(500);

                }catch(Exception e){
                    Log.e("TAG", e.toString());
                }

            }
            return null;
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            asyProgressDialog.dismiss();
        }
        @Override
        protected void onPreExecute(){
            asyProgressDialog.setProgress(ProgressDialog.STYLE_SPINNER);
            asyProgressDialog.setMessage("변환중입니다");
            Bitmap bm = ImageFilter.applyFilter(mbitmap, ImageFilter.Filter.SKETCH);
            ImageView iv = (ImageView)findViewById(R.id.imageView3);
            iv.setImageBitmap(bm);
            asyProgressDialog.show();
            super.onPreExecute();
        }

    }
}
