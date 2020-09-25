package com.codepath.eric.flixster.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.eric.flixster.R;
import com.codepath.eric.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    // We need context in order to inflate a view
    Context context;
    List<Movie> movies;

    // Need to create a constructor
    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }


    // Usually involves inflating a layout from XML and returning holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d("MovieAdapter", "onCreateViewHolder ");
        // We take in a context and inflate the item movie xml
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        // returns a view to us and wrap it inside of a View Holder
        return new ViewHolder(movieView);
    }

    // Involves populating data into the item through holder.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter", "onBindViewHolder " + position);
        // Get the movie at the passed in position
        Movie movie = movies.get(position);
        // Bind the movie data into the View Holder
        holder.bind(movie);
    }

    // Returns the total count of items in the list.
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);


        }

        // Use the getters methods to populate movies from the movies array (JSON)
        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            String imageUrl;
            // If phone is in landscape
            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                imageUrl = movie.getBackdropPath();
            }
            else
            {
                imageUrl = movie.getPosterPath();
            }
            // then imageUrl = backdrop image

            // else imageUrl = poster image

            Glide.with(context).load(imageUrl).into(ivPoster);

        }
    }
}
