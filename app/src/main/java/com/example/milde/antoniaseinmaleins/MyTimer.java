package com.example.milde.antoniaseinmaleins;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by milde on 26.11.17.
 */

public class MyTimer extends CountDownTimer {
    private TextView mTextView = null;
    private MyTimerFinishedCallback finishCallback;


    public MyTimer(TextView tv, MyTimerFinishedCallback callback)
    {
        this (10000, 1000, tv, callback);
    }

    public MyTimer(long millisInFuture, long countDownInterval,
                   TextView mTextView,
                   MyTimerFinishedCallback callback) {
        super(millisInFuture, countDownInterval);
        this.mTextView = mTextView;
        this.finishCallback = callback;
    }

    /************/

    @Override
    public void onTick(long millisUntilFinished) {
        if (mTextView != null) {
            mTextView.setText("" + (millisUntilFinished / 1000) + " Sekunden");
        }
    }

    @Override
    public void onFinish() {
        if (mTextView != null) {
            mTextView.setText("Ende");
        }
        if (finishCallback != null) {
            finishCallback.finished();
        }
    }
}
