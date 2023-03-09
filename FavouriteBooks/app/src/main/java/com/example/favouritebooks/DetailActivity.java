package com.example.favouritebooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get the book object from the intent
        book = (Book) getIntent().getSerializableExtra(MainActivity.BOOK_OBJECT);

        if (book == null) {
            Toast.makeText(this, "Book object is null", Toast.LENGTH_SHORT).show();
            return;
        }

        SetInitData(book);

        processSpinner();

    }

    private void processSpinner()
    {
        Spinner spinner = findViewById(R.id.spNoOfBooksDetail);

        // Create an array adapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nums_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set Listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                int noOfBooks = (int) adapterView.getItemAtPosition(i);
                double subTotal = noOfBooks * book.getBookPrice();

                TextView tvSubTotal = findViewById(R.id.tvBookSubTotalValueDetail);
                tvSubTotal.setText(subTotal + "OMR");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void SetInitData(Book book) {
        TextView tvBookNameDetail = findViewById(R.id.tvBookNameDetail);
        TextView tvBookGenreDetail = findViewById(R.id.tvBookGenreDetail);
        TextView tvBookYearDetail = findViewById(R.id.tvBookYearDetail);
        TextView tvBookPriceDetail = findViewById(R.id.tvBookPriceForOneTicket);
        TextView tvBookDescDetail = findViewById(R.id.tvDescDetail);
        ImageView ivBookImageDetail = findViewById(R.id.ivBookImageDetail);

        setTitle(book.getBookName());
        tvBookNameDetail.setText(book.getBookName());
        tvBookGenreDetail.setText(book.getBookGenre());
        tvBookYearDetail.setText(book.getBookYear() + "");
        tvBookPriceDetail.setText(book.getBookPrice() + "OMR");
        tvBookDescDetail.setText(book.getBookDesc());

        int resId = getResources().getIdentifier(book.getBookImageName(), "drawable", getPackageName());
        ivBookImageDetail.setImageResource(resId);
    }
}