package com.example.favouritebooks;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    public static final String BOOK_OBJECT = "BookObject";
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
        //Toast.makeText(this, bookList.get(position).getBookName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailActivity.class);
        Book book = bookList.get(position);

        intent.putExtra(BOOK_OBJECT, book);

        startActivity(intent);
    }

    private class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
        private ItemClickListener itemClickListener;

        @NonNull
        @Override

        public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.book_list_row, parent, false);

            return new BookViewHolder(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override

        public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
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

        private void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public class BookViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

            private final TextView tvBookName;
            private final TextView tvBookGenre;
            private final TextView tvBookYear;
            private final ImageView ivBookImageName;

            public BookViewHolder(@NonNull View itemView) {
                super(itemView);

                tvBookName = itemView.findViewById(R.id.tvBookName);
                tvBookGenre = itemView.findViewById(R.id.tvBookGenre);
                tvBookYear = itemView.findViewById(R.id.tvBookYear);
                ivBookImageName = itemView.findViewById(R.id.ivBookImage);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onClick(view, getAdapterPosition());
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setSamplebookData() {
//      Book 1
        Book book = new Book(
                "Art of Human Hacking",
                "Security",
                2010,
                "artofhumanhacking",
                14.99,
                "From elicitation, pretexting, influence and manipulation all aspects of social engineering are picked apart, discussed and explained by using real world examples, personal experience and the science behind them to unraveled the mystery in social engineering. ");

        bookList.add(book);
//      Book 2
        book = new Book(
                "Science of Human Hacking",
                "Security",
                2018,
                "scienceofhumanhacking",
                20.49,
                "Social Engineering: The Science of Human Hacking reveals the craftier side of the hacker’s repertoire―why hack into something when you could just ask for access? Undetectable by firewalls and antivirus software, social engineering relies on human fault to gain access to sensitive spaces; in this book, renowned expert Christopher Hadnagy explains the most commonly-used techniques that fool even the most robust security personnel, and shows you how these techniques have been used in the past. The way that we make decisions as humans affects everything from our emotions to our security. Hackers, since the beginning of time, have figured out ways to exploit that decision making process and get you to take an action not in your best interest. This new Second Edition has been updated with the most current methods used by sharing stories, examples, and scientific study behind how those decisions are exploited.");
        bookList.add(book);
//      Book 3
        book = new Book(
                "Black Mass",
                "Security",
                2022,
                "blackmass",
                8.00,
                "Black Mass is VX Underground's First book which collects some malware samples and how to use them");
        bookList.add(book);
//      Book 4
        book = new Book(
                "Blue Team Field Manual",
                "Security",
                2017,
                "btfm",
                14.99,
                "The Blue Team Field Manual is a comprehensive guide to the art and science of network defense. It is a practical guide to the tools, techniques, and processes that are used to protect an organization's network infrastructure. The book is divided into three sections: the first section covers the fundamentals of network defense, the second section covers the tools and techniques used by the blue team, and the third section covers the processes and procedures that are used to manage a blue team. The book is written for network defenders, but it is also useful for anyone who is interested in learning more about network security.");
        bookList.add(book);
//      Book 5
        book = new Book(
                "Red Team Field Manual",
                "Security",
                2014,
                "rtfm",
                14.99,
                "The Red Team Field Manual is a comprehensive guide to the art and science of network attack. It is a practical guide to the tools, techniques, and processes that are used to attack an organization's network infrastructure. The book is divided into three sections: the first section covers the fundamentals of network attack, the second section covers the tools and techniques used by the red team, and the third section covers the processes and procedures that are used to manage a red team. The book is written for network attackers, but it is also useful for anyone who is interested in learning more about network security.");
        bookList.add(book);
//      Book 6
        book = new Book(
                "Physical Red Team Operations",
                "Security",
                2010,
                "physredteamops",
                16.99,
                "Physical Red Team Operations is a comprehensive guide to the art and science of physical security. It is a practical guide to the tools, techniques, and processes that are used to attack an organization's physical infrastructure. The book is divided into three sections: the first section covers the fundamentals of physical security, the second section covers the tools and techniques used by the red team, and the third section covers the processes and procedures that are used to manage a red team. The book is written for physical attackers, but it is also useful for anyone who is interested in learning more about physical security.");
        bookList.add(book);
//      Book 7
        book = new Book(
                "Red Team Development and Operations",
                "Security",
                2020,
                "redteamdevops",
                12.89,
                "Red Team Development and Operations is a comprehensive guide to the art and science of network attack. It is a practical guide to the tools, techniques, and processes that are used to attack an organization's network infrastructure. The book is divided into three sections: the first section covers the fundamentals of network attack, the second section covers the tools and techniques used by the red team, and the third section covers the processes and procedures that are used to manage a red team. The book is written for network attackers, but it is also useful for anyone who is interested in learning more about network security.");
        bookList.add(book);
//      Book 8
        book = new Book(
                "Rootkit Arsenal",
                "Security",
                2012,
                "rootkitarsenal",
                10.00,
                "Rootkit Arsenal is a comprehensive guide to the art and science of rootkit development. It is a practical guide to the tools, techniques, and processes that are used to develop rootkits. The book is divided into three sections: the first section covers the fundamentals of rootkit development, the second section covers the tools and techniques used by the red team, and the third section covers the processes and procedures that are used to manage a red team. The book is written for rootkit developers, but it is also useful for anyone who is interested in learning more about rootkit development.");
        bookList.add(book);
//      Book 9
        book = new Book(
                "The Witcher",
                "Thriller",
                2007,
                "thelastwish",
                9.99,
                "Andrzej Sapkowski’s The Last Wish introduced the world to the iconic monster hunter Geralt of Rivia; his beloved ward and the prophesied savior of the world, Ciri; and his ally and true love, the powerful sorceress Yennefer—and they took the world by storm. Now, experience the world of the Witcher like never before with this stunning deluxe hardcover edition of the story collection that started it all, featuring a beautiful new cover and eight gorgeous interior illustrations by a range of award-winning artists.\n");
        bookList.add(book);
//      Book 10
        book = new Book(
                "The Abduction",
                "Mystery",
                2010,
                "theabduction",
                20.89,
                "When his best friend, April, disappears from her bedroom in the middle of the night, no one, not even Theo Boone - who knows April better than anyone - has answers. As fear ripples through his small hometown and the police hit dead ends, it's up to Theo to use his legal knowledge and investigative skills to chase down the truth and save April. ");
        bookList.add(book);
//      Book 11
        book = new Book(
                "Peter Nimble",
                "Adventure",
                2011,
                "peternimble",
                12.99,
                "Peter Nimble and His Fantastic Eyes is a 2011 children's fantasy novel by Jonathan Auxier. It is the first book in the Peter Nimble series. The book was published by Candlewick Press on 1 March 2011. It was a 2012 Newbery Honor Book and a 2012 Michael L. Printz Honor Book. It was also a 2012 finalist for the Los Angeles Times Book Prize for Young Adult Literature and the 2012 winner of the Boston Globe–Horn Book Award for Fiction. ");
        bookList.add(book);
//      Book 12
        book = new Book(
                "James & The Giant Peach",
                "Children",
                1961,
                "jamesandthegiantpeach",
                9.99,
                "James and the Giant Peach is a children's novel by Roald Dahl. The story follows James Henry Trotter, whose parents are killed by a rhinoceros. He is sent to live with his two horrible aunts, Spiker and Sponge. After accidentally killing one of the aunts with a rhinoceros, James meets a giant anthropomorphic peach, who takes him on a journey across the ocean on his back. ");
        bookList.add(book);
//      Book 13
        book = new Book(
                "Fantastic Mr Fox",
                "Children",
                1970,
                "fantasticmrfox",
                9.99,
                "Fantastic Mr. Fox is a children's novel by Roald Dahl. It was first published in 1970 by Jonathan Cape in the United Kingdom, and in 1971 by Alfred A. Knopf in the United States. The story is about a crafty fox who outwits three local farmers. ");
        bookList.add(book);

        bookAdapter.notifyDataSetChanged();
    }
}