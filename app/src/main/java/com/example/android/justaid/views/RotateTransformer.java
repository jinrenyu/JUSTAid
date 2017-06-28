package com.example.android.justaid.views;

import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by 浩然 on 2017-4-16.
 */

public class RotateTransformer implements ViewPager.PageTransformer {
    public static final float MAX_SCALE = 1.0f;
    public static final float MIN_SCALE = 0.75f;
    public static final float MIN_ALPHA = 0.7f;

    @Override
    public void transformPage(View page, float position) {
        page.setRotationY(position * -45);

        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }

        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;


        float scaleValue = MIN_SCALE + tempScale * slope;
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);
        page.setAlpha(MIN_ALPHA + tempScale * (1 - MIN_ALPHA));
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            page.getParent().requestLayout();
        }

    }
}