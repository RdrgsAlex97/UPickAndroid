package com.example.alex.upick.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.upick.Models.Music;
import com.example.alex.upick.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerFavListMusicAdapter extends RecyclerView.Adapter<RecyclerFavListMusicAdapter.MyViewHolder> {
    private List<Music> musicList;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView img,fav;
        public TextView music,autor,time;

        public MyViewHolder(View view){
            super(view);
            img = view.findViewById(R.id.img);
            music = view.findViewById(R.id.music);
            autor = view.findViewById(R.id.autor);
            time = view.findViewById(R.id.time);
            fav = view.findViewById(R.id.btn_fav_favorites);
        }
    }

    public RecyclerFavListMusicAdapter(List<Music> musicList) {
        this.musicList = musicList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recycler_music_favorites,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Music music = musicList.get(position);
        Picasso.get().load(music.getImg()).into(holder.img);
        holder.autor.setText(music.getAutor());
        holder.music.setText(music.getNome());
        holder.time.setText(music.getTime());
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }
}

