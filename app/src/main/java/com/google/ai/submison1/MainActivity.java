package com.google.ai.submison1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[]    dataName;
    private String[]    dataDescription;
    private TypedArray  dataPhoto;
    private ArrayList<Film> films;



    private FilmAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);

        final ListView list = findViewById(R.id.List_View);
        list.setAdapter(adapter);

        prepare();
        addItem();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final Film film = films.get(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable(Detail_activity.IMG_PHOTO, film);
                Intent moveWithDataIntent = new Intent(view.getContext(), Detail_activity.class);
                moveWithDataIntent.putExtras(bundle);
                view.getContext().startActivity(moveWithDataIntent);
            }
        });
    }
    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_nama);
        dataDescription = getResources().getStringArray(R.array.data_discription);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private  void addItem(){
        films = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Film film = new Film();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setNama(dataName[i]);
            film.setDiskripsi(dataDescription[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }

}
