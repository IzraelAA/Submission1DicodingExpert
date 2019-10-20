package com.google.ai.submison1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {

    private Context         context;
    private ArrayList<Film> films;

void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

 FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }

    @Override
    public int getCount( ) {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false);
        }

        ViewHolder viewh = new ViewHolder(view);
        Film       film  = (Film) getItem(i);
        viewh.bind(film);
        return view;
    }
        private class ViewHolder {
            private TextView Film, Deskripsi;
            private ImageView img;
            private ListView list;

            ViewHolder(final View view) {
                Film = view.findViewById(R.id.txt_name);
                Deskripsi = view.findViewById(R.id.txt_description);
                img = view.findViewById(R.id.img_photo);
                list = view.findViewById(R.id.List_View);
            }

            void bind(Film film) {
                Film.setText(film.getNama());
                Deskripsi.setText(film.getDiskripsi());
                img.setImageResource(film.getPhoto());
            }
        }
    }
