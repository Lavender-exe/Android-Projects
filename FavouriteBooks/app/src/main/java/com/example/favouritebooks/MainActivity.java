package com.example.favouritebooks;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener
{
    private List<Book> bookList = new ArrayList<>();
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        bookAdapter = new BookAdapter();

        setSamplebookData();
        /*
        Use this setting to improve performance if you know that changes
        in content do not change the layout size of the RecyclerView
        */
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // Add a default animator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // Add a divider line between the rows
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // Specify an adapter
        recyclerView.setAdapter(bookAdapter);

        bookAdapter.setItemClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(this, bookList.get(position).getBookName(), Toast.LENGTH_SHORT).show();
    }

    private class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>
    {
        private ItemClickListener itemClickListener;

        @NonNull
        @Override

        public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                View itemView = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.book_list_row,parent,false);

                return new BookViewHolder(itemView);
            }

        @SuppressLint("SetTextI18n")
        @Override

        public void onBindViewHolder(@NonNull BookViewHolder holder, int position)
            {
                Book book = bookList.get(position);

                holder.tvBookName.setText(book.getBookName());
                holder.tvBookGenre.setText(book.getBookGenre());
                holder.tvBookYear.setText(book.getBookYear() + "");
                @SuppressLint("DiscouragedApi") int resID = getResources().getIdentifier(book.getBookImageName(), "drawable", getPackageName());
                holder.ivBookImageName.setImageResource(resID);
            }

//      Removed if statement for performance
        @Override
        public int getItemCount() {
            return bookList.size();
        }

        private void setItemClickListener(ItemClickListener itemClickListener)
            {
                this.itemClickListener = itemClickListener;
            }
        public class BookViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

            private final TextView tvBookName;
            private final TextView tvBookGenre;
            private final TextView tvBookYear;
            private final ImageView ivBookImageName;

        public BookViewHolder(@NonNull View itemView)
                {
                    super(itemView);

                    tvBookName = itemView.findViewById(R.id.tvBookName);
                    tvBookGenre = itemView.findViewById(R.id.tvBookGenre);
                    tvBookYear = itemView.findViewById(R.id.tvBookYear);
                    ivBookImageName = itemView.findViewById(R.id.ivBookImage);
                    itemView.setOnClickListener(this);
                }

            @Override
            public void onClick(View view) {
                if (itemClickListener != null){
                    itemClickListener.onClick(view, getAdapterPosition());
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setSamplebookData(){
//      Book 1
        Book book = new Book(
                "Art of Human Hacking",
                "Security",
                2010,
                "artofhumanhacking");
        bookList.add(book);
//      Book 2
        book = new Book(
                "Science of Human Hacking",
                "Security",
                2018,
                "scienceofhumanhacking");
        bookList.add(book);
//      Book 3
        book = new Book(
                "Black Mass",
                "Security",
                2022,
                "blackmass");
        bookList.add(book);
//      Book 4
        book = new Book(
                "Blue Team Field Manual",
                "Security",
                2017,
                "btfm");
        bookList.add(book);
//      Book 5
        book = new Book(
                "Red Team Field Manual",
                "Security",
                2014,
                "rtfm");
        bookList.add(book);
//      Book 6
        book = new Book(
                "Physical Red Team Operations",
                "Security",
                2010,
                "physredteamops");
        bookList.add(book);
//      Book 7
        book = new Book(
                "Red Team Development and Operations",
                "Security",
                2020,
                "redteamdevops");
        bookList.add(book);
//      Book 8
        book = new Book(
                "Rootkit Arsenal",
                "Security",
                2012,
                "rootkitarsenal");
        bookList.add(book);
//      Book 9
        book = new Book(
                "The Witcher",
                "Thriller",
                2007,
                "thelastwish");
        bookList.add(book);
//      Book 10
        book = new Book(
                "The Abduction",
                "Mystery",
                2010,
                "theabduction");
        bookList.add(book);
//      Book 11
        book = new Book(
                "Peter Nimble",
                "Adventure",
                2011,
                "peternimble");
        bookList.add(book);
//      Book 12
        book = new Book(
                "James & The Giant Peach",
                "Children",
                1961,
                "jamesandthegiantpeach");
        bookList.add(book);
//      Book 13
        book = new Book(
                "Fantastic Mr Fox",
                "Children",
                1970,
                "fantasticmrfox");
        bookList.add(book);

        bookAdapter.notifyDataSetChanged();
    }
}