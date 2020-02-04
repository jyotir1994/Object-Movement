package com.example.objectmovement;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private float mXDelta;
    private float mYDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mTextView = (TextView) findViewById(R.id.tv_1);
        TextView mTextView2 = (TextView) findViewById(R.id.tv_2);
        mTextView.setOnTouchListener(this);
        mTextView2.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                mXDelta = view.getX() - event.getRawX();
                mYDelta = view.getY() - event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                view.animate()
                        .x(event.getRawX() + mXDelta)
                        .y(event.getRawY() + mYDelta)
                        .setDuration(0)
                        .start();
                break;
        }
        return true;
    }
}
