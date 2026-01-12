package com.example.mobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int totalPoints = 0;
    private int points = 0;

    private TextView pointsView;
    private TextView totalPointsView;

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

        Random random = new Random();
        Map<Integer, Integer> cubes = Map.of(
                1, R.drawable.k1,
                2, R.drawable.k2,
                3, R.drawable.k3,
                4, R.drawable.k4,
                5, R.drawable.k5,
                6, R.drawable.k6
        );

        LinearLayout imagesContainer = findViewById(R.id.images_container);
        this.pointsView = findViewById(R.id.pointsView);
        this.totalPointsView = findViewById(R.id.totalPointsView);

        List<ImageView> images = new ArrayList<>();
        for (int i = 0; i < imagesContainer.getChildCount(); i++) {
            View view = imagesContainer .getChildAt(i);
            if (view instanceof ImageView) images.add((ImageView) view);
        }

        Button button = findViewById(R.id.throw_cubes_button);
        button.setOnClickListener(v -> {
            List<Integer> drawnNumbers = new ArrayList<>();
            images.forEach(image -> {
                int number = random.nextInt(6) + 1;
                drawnNumbers.add(number);
                image.setImageResource(cubes.get(number));
            });
            this.calculatePoints(drawnNumbers);
            this.setTexts();
        });

        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(v -> {
            images.forEach(image -> image.setImageResource(R.drawable.question));
            this.points = 0;
            this.totalPoints = 0;
            this.setTexts();
        });
    }

    private void setTexts() {
        this.pointsView.setText(String.format("Wynik tego losowania: %d", this.points));
        this.totalPointsView.setText(String.format("Wynik gry: %d", this.totalPoints));
    }

    private void calculatePoints(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        numbers.forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));

        int points = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) continue;
            points += map.get(key)*key;
        }
        this.points = points;
        this.totalPoints += points;
    }
}