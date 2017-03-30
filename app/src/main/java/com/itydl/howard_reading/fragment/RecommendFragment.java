package com.itydl.howard_reading.fragment;


import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.itydl.howard_reading.base.BaseFragment;

/**
 * 推荐页面
 */
public class RecommendFragment extends BaseFragment {

    private TextView mTextView;

    @Override
    public View initView() {
        //Fragment中的上下文最好选择使用与之依托的Activity作为上下文
        mTextView = new TextView(getActivity());
        mTextView.setText("推荐页面");
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setTextColor(Color.RED);
        return mTextView;
    }
}
