package com.example.stepcounter;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private TextView stepCountTextView;
    private Button resetButton;

    private int stepCount = 0;
    private float lastAcceleration = 0;
    private float currentAcceleration = 0;
    private float accelerationDifference = 0;
    private static final float STEP_THRESHOLD = 2.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepCountTextView = findViewById(R.id.stepCountView);
        resetButton = findViewById(R.id.resetBtn);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }

        resetButton.setOnClickListener(v -> {
            stepCount = 0;
            stepCountTextView.setText("Steps: " + stepCount);
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            currentAcceleration = (float) Math.sqrt(x * x + y * y + z * z);
            accelerationDifference = Math.abs(currentAcceleration - lastAcceleration);

            if (accelerationDifference > STEP_THRESHOLD) {
                stepCount++;
                stepCountTextView.setText("Steps: " + stepCount);
            }

            lastAcceleration = currentAcceleration;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Just here because an error was thrown otherwise
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (accelerometer != null) {
            sensorManager.unregisterListener(this, accelerometer);
        }
    }
}
