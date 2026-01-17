package com.example.mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int actualTextIndex = 0;
    private String[] texts = new String[]{"Dzień dobry", "Good morning", "Buenos dias"};

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

        SeekBar seekBar = findViewById(R.id.seekBar);
        Button button = findViewById(R.id.button);
        TextView textSize = findViewById(R.id.textView2);
        TextView textView = findViewById(R.id.textView3);

        textView.setText(this.texts[0]);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSize.setText("Rozmiar: " + progress);
                textView.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(v -> {
            this.actualTextIndex++;
            if (this.actualTextIndex > this.texts.length-1) {
                this.actualTextIndex = 0;
            }
            textView.setText(this.texts[this.actualTextIndex]);
        });
    }
}