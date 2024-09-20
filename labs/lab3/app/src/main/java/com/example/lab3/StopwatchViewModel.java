package com.example.lab3;

import android.os.Handler;
import android.os.SystemClock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StopwatchViewModel extends ViewModel {

    private final MutableLiveData<Long> elapsedTime = new MutableLiveData<>();
    private final Handler handler = new Handler();
    private long startTime = 0L;
    private boolean isRunning = false;

    public StopwatchViewModel() {
        elapsedTime.setValue(0L); // Initialize with 0
    }

    public LiveData<Long> getElapsedTime() {
        return elapsedTime;
    }

    private final Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                long updatedTime = SystemClock.elapsedRealtime() - startTime;
                elapsedTime.setValue(updatedTime);
                handler.postDelayed(this, 10); // Update every 10ms
            }
        }
    };

    public void startStopwatch() {
        if (!isRunning) {
            startTime = SystemClock.elapsedRealtime() - elapsedTime.getValue();
            isRunning = true;
            handler.post(timerRunnable);
        }
    }

    public void stopStopwatch() {
        if (isRunning) {
            handler.removeCallbacks(timerRunnable);
            isRunning = false;
        }
    }

    public void resetStopwatch() {
        stopStopwatch();
        elapsedTime.setValue(0L);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        handler.removeCallbacks(timerRunnable);
    }
}
