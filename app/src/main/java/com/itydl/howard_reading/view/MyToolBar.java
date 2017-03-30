package com.itydl.howard_reading.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Toolbar;

/**
 * @author ydl
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyToolBar extends Toolbar {
    public MyToolBar(Context context) {
        this(context,null);
    }

    public MyToolBar(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public MyToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
