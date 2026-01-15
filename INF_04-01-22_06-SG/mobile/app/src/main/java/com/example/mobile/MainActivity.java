package com.example.mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int likes = 0;

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
        Button likeButton = findViewById(R.id.like_button);
        Button deleteButton = findViewById(R.id.delete_button);

        likeButton.setOnClickListener(v -> {
            this.likes++;
            this.updateLikes();
        });
        deleteButton.setOnClickListener(v -> {
            this.likes--;
            if (this.likes < 0) this.likes = 0;
            this.updateLikes();
        });
    }

    private void updateLikes() {
        TextView textView = findViewById(R.id.likes_count_text);
        textView.setText(String.format("%d polubień", this.likes));
    }
}