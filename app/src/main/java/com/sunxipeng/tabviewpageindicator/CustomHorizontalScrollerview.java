package com.sunxipeng.tabviewpageindicator;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/26.
 */
public class CustomHorizontalScrollerview extends HorizontalScrollView {

    private final Context context;
    private LinearLayout linearLayout;
    private ViewPager viewpager;

    public CustomHorizontalScrollerview(Context context, AttributeSet attrs) {
        super(context, attrs);

        setFillViewport(true);
        this.context = context;
        addparentview();
        addtabview();
    }


    //添加linelayout
    private void addparentview() {

        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setDividerDrawable(getResources().getDrawable(R.drawable.divider));
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerPadding(20);
        HorizontalScrollView.LayoutParams hlLayoutParams = new HorizontalScrollView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(linearLayout, hlLayoutParams);
    }


    //添加tabview
    private void addtabview() {

        for (int i = 0; i < 10; i++) {
            TextView textView = new TextView(context);
            textView.setText("测试");
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundColor(Color.RED);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getscreenwidth() / 3, ViewGroup.LayoutParams.MATCH_PARENT);

            linearLayout.addView(textView, layoutParams);
        }
    }

    //android获取屏幕的宽度
    private int getscreenwidth() {

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }


    //核心代码
    //viewpager滚动，scroller作相应的滚动

    //点击相应的头部，viewpager进行相应的设置

    //设置viewpager
    public void setViewPager(ViewPager viewPager) {

        if (viewPager != null) {
            this.viewpager = viewPager;
        }
    }
}
