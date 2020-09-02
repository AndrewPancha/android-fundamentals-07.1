package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mTextView;

    public SimpleAsyncTask(TextView mTextView) {
        this.mTextView = new WeakReference<>(mTextView);
    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.get().setText(s);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random random = new Random();
        int n = random.nextInt(11);

        int s = n * 200;

        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Thread slept " + s + " milliseconds";
    }
}
