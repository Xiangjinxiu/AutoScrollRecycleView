package com.test.autoscroll;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AtuoRecyclerView mRecycleView;
    private List<String> mData = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = (AtuoRecyclerView) findViewById(R.id.arv);
        initData();
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            mData.add(new String("  RecyclerView item  -" + i));
        }

        View view = View.inflate(this, R.layout.listitem_layout, null);
        view.measure(0, 0);
        int measuredHeight = view.getMeasuredHeight();
        int height = mData.size() * measuredHeight;
        ViewGroup.LayoutParams layoutParams = mRecycleView.getLayoutParams();
        layoutParams.height = height;
        mRecycleView.setLayoutParams(layoutParams);

        RecyclerAdapter adpater = new RecyclerAdapter(this, mData);
        ScrollSpeedLinearLayoutManger layoutManger = new ScrollSpeedLinearLayoutManger(this);
        layoutManger.setSpeedSlow();
        layoutManger.setOrientation(LinearLayoutManager.VERTICAL);
        // mRvText.setLayoutManager(new LinearLayoutManager(TaskDetailActivity.this,LinearLayoutManager.VERTICAL,false));
        mRecycleView.setLayoutManager(layoutManger);
        mRecycleView.setAdapter(adpater);
        mRecycleView.smoothScrollToPosition(1000000);
    }


    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<String> datas;
        private LayoutInflater inflater;

        public RecyclerAdapter(Context context, List<String> data) {
            super();
            inflater = LayoutInflater.from(context);
            datas = data;
        }

        @Override
        public int getItemCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            ChildViewHolder holder = (ChildViewHolder) viewHolder;
            holder.itemTv.setText(datas.get(position % mData.size()));
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewHolder, int position) {
            View view = inflater.inflate(R.layout.listitem_layout, null);
            return new ChildViewHolder(view);
        }

    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTv;

        public ChildViewHolder(View view) {
            super(view);
            itemTv = (TextView) view;
        }

    }
}
