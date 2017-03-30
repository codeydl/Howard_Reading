package com.itydl.howard_reading.fragment;


import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.itydl.howard_reading.base.BaseFragment;

/**
 * 新闻页面
 */
public class NewsFragment extends BaseFragment {

    private TextView mTextView;

    @Override
    public View initView() {
        mTextView = new TextView(getActivity());
        mTextView.setText("新闻页面");
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setTextColor(Color.RED);
        return mTextView;
    }
}
