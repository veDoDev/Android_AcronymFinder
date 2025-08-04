package com.example.acronymfinder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etAcronymInput;
    private TextView tvFullFormOutput;

    private Button btnSearch, btnGetRandomAcronym;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etAcronymInput = findViewById(R.id.etAcronymInput);
        tvFullFormOutput = findViewById(R.id.tvFullFormOutput);
        btnSearch = findViewById(R.id.btnSearch);
        btnGetRandomAcronym = findViewById(R.id.btnGetRandomAcronym);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                MyDatabaseHelper db = new MyDatabaseHelper(MainActivity.this);
                String acronym = etAcronymInput.getText().toString().trim().toUpperCase();


                String fullform = db.getFullForm(acronym);

                if (fullform != null)
                    tvFullFormOutput.setText(fullform);
                else
                    tvFullFormOutput.setText("No match found.");


            }
        });

        btnGetRandomAcronym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper db = new MyDatabaseHelper(MainActivity.this);
                String acronym = db.getRandomAcronym(); // just the acronym
                if (acronym != null)
                    etAcronymInput.setText(acronym);
                else
                    etAcronymInput.setText("N/A");
            }
        });


    }
}