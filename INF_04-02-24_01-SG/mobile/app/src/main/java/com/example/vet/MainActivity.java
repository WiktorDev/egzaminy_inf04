package com.example.vet;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int selectedPetType = 0;

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

        String[] items = {"Pies", "Kot", "Świnka morska"};
        int[] maxAges = {18,20,9};


        SeekBar seekBar = findViewById(R.id.seekBar);
        Button button = findViewById(R.id.button);
        TextView petAge = findViewById(R.id.pet_age_text);
        EditText nameField = findViewById(R.id.nameEditText);
        EditText reasonField = findViewById(R.id.reason_field);
        EditText timeField = findViewById(R.id.time_field);

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            seekBar.setMax(maxAges[position]);
            this.selectedPetType = position;
        });
        listView.setAdapter(arrayAdapter);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                petAge.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Zapisana wizyta")
                    .setMessage(String.format(
                            "%s, %s, %d, %s, %s",
                            nameField.getText(),
                            items[this.selectedPetType],
                            seekBar.getProgress(),
                            reasonField.getText(),
                            timeField.getText()
                    ))
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}