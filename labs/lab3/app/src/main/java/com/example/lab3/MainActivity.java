package com.example.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private StopwatchViewModel viewModel;
    private TextView tvTime;
    private Button btnStartStop, btnReset;
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(StopwatchViewModel.class);

        // Initialize UI components
        tvTime = findViewById(R.id.timerTV);
        btnStartStop = findViewById(R.id.startStopBtn);
        btnReset = findViewById(R.id.resetBtn);

        // Observe the elapsed time LiveData
        viewModel.getElapsedTime().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long time) {
                tvTime.setText(formatElapsedTime(time));
            }
        });

        // Set up button listeners for Start/Stop and Reset
        btnStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    viewModel.stopStopwatch();
                    btnStartStop.setText(R.string.start);
                } else {
                    viewModel.startStopwatch();
                    btnStartStop.setText(R.string.stop);
                }
                isRunning = !isRunning;
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.resetStopwatch();
                btnStartStop.setText(R.string.start);  // Reset to start button
                isRunning = false;
            }
        });
    }

    // Helper method to format elapsed time in HH:MM:SS
    private String formatElapsedTime(long elapsedTime) {
        int milliseconds = (int) (elapsedTime % 1000) / 100;
        int seconds = (int) (elapsedTime / 1000) % 60;
        int minutes = (int) (elapsedTime / (1000 * 60)) % 60;
        int hours = (int) (elapsedTime / (1000 * 60 * 60));
        return String.format(Locale.getDefault(), "%02d:%02d:%02d.%d", hours, minutes, seconds, milliseconds);
    }

}
