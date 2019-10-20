package com.google.ai.submison1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail_activity extends AppCompatActivity {

    public  static final String IMG_PHOTO      = "PHOTO_FILM" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);
        ImageView    imgPhoto =findViewById(R.id.img_item_photo);
        TextView tvName   = findViewById(R.id.tv_item_name);
        TextView tvDesc   = findViewById(R.id.tv_item_deskripsi);

        Bundle bundle = getIntent().getExtras();

        Film film = (Film) bundle.getParcelable(IMG_PHOTO);




        tvName.setText(film.getNama());
        tvDesc.setText(film.getDiskripsi());
        Log.d("hh",""+film.getPhoto());
        imgPhoto.setImageResource(film.getPhoto());
        if (getSupportActionBar() != null ){
            getSupportActionBar().setTitle(film.getNama());
        }

    }
}