package com.example.mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Button confirmButton = findViewById(R.id.confirm_button);
        TextView message = findViewById(R.id.message);
        EditText emailInput = findViewById(R.id.email_input);
        EditText passwordInput = findViewById(R.id.password_input);
        EditText confirmPasswordInput = findViewById(R.id.confirm_password_input);

        confirmButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            if (!email.contains("@")) {
                message.setText("Nieprawidłowy adres e-mail!");
                return;
            }
            if (!passwordInput.getText().toString().equals(confirmPasswordInput.getText().toString())) {
                message.setText("Hasła się różnią");
                return;
            }
            message.setText(String.format("Witaj %s", email));
        });
    }
}