package com.example.lab3;

import androidx.lifecycle.ViewModel;

public class StopwatchViewModel extends ViewModel {

    // Variable to track elapsed time
    private long elapsedTime = 0L;

    // TODO: Add methods to start, stop, and reset the stopwatch

    public long getElapsedTime() {
        return elapsedTime;
    }
}
