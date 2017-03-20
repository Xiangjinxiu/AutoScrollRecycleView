package com.test.autoscroll;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by XiangJIn on 2017/2/28.
 */

public class AtuoRecyclerView extends RecyclerView {
    public AtuoRecyclerView(Context context) {
        this(context, null);
    }

    public AtuoRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public AtuoRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }





    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_UP:
                startSmooth();
                break;
        }

        return super.onTouchEvent(e);
    }

    public void startSmooth() {
        smoothScrollToPosition(1000000);
    }
}
