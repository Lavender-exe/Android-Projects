package com.example.recyclerview;

import static com.example.recyclerview.R.id.recyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        movieAdapter = new MovieAdapter();

        setSampleMovieData();
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(movieAdapter);
    }

    private class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

        @NonNull
        @Override
        public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.movie_list_row,parent,false);

            return new MovieViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
            Movie movie = movieList.get(position);

            holder.tvMovieName.setText(movie.getMovieName());
            holder.tvMovieGenre.setText(movie.getMovieGenre());
            holder.tvMovieYear.setText(movie.getMovieYear() + "");
            int resID = getResources().getIdentifier(movie.getMovieImageName(), "drawable", getPackageName());
            holder.ivMovieImageName.setImageResource(resID);
        }

        @Override
        public int getItemCount() {
            if (movieList.size() > 0)
                return movieList.size();
            else
                return 0;
        }

        public class MovieViewHolder extends RecyclerView.ViewHolder {

            private TextView tvMovieName;
            private TextView tvMovieGenre;
            private TextView tvMovieYear;
            private ImageView ivMovieImageName;
            public MovieViewHolder(@NonNull View itemView) {
                super(itemView);

                tvMovieName = itemView.findViewById(R.id.tvMovieName);
                tvMovieGenre = itemView.findViewById(R.id.tvMovieGenre);
                tvMovieYear = itemView.findViewById(R.id.tvMovieYear);
                ivMovieImageName = itemView.findViewById(R.id.ivMovieImage);
            }
        }
    }

    private void setSampleMovieData(){
        Movie movie = new Movie("Black Mirror",
                "Action",
                2011, "blackmirror");
        movieList.add(movie);
//
        movie = new Movie("Dracula",
                "Horror",
                1931, "dracula");
        movieList.add(movie);
//
        movie = new Movie("Glass Onion",
                "Comedy",
                2022, "glassonion");
        movieList.add(movie);
//
        movie = new Movie("Hardcore Henry",
                "Action",
                2015, "hardcorehenry");
        movieList.add(movie);
//
        movie = new Movie("Her",
                "Romance",
                2013, "her");
        movieList.add(movie);
//
        movie = new Movie("Jurassic Park",
                "Action",
                1993, "jurassicpark");
        movieList.add(movie);
//
        movie = new Movie("Midsommar",
                "Horror",
                2019, "midsommar");
        movieList.add(movie);
//
        movie = new Movie("Nobody",
                "Action",
                2021, "nobody");
        movieList.add(movie);
//
        movie = new Movie("Pearl",
                "Horror",
                2022, "pearl");
        movieList.add(movie);
//
        movie = new Movie("Pulp Fiction",
                "Comedy",
                1994, "pulpfiction");
        movieList.add(movie);
//
        movie = new Movie("Tesla",
                "Drama",
                2020, "tesla");
        movieList.add(movie);
//
        movie = new Movie("The Witcher",
                "Action",
                2022, "thewitcher");
        movieList.add(movie);

        movieAdapter.notifyDataSetChanged();
    }
}